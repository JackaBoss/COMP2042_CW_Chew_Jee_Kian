package main;

import main.Player;

import javafx.scene.image.Image;

/**
 * Implements the logic for a frog walking forwards
 * @author psyjpf
 */
public class MoveFront extends MoveState {		
	
	public MoveFront(MoveController base) {
		super(base);
	}

	public Image[] getFrames() {
		base.player.move(0, -MoveController.yDisplacment);
		return new Image[] {
				 new Image(Player.class.getResource("file:src/resources/froggerUp.png").toString(), base.player.getSize(), base.player.getSize(), true, true),
				 new Image(Player.class.getResource("file:src/resources/froggerUpJump.png").toString(), base.player.getSize(), base.player.getSize(), true, true)			
		};  
	}		
}