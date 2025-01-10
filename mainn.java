import java.util.Scanner;
import java.util.ArrayList;

// Music class to represent individual songs
class Music {
    private String title;
    private String artist;
    private String genre;

    // Constructor to initialize song details
    public Music(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    // Getter methods for song details
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    // Display song details
    public void displaySongInfo() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Genre: " + genre);
    }
}

// MusicPlayer class to manage the playlist and control playback
class MusicPlayer {
    private ArrayList<Music> playlist;
    private int currentIndex;

    // Constructor to initialize an empty playlist
    public MusicPlayer() {
        playlist = new ArrayList<>();
        currentIndex = 0;
    }

    // Add a song to the playlist
    public void addSong(Music song) {
        playlist.add(song);
    }

    // Play the current song
    public void playSong() {
        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist.");
            return;
        }
        Music currentSong = playlist.get(currentIndex);
        currentSong.displaySongInfo();
        System.out.println("Playing: " + currentSong.getTitle());
    }

    // Play next song in the playlist
    public void nextSong() {
        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist.");
            return;
        }
        currentIndex = (currentIndex + 1) % playlist.size();
        playSong();
    }

    // Play previous song in the playlist
    public void previousSong() {
        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist.");
            return;
        }
        currentIndex = (currentIndex - 1 + playlist.size()) % playlist.size();
        playSong();
    }

    // Display all songs in the playlist
    public void showPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist.");
            return;
        }
        System.out.println("\nPlaylist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i).getTitle());
        }
    }

    // Check if the playlist is empty
    public boolean isEmpty() {
        return playlist.isEmpty();
    }
}

public class MusicPlayerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer musicPlayer = new MusicPlayer();
        boolean running = true;

        // Adding some songs to the playlist
        musicPlayer.addSong(new Music("Blinding Lights", "The Weeknd", "Pop"));
        musicPlayer.addSong(new Music("Shape of You", "Ed Sheeran", "Pop"));
        musicPlayer.addSong(new Music("Bohemian Rhapsody", "Queen", "Rock"));

        while (running) {
            // Display menu options
            System.out.println("\n--- Music Player ---");
            System.out.println("1. Play Song");
            System.out.println("2. Next Song");
            System.out.println("3. Previous Song");
            System.out.println("4. Show Playlist");
            System.out.println("5. Exit");

            // Get user input and handle menu selection
            System.out.print("Enter your choice: ");
            int choice = 0;

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        musicPlayer.playSong();
                        break;
                    case 2:
                        musicPlayer.nextSong();
                        break;
                    case 3:
                        musicPlayer.previousSong();
                        break;
                    case 4:
                        musicPlayer.showPlaylist();
                        break;
                    case 5:
                        System.out.println("Exiting Music Player.");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        scanner.close();
    }
}
