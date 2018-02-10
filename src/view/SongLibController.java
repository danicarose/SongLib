/*
 * Danica Calusin
 * Jonathan Filion
 * Group 22
 * CS213 - Assignment 1: Song Lib
 */

package view;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import utility.SongDetails;

public class SongLibController {
	@FXML ListView<SongDetails> listView; //already initialized in fxml file--don't need to create an instance 
	@FXML Button add;
	@FXML Button delete;
	@FXML Button edit;
	@FXML TextField songDetails;
	
	private ObservableList<SongDetails> obsList;
	private File songLib; //file used to store songs 
	
	
	//(1) UNCOMMENT THIS TO TEST CODE
	SongDetails someSong = new SongDetails();
	SongDetails anotherSong = new SongDetails();
	 

	public void start(){
		//create an ObservableList from an ArrayList
		
		//(1) FOR TESTING 
		obsList = FXCollections.observableArrayList(someSong, anotherSong);
		
		//for actual use in application 
		//obsList = FXCollections.observableArrayList();
		
		songFileHandler();
		
		
		
		listView.setItems(obsList);
		listView.getSelectionModel().selectFirst(); //ensures first item in list is automatically selected at start
		//need to write code for the listener 
	}
	
	
	/*
	 * creates JSON file and then parses JSON objects into a JSONarray that will hold the song objects
	 * song objects are then parsed to the obsList 
	 */
	private void songFileHandler(){
		songLib = new File("songLib.json"); //need to import JSON library
	}
	
	//action handler when buttons are pressed 
	public void eventHandler(ActionEvent e){
		Button b = (Button)e.getSource();
		if(b == add){
			
		}else if(b == delete){
			
		}else if(b == edit){
			
		}else{
			//
		}	
	}
	
	private void add(){
	
	}
	
	private void delete(){
		
	}
	
	private void edit(){
		
	}
}
