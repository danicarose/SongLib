/*
 * Danica Calusin
 * Jonathan Filion
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
	private File songsFile; //file used to store songs 
	
	/*
	 * (1) UNCOMMENT THIS TO TEST CODE
	 * SongDetails someSong = new SongDetails();
	 * SongDetails anotherSong = new SongDetails();
	 */

	public void start(){
		//create an ObservableList from an ArrayList
		
		//(1) FOR TESTING 
		//obsList = FXCollections.observableArrayList(someSong, anotherSong);
		obsList = FXCollections.observableArrayList();
		
		listView.setItems(obsList);
		listView.getSelectionModel().selectFirst(); //ensures first item in list is automatically selected at start
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
