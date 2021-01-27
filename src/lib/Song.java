package lib;

public class Song {
	
  
    private String title;
    private int duration; 
    private String artist;

    
  
    public Song() {
        this.title = "No Song";
        this.duration = 0;
        this.artist = "None";
    }

    public Song(String title, int duration, String artist) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
    }

   
    public void play() {
        System.out.println("Now Playing: " + this.toString());
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString() {
        return "Song:[title=" + title + ", duration=" + duration + ", artist=" + artist + "]";
    }
}
