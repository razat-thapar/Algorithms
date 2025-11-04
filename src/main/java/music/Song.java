package music;
/**
 * Represents a song in the playlist.
 */
public class Song {
    public int id;
    public String title;
    public String artist;
    public double basePopularity; // Base popularity score
    public long lastPlayedAt;     // Timestamp of last play
    public int skipCount;         // Number of times skipped
    public boolean liked;         // Whether the user liked the song

    public Song(int id, String title, String artist, double basePopularity) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.basePopularity = basePopularity;
        this.lastPlayedAt = 0;
        this.skipCount = 0;
        this.liked = false;
    }
    @Override
    public String toString() {
        return String.format("Song{id=%d, title='%s', artist='%s', basePopularity=%.2f}", id, title, artist, basePopularity);
    }
}
