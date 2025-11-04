package music;
import java.util.*;

/**
 * Weighted Shuffle Engine — maintains dynamic ordering of songs for playback.
 */
class WeightedShuffleEngine {
    /**
     * Entry stored in the PriorityQueue.
     * Each song can have multiple entries if its weight changes.
     */
    class SongEntry {
        int songId;
        double weight;
        long version;  // Unique per update

        public SongEntry(int songId, double weight, long version) {
            this.songId = songId;
            this.weight = weight;
            this.version = version;
        }
    }
    // --- Core Data ---
    private Map<Integer, Song> songMap = new HashMap<>();
    private Map<Integer, Long> latestVersion = new HashMap<>();
    private PriorityQueue<SongEntry> pq;
    private long versionCounter = 0;

    // --- Config ---
    private static final int WINDOW_SIZE = 50;  // local shuffle window
    private Random rand = new Random();

    public WeightedShuffleEngine(List<Song> songs) {
        // Base comparator: max heap by weight
        pq = new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight));

        // Initialize songs and heap
        for (Song s : songs) {
            songMap.put(s.id, s);
            addOrUpdateSong(s);
        }
    }

    /**
     * Compute the weight for a song dynamically.
     * This models real personalization logic.
     */
    private double computeWeight(Song s) {
        double recencyPenalty = Math.exp(-(System.currentTimeMillis() - s.lastPlayedAt) / 1e7);
        double skipPenalty = 1.0 / (1 + s.skipCount);
        double likeBoost = s.liked ? 1.2 : 1.0;
        double artistRandomness = 0.8 + 0.4 * rand.nextDouble(); // diversity noise

        return s.basePopularity * likeBoost * skipPenalty * artistRandomness * (1 - recencyPenalty);
    }

    /**
     * Insert or update a song’s entry in the PQ (lazy deletion).
     */
    private void addOrUpdateSong(Song s) {
        double newWeight = computeWeight(s);
        long newVersion = ++versionCounter;
        latestVersion.put(s.id, newVersion);
        pq.offer(new SongEntry(s.id, newWeight, newVersion));
    }

    /**
     * Pick the next song — skip stale entries (lazy deletion).
     */
    public Song nextSong() {
        while (!pq.isEmpty()) {
            SongEntry top = pq.poll();

            // Skip stale entries
            if (top.version < latestVersion.getOrDefault(top.songId, -1L))
                continue;

            // Found the next valid song
            Song s = songMap.get(top.songId);
            s.lastPlayedAt = System.currentTimeMillis();
            s.skipCount = 0; // reset skip counter for next weighting
            //addOrUpdateSong(s); // reinsert updated version (to simulate replay bias)
            return s;
        }
        return null; // exhausted
    }

    /**
     * When user skips or likes a song, weights need adjustment.
     */
    public void onUserFeedback(int songId, boolean liked, boolean skipped) {
        Song s = songMap.get(songId);
        if (s == null) return;
        if (liked) s.liked = true;
        if (skipped) s.skipCount++;
        addOrUpdateSong(s);
    }

    /**
     * Rebuild or compact PQ periodically (to clear stale entries).
     */
    public void compactHeap() {
        List<SongEntry> validEntries = new ArrayList<>();
        for (SongEntry e : pq) {
            if (e.version >= latestVersion.getOrDefault(e.songId, -1L))
                validEntries.add(e);
        }
        pq = new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight));
        pq.addAll(validEntries);
    }
}
