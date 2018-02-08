package view;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import utility.SongDetails;

public class SongLibController {
	@FXML ListView<SongDetails> listView;
	@FXML Button add;
	@FXML Button delete;
	@FXML Button edit;
	@FXML TextField songDetails;
	
	private File songsFile; //file used to store songs 
	
	public void start(){
		
	}
	
	//action handler when buttons are pressed 
	public void changeScene(ActionEvent e){
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
