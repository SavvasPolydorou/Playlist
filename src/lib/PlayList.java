package lib;


import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List;


public class PlayList {

	//Fields
    private String name; 
    private List<Song> songlist; 

    
 
    public PlayList() {
        this.name = "Untitled";
        songlist = new ArrayList<>();
    }

   
    public PlayList(String name) {
        this.name = name;
        songlist = new ArrayList<Song>();
    }

    
   
    public void setName(String name) {
        this.name = name;
    }
    
  
    public String getName() {
        return name;
    }
    
    /**Returns a string containing the playlist song data. */
    @Override
    public String toString() {
        return "PlayList:[name=" + name + ", songlist=" + songlist + "]";
    }

    
  
    public void addSong(Song s) {
        songlist.add(s);
    }

   
    public void removeSong(int i) {
        songlist.remove(i);
    }

   
     
    public int numberOfSongs() {
        return songlist.size();
    }
    
 
    public void clearPlayList() {
        songlist.clear();
    }
    
   
    public boolean isPlayListEmpty() {
    	return songlist.isEmpty();
    }
    
  
    public Song getSong(int i) {
        Song s = null;
        if (0 <= i && i < songlist.size()) {
            s = songlist.get(i);
        } else {
            s = null; // i is out of range
        }
        return s;
    }
    
   
    public int getTotalTime() {
      
    	return songlist.stream().mapToInt(s -> s.getDuration()).sum();
    }

 
    public void moveUp(int i) {
        if (i > 0 && i < songlist.size());  {
	        	Song s = songlist.get(i - 1);
	        	songlist.set(i-1,  songlist.get(i));
	        	songlist.set(i, s);
        }

    }
    
  
    public void moveDown(int i) {
        if (i >= 0 && i < songlist.size()-1);  {
	        	Song s = songlist.get(i + 1);
	        	songlist.set(i+1,  songlist.get(i));
	        	songlist.set(i, s);
        }
    }
    
   
    public void shufflePlaylist() {	
    	Collections.shuffle(songlist);
    }
    
   
    public void mergePlaylist(PlayList p) {
    	for (int i = 0; i < p.numberOfSongs(); i++) {
            songlist.add(p.getSong(i));
    	}    	
    }
    
    public void searchSongThatContains(String word)
    {
    	for(int i=0;i<songlist.size();i++)
    		if(songlist.get(i).getTitle().contains(word))
    		{
    			System.out.println(songlist.get(i));
    		}
    }
    public boolean searchSongByTitle(String title) {
 
    	return songlist.stream().anyMatch(s -> s.getTitle().equals(title));

    }
    
  
    public int countSongsWithDurationLessThan(int duration) {
    	
    	return (int) songlist.stream().filter(s -> s.getDuration() < duration).count();
    }
    

  
    public String getTrackListings() {
    	String s = "PlayList: " + this.name + "\n";
        
        for (int i = 0; i < songlist.size(); i++) {
            s = s + (i+1) + "\t" + songlist.get(i).toString() + "\n";
        }
        return s;       
    }
    
}
