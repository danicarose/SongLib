/*
 * Danica Calusin
 * Jonathan Filion
 * Group 22
 * CS213 - Assignment 1: Song Lib
 */

package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import utility.SongDetails;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class SongLibController {
	@FXML ListView<String> listView; //already initialized in fxml file--don't need to create an instance 
	@FXML Button btn_add;
	@FXML Button btn_delete;
	@FXML Button btn_edit;
	@FXML TextField txt_name;
	@FXML TextField txt_artist;
	@FXML TextField txt_album;
	@FXML TextField txt_year;
	
	private ObservableList<String> obsList;
	private File songLib=new File("songLib.json"); //file used to store songs 
	JSONObject root = new JSONObject();
	JSONArray songs = new JSONArray();

	@SuppressWarnings("unchecked")
	public void start(){
		//create an ObservableList from an ArrayList
		root.put("songs", songs);
		
		obsList = FXCollections.observableArrayList();
		songDisplay();
		listView.setItems(obsList.sorted());
		listView.getSelectionModel().selectFirst();
		//ensures first item in list is automatically selected at start
		//need to write code for the listener 
	}
	
	
	/*
	 * creates JSON file and then parses JSON objects into a JSONarray that will hold the song objects
	 * song objects are then parsed to the obsList 
	 */
	
//Displays songs by parsing JSON then going through list
private void songDisplay() {
	JSONParser parser = new JSONParser();
		
		try 
		{
			JSONObject p = (JSONObject) parser.parse(new FileReader("songLib.json"));
			JSONArray songDisp =(JSONArray) p.get("songs");
			
			for(int i=0; i< songDisp.size();i++) {
				JSONObject songDisplay= (JSONObject) songDisp.get(i);
				String sName = (String) songDisplay.get("song name");
				String arName =(String) songDisplay.get("artist name");
				obsList.add(sName + " by " + arName);
			}
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
	}

//Writes song to json file
	private void songFileHandler(){
		try(FileWriter writer = new FileWriter(songLib)){
			writer.write(root.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@FXML
	//adds song to json file and makes call
	private void onClick_add(ActionEvent e){
		String songName="";
		String artistName="";
		String albumName="";
		String songYearTxt="";
		int songYear; 
		JSONObject songObject = new JSONObject();
		
		//Checks if required song or artist fields are empty
		if ((txt_name.getText().toString() == null ||txt_artist.getText().toString()==null) ||
				(txt_name.getText().trim().isEmpty() || txt_artist.getText().trim().isEmpty())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText("You must enter a song name and artist name");
			alert.showAndWait();
		}else {
			songName=txt_name.getText().toString();
			artistName=txt_artist.getText().toString();
			songObject.put("song name", songName);
			songObject.put("artist name", artistName);
		}
		
		//Checks if album field is empty
		if(!(txt_album.getText().toString().trim().isEmpty() || txt_album.getText().toString()==null)) {
			albumName=txt_album.getText().toString();
			songObject.put("album name", albumName);
		}
		
		//Checks if song field is empty
		if(!(txt_album.getText().toString().trim().isEmpty() || txt_album.getText().toString()==null)) {
			songYearTxt=txt_year.getText().toString();
			songYear=Integer.parseInt(songYearTxt);
			songObject.put("year", songYear);
		}
	
	//If duplicate song does not add
	boolean songDup = duplicate(songObject);
	if(songDup) {
		songs.add(songObject);
		obsList.add(songName + " by " + artistName);
		songFileHandler();
		listView.getSelectionModel().select(songName+ " by " +artistName);
	}else {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText(null);
		alert.setContentText("Sorry, that song is already in your library");
		alert.showAndWait();
	}
		//clear textboxes once song has been added
		txt_name.clear();
		txt_artist.clear();
		txt_album.clear();
		txt_year.clear();
	}
	
	@FXML
	private void displayDetails(){
		int index = listView.getSelectionModel().getSelectedIndex();
		JSONParser parser = new JSONParser();
		
		try 
		{
			JSONObject p = (JSONObject) parser.parse(new FileReader("songLib.json"));
			JSONArray songDisp =(JSONArray) p.get("songs");
			
			/*for(int i=0; i< songDisp.size();i++) {
				JSONObject songDisplay= (JSONObject) songDisp.get(i);
				String sName = (String) songDisplay.get("song name");
				String arName =(String) songDisplay.get("artist name");
				obsList.add(sName + " by " + arName);
			}*/
			
			JSONObject songDetailObj = (JSONObject) songDisp.get(index);
			String sName = (String) songDetailObj.get("song name");
			String arName = (String) songDetailObj.get("artist name");
			String year = (String) songDetailObj.get("year");
			String album = (String) songDetailObj.get("album");
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
	}
	
	@FXML
	private void onClick_delete(){
		
	}
	
	@FXML
	private void onClick_edit(){
		//get index of selected song item
		int index = listView.getSelectionModel().getSelectedIndex();
		
		
		

		//clear textboxes once song has been edited
		txt_name.clear();
		txt_artist.clear();
		txt_album.clear();
		txt_year.clear();
		
		
	}
	private boolean duplicate(JSONObject songObject) {
		JSONParser parser = new JSONParser();
		try 
		{
			JSONObject p = (JSONObject) parser.parse(new FileReader("songLib.json"));
			JSONArray duplicateCheck =(JSONArray) p.get("songs");
			
			for(int i=0; i< duplicateCheck.size();i++) {
				JSONObject duplicate= (JSONObject) duplicateCheck.get(i);
				String sName = (String) duplicate.get("song name");
				String arName =(String) duplicate.get("artist name");
				
				String sName2= (String) songObject.get("song name");
				String arName2= (String) songObject.get("artist name");
				
				if(sName.equalsIgnoreCase(sName2)&&arName.equalsIgnoreCase(arName2)) {
					return false;
			}
		}
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		return true;
	}
}
