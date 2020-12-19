package application;

import java.io.IOException;
import actors.Player;
import actors.BackgroundImage;
import actors.Log;
import actors.Obstacle;
import actors.Turtle;
import actors.WetTurtle;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


/**
 * The main class of the game, calls the map and initiates the start of the game
 * @author Chew Jee Kian 10346178
 */

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Player animal;
	private Stage primaryStage;
		
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(" Frogger The Game");
		
		background = new MyStage();
		Scene scene = new Scene(background, 560, 800);
		BackgroundImage froggerback = new BackgroundImage();
		background.add(froggerback);
		
		/*
		 * Win condition / Frog Destination
		 * Modified some values to fix the visual glitch
		 */
		
		background.add(new GoalState(10, 96));
		background.add(new GoalState(131, 96));
		background.add(new GoalState(252, 96));
		background.add(new GoalState(370, 96));
		background.add(new GoalState(490, 96));
		
		/*
		 * 9th row of logs
		 */
		background.add(new Log(150, 0, 166, 0.75));
		background.add(new Log(150, 220, 166, 0.75));
		background.add(new Log(150, 440, 166, 0.75));

		/*
		 * 7th row of logs
		 */
		background.add(new Log(150, 0, 276, -2));
		background.add(new Log(150, 400, 276, -2));
		background.add(new Log(150, 800, 276, -2));
		/*
		 * 6th row of logs
		 */
		background.add(new Log(150, 50, 329, 0.75));
		background.add(new Log(150, 270, 329, 0.75));
		background.add(new Log(150, 570, 329, 0.75));
		/*
		 * 5th row of turtle backs
		 */
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		/*
		 * 4th row of turtle backs
		 */
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		
		animal = new Player("file:src/resources/froggerUp.png");
		background.add(animal = new Player("file:src/resources/froggerUp.png"));
		
		/*
		 * 1-4th row of obstacles
		 */
		background.add(new Obstacle("file:src/resources/truck1" + "Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/resources/truck1" + "Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/resources/truck1" + "Right.png", 600, 649, 1, 120, 120));

		background.add(new Obstacle("file:src/resources/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/resources/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/resources/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/resources/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/resources/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/resources/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/resources/car1Left.png", 500, 490, -5, 50, 50));
		

		background.add(new ScoreDisplay(0, 30, 360, 25));
		
		background.start();
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
		start();
	}
	

	public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (animal.changeScore()) {
					setScore(animal.getPoints());
				}
				
				if (animal.getStop()) {
					System.out.print("STOP:");
					background.stopMusic();
					stop();
					background.stop();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("You Have Won The Game!");
					alert.setHeaderText("Your High Score: " + animal.getPoints() + "!");
					alert.setContentText("Highest Possible Score: 800");
					alert.show();
				}
			}
		};
	}

	public void start() {
		background.playMusic();
		createTimer();
		timer.start();
	}

	public void stop() {
		timer.stop();
	}

	public void setScore(int number) {
		int shift = 0;
		while (number > 0) {
			int Modifiyer = number / 10;
			int FinalScore = number - Modifiyer * 10;
			number = Modifiyer;
			background.add(new ScoreDisplay(FinalScore, 30, 360 - shift, 25));
			shift += 30;
		}
	}	
}

