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
	private File songLib; //file used to store songs 
	JSONObject root = new JSONObject();
	JSONArray songs = new JSONArray();

	@SuppressWarnings("unchecked")
	public void start(){
		//create an ObservableList from an ArrayList
		root.put("songs", songs);
		
		obsList = FXCollections.observableArrayList();
		
		listView.setItems(obsList);
		//ensures first item in list is automatically selected at start
		//need to write code for the listener 
	}
	
	
	/*
	 * creates JSON file and then parses JSON objects into a JSONarray that will hold the song objects
	 * song objects are then parsed to the obsList 
	 */
	
	//Adds a song to the song list display	
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
		songLib = new File("songLib.json");//need to import JSON library
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
	
	String songName=txt_name.getText().toString();
	String artistName=txt_artist.getText().toString();
	String albumName=txt_album.getText().toString();
	String songYearTxt=txt_year.getText().toString();
	int songYear=Integer.parseInt(songYearTxt);
	
	JSONObject songObject = new JSONObject();
	songObject.put("song name", songName);
	songObject.put("artist name", artistName);
	songObject.put("album name", albumName);
	songObject.put("year", songYear);
	
	songs.add(songObject);
	
	songFileHandler();
	songDisplay();
	listView.getSelectionModel().selectFirst();
	}
	
	@FXML
	private void onClick_delete(){
		
	}
	
	@FXML
	private void onClick_edit(){
		
	}
}
