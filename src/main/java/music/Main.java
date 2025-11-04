// java
// `src/main/java/music/Main.java`
package music;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        // create some songs (id, title, artist, weight)
        playlist.addSong(new Song(1, "Song A", "Artist A", 5.0));
        playlist.addSong(new Song(2, "Song B", "Artist B", 3.0));
        playlist.addSong(new Song(3, "Song C", "Artist C", 1.0));
        playlist.addSong(new Song(4, "Song D", "Artist D", 2.0));

        // initialize weighted shuffle engine
        playlist.shuffle();
        System.out.println("First shuffle - next 6 songs:");
        for (int i = 0; i < 6; i++) {
            Song s = playlist.getNextSong();
            System.out.println((i + 1) + ": " + s);
        }

        // add a new song and rebuild engine automatically
        System.out.println("\nAdding Song E and reshuffling:");
        playlist.addSong(new Song(5, "Song E", "Artist E", 4.0));
        playlist.shuffle(); // explicit call to show usage (playlist.addSong also rebuilds)
        for (int i = 0; i < 5; i++) {
            System.out.println("After add " + (i + 1) + ": " + playlist.getNextSong());
        }

        // remove a song and reshuffle
        System.out.println("\nRemoving Song B (id=2) and reshuffling:");
        playlist.removeSong(2);
        playlist.shuffle();
        for (int i = 0; i < 5; i++) {
            System.out.println("After remove " + (i + 1) + ": " + playlist.getNextSong());
        }
    }
}
