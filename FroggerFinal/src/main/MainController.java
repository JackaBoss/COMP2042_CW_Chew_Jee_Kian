package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;



public class MainController implements Initializable {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	
	
	public void CloseApp(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML
	public void StartButton(MouseEvent event) throws Exception{

//		Scene scene = ButtonStart.getScene();
//		Window window = scene.getWindow();
//		Stage stage = (Stage) window;
	}


	


}

