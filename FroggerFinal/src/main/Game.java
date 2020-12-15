package main;

import java.util.ArrayList;

import main.Actor;
import main.BackgroundImage;
import main.Digit;
import main.Player;
import main.MyStage;
import main.Observer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class Game implements Observer {
	
	private GenerateLevel mapData; 
	private MyStage base;
	private Player frog;
	private ArrayList<Digit> hearts = new ArrayList<Digit>();

	
	public Game(MyStage base, GenerateLevel LevelToMake, Integer Lives) {
		this.base = base;
		mapData = LevelToMake;
		frog = new Player(Player.class.getResource("froggerUp.png").toString(), Lives, this, mapData.getWaterLevel());
		base.add(frog);	
		base.add(new Digit(Actor.class.getResource("0.png").toString(), 30, 500, 25));

		generateHeartsOverlay(Lives);
	
		if(mapData.getPlayMusic())
			base.playMusic();
		
		base.start();
	}
	
	
	
	
	//Implements the observer pattern to calculate the score
	
	@Override
	public void update() {
		updateScore();
    	hideHearts();
    	checkGameOver();
    	checkEnd();     	
	}
	
	
	private void generateHeartsOverlay(Integer Lives) {
		if(Lives != null) {
			int heartSize = Lives < 10 ? 30 : 25;
			for(int i = 0; i <Lives; i++) {
				hearts.add(new Digit(Actor.class.getResource("heart.png").toString(),heartSize, 10  + (i*heartSize), BackgroundImage.height - 50));
				base.add(hearts.get(i));			
			}
		}
	}
	
	//Score updater
	private void updateScore() {
		int n = frog.getPoints();
		int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  base.add(new Digit(Actor.class.getResource(k + ".png").toString(), 30, 500 - shift, 25));
    		  shift+=30;
    	}
	}
	//Shows how many hearts the player has left
	private void hideHearts() {
		if(frog.getLives() != null) {
    		for(int i = frog.getLives(); i < hearts.size(); i++) {
    			hearts.get(i).setImage(null);		
    		}
    	}
	}
	
	//Final Score calculator
	public int calculateFinalScore() {
		return frog.getPoints() + (frog.getLives() != null ? (frog.getLives()/hearts.size()) * 25 : 0);
	}
	
	
	//Checks if the game has ended (win)
	public void checkEnd() {
		if(mapData.isEndGoalComplete()) {
			base.stopMusic();
			base.stop();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("You Have Won The Game!");
			alert.setHeaderText("Your High Score: "+ calculateFinalScore() +"!");
			alert.setContentText("Try and beat it!");
			alert.show();
			MyStage.getInstance().scoreBoardShow(mapData.getClass().getName(), calculateFinalScore());
		}	
	}
	
	
	//Checks if the game has ended (lose)
	public void checkGameOver() {
		if(frog.getLives() != null && frog.getLives() == 0) {
			base.stopMusic();
			base.stop();
			Alert alert = new Alert(AlertType.INFORMATION);s
			alert.setTitle("Game Over");
			alert.setHeaderText("Game Over!");
			alert.setContentText("Better Luck Next Time!");
			alert.show();
			MyStage.getInstance().change("StartScreen");
		}
	}
		

}
