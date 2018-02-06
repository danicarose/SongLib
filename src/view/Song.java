package view;

public class Song {
	private String title;
	private String artist;
	private String album;
	private int year;
	
	
	public void setTitle(String title){
		this.title = title; 
	}
	
	public String getTitle(){
		return this.title; 
	}
	
	public void setArtist(String artist){
		this.artist = artist;
	}
	
	public String getArtist(){
		return this.artist;
	}
	
	public void setAlbum(String album){
		this.album = album;
	}
	
	public String getAlbum(){
		return this.album;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public int getYear(){
		return this.year;
	}
	
}
