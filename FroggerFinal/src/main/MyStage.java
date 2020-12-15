package main;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;




public class MyStage extends World{
	private Stage primaryStage;
	private MediaPlayer mediaPlayer;
	private Scene stagelvl = new Scene(this, BackgroundImage.width, BackgroundImage.height);
	private Game level;
	
	private static MyStage instance;
	
	//Private constructor
	private MyStage(Stage stage) throws IOException {
		primaryStage = stage;
		change("StartScreen");
		primaryStage.show();
	}
	
	public static MyStage getInstance(Stage stage) {
		if (instance == null && stage != null) {
			try {
				instance = new MyStage(stage);
			} 
			// Error checking
			catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return instance;
	}

	public static MyStage getInstance() {
		return instance;
	}
	
	
	public void change(GenerateLevel newLevel, Integer lives) throws IOException {
		primaryStage.setScene(levelScene);
		level = new Game(this, newLevel, lives);
	}
	
	
	//Scene changer
	
	
	public void change(String newScene){
		try {
			Scene ScenePlaceholder;
			ScenePlaceholder = new Scene(loadFXML(newScene),BackgroundImage.width, BackgroundImage.height);
			ScenePlaceholder.getStylesheets().add("style.css");
			primaryStage.setScene(tempScene);
		}
		
		//Debugging and error reporting
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void scoreBoard(String level, Integer score) {
		
		Scene tempScene;
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ScoreBoard.fxml"));
	
			tempScene = new Scene(fxmlLoader.load(),BackgroundImage.width, BackgroundImage.height);
			ScoreBoardController controller = fxmlLoader.<ScoreBoardController>getController();
			controller.setModel(level, score);
			
			tempScene.getStylesheets().add("style.css");
			primaryStage.setScene(tempScene);
			
		}
		
		//Debugging and error reporting
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	//Used to load up a new window from a custom .FXML file.
	 public Parent loadFXML(String fxml) throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		 return fxmlLoader.load();
	 }
	

	public void playMusic() {
		String musicFile = "src/resources/Frogger_Main_Song_Theme_(loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	}

	public void stopMusic() {
		if(mediaPlayer != null)
			mediaPlayer.stop();
	}

}
