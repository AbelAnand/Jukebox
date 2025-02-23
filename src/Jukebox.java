import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jukebox {
    ArrayList<Playlist> jukebox = new ArrayList<>();

    public void listPlaylists() {
        if (!jukebox.isEmpty()) {
            for (int i = 0; i < jukebox.size(); i++) {
                System.out.println((i + 1) + ". Playlist Name: " + jukebox.get(i).getName());
            }
            System.out.println();
        }
        else {
            System.out.println("No playlists currently in jukebox.\n");
        }
    }

    public void listPlaylistsAndSongs() {
        if (!jukebox.isEmpty()) {
            for (int i = 0; i < jukebox.size(); i++) {
                System.out.print(i+1 + ". " + jukebox.get(i).getName() + "\n");
                jukebox.get(i).listSongs();
            }
            System.out.println();
        }
        else {
            System.out.println("No playlists currently in jukebox.\n");
        }
    }


    public void addPlaylistToJukebox() {
        System.out.print("Name the Playlist: ");
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        Playlist p = new Playlist(n);
        jukebox.add(p);
    }

    public void removePlaylistFromJukebox() {
        if (!jukebox.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            listPlaylists();
            System.out.print("Select Playlist to remove: ");
            int i = scanner.nextInt();
            jukebox.remove(i - 1);
            System.out.println();
            listPlaylists();
        }
        else {
            System.out.println("No playlists to remove.");
        }
    }

    public void playlistInteraction() {
        listPlaylistsAndSongs();
        Scanner scanner = new Scanner(System.in);
        System.out.print("What Playlist would you like to interact with: ");
        int i = scanner.nextInt();
            try {
            jukebox.get(i-1).playlistMenu();
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

    public void playAllSongs() {
        if (!jukebox.isEmpty()) {
            for (int i = 0; i < jukebox.size(); i++) {
                if (!jukebox.get(i).playlist.isEmpty()) {
                    jukebox.get(i).startPlaylist();
                }
            }
        }
        else {
            System.out.println("No playlists available\n\n");
        }
    }

    public void shuffleAllSongs() {
        ArrayList<Playlist> shuffled_jukebox = new ArrayList<>(jukebox);
        Collections.shuffle(shuffled_jukebox);

        if (!shuffled_jukebox.isEmpty()) {
            for (int i = 0; i < shuffled_jukebox.size(); i++) {
                if (!shuffled_jukebox.get(i).playlist.isEmpty()) {
                    shuffled_jukebox.get(i).shufflePlaylist();
                }
            }
        }
        else {
            System.out.println("No playlists available");
        }
    }

    public void jukeboxMenu() {
        boolean run = true;
        while (run) {
            listPlaylists();
            System.out.println("0. Quit program");
            System.out.println("1. Add playlist to jukebox");
            System.out.println("2. Remove playlist from jukebox");
            System.out.println("3. Play all songs");
            System.out.println("4. Shuffle all songs");
            System.out.println("5. Interact with playlist");
            Scanner scanner = new Scanner(System.in);
            System.out.print("What would you like to do: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    run = false;
                    break;
                case 1:
                    addPlaylistToJukebox();
                    break;
                case 2:
                    removePlaylistFromJukebox();
                    break;
                case 3:
                    playAllSongs();
                    break;
                case 4:
                    shuffleAllSongs();
                    break;
                case 5:
                    playlistInteraction();
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    playlistInteraction();
            }
        }
    }
}
