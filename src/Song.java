public class Song {
    private String song_name;
    private String artist_name;

    public Song(String song_name, String artist_name) {
        this.song_name = song_name;
        this.artist_name = artist_name;
    }

    public String getSongName() {
        return song_name;
    }

    public String getArtistName() {
        return artist_name;
    }

    public void playSong() {
        System.out.println("Now playing " + this.song_name + " by " + this.artist_name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Song over\n\n");
    }
}
