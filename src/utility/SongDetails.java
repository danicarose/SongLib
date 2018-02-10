/*
 * Danica Calusin
 * Jonathan Filion
 * CS213 - Assignment 1: Song Lib
 */

package utility;

public class SongDetails {
	private String title;
	private String artist;
	private String album;
	private String year;
	
	
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
	
	public void setYear(String year){
		this.year = year;
	}
	
	public String getYear(){
		return this.year;
	}
	
/*	
	//why is this not showing up on the GUI 
	public String toString(){
		return getTitle();
	}*/
}


