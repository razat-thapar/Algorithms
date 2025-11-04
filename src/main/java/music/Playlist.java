package music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Playlist {
    private final List<Song> songs = new ArrayList<>();
    private WeightedShuffleEngine engine;

    public Playlist() {}

    public Playlist(List<Song> initialSongs) {
        if (initialSongs != null) {
            songs.addAll(initialSongs);
        }
    }

    /**
     * Initialize or reinitialize the WeightedShuffleEngine using the current songs.
     * Call this before calling getNextSong() to enable weighted shuffle behavior.
     */
    public void shuffle() {
        // pass a defensive copy so engine holds the current snapshot of song objects
        engine = new WeightedShuffleEngine(new ArrayList<>(songs));
    }

    /**
     * Get the next song from the engine. If shuffle() hasn't been called yet,
     * initialize the engine first.
     */
    public Song getNextSong() {
        if (engine == null) {
            shuffle();
        }
        return engine.nextSong();
    }

    public void addSong(Song s) {
        Objects.requireNonNull(s);
        songs.add(s);
        // rebuild engine to include the new song
        if (engine != null) shuffle();
    }

    public boolean removeSong(int songId) {
        boolean removed = songs.removeIf(s -> s.id == songId);
        if (removed && engine != null) shuffle();
        return removed;
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }
}