/*
 * Danica Calusin
 * Jonathan Filion
 * Group 22
 * CS213 - Assignment 1: Song Lib
*/

package application;	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import view.SongLibController;


public class SongLib extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/SongLib.fxml"));
			
			AnchorPane root = (AnchorPane)loader.load();
			
			SongLibController songLibController = loader.getController();
			songLibController.start();
						
			Scene scene = new Scene(root,400,400);
			primaryStage.setTitle("Song Library");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
