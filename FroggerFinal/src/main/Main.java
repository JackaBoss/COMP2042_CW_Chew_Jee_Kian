package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application  {
		
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Stage
	 */
	@Override
	public void start(Stage primaryStagse) throws Exception {
		MyStage.getInstance(primaryStagse);
    }

}