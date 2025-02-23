import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Playlist {
    private String playlist_name;
    public ArrayList<Song> playlist = new ArrayList();


    public Playlist(String playlist_name) {
        this.playlist_name = playlist_name;
    }
    
    public void addSongToPlaylist() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Song name: ");
        String song_name = scanner.nextLine();
        System.out.print("Song Artist: ");
        String song_artist = scanner.nextLine();
        Song s = new Song(song_name, song_artist);
        playlist.add(s);
        System.out.println();
    }

    public void listSongs() {
        if (!playlist.isEmpty()) {
            System.out.println("Playlist Name: " + playlist_name);
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i).getSongName() + " by: " + playlist.get(i).getArtistName());
            }
            System.out.println();
        }
        else {
            System.out.println("No songs in playlist.");
        }
    }

    public void listSongsJB() {
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(playlist.get(i).getSongName() + " by: " + playlist.get(i).getArtistName());
        }
    }

    public void removeSongFromPlaylist() {
        if (!playlist.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            listSongs();
            System.out.print("Select song to remove: ");
            int i = scanner.nextInt();
            try {
            playlist.remove(i - 1);
            System.out.println();
            listSongs();
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Enter a valid choice next time");
                try {
                        Thread.sleep(1000);
                    } catch (InterruptedException er) {
                        er.printStackTrace();
                }
            }
        }
        else {
            System.out.println("No songs in playlist.\n");
        }
    }

    public void startPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        }
        else {
            for (int i = 0; i < this.playlist.size(); i++) {
                this.playlist.get(i).playSong();
            }
        }
    }

    public void shufflePlaylist() {
        ArrayList<Song> shuffled_playlist = new ArrayList<>(playlist);
        Collections.shuffle(shuffled_playlist);
        if (shuffled_playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        }
        else {
            for (int i = 0; i < shuffled_playlist.size(); i++) {
                shuffled_playlist.get(i).playSong();
            }
        }
    }

    public void playSongFromPlaylist() {
        if (!playlist.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            listSongs();
            System.out.print("Select song to play: ");
            int i = scanner.nextInt();
            playlist.get(i - 1).playSong();
        }
        else {
            System.out.println("No songs in playlist.");
        }
    }

    public String getName() {
        return playlist_name;
    }
    
    public void playlistMenu() {
        boolean run = true;
        while (run) {
            listSongs();
            System.out.println("0. Back");
            System.out.println("1. Add song to playlist");
            System.out.println("2. Remove song from playlist");
            System.out.println("3. Start playlist");
            System.out.println("4. Shuffle playlist");
            System.out.println("5. Play song from playlist");
            Scanner scanner = new Scanner(System.in);
            System.out.print("What would you like to do: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    run = false;
                    break;
                case 1:
                    addSongToPlaylist();
                    break;
                case 2:
                    removeSongFromPlaylist();
                    break;
                case 3:
                    startPlaylist();
                    break;
                case 4:
                    shufflePlaylist();
                    break;
                case 5:
                    playSongFromPlaylist();
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    playlistMenu();
            }
        }
    }
}
