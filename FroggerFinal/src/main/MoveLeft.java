package main;

import main.Player;

import javafx.scene.image.Image;

/**
 * Implements the logic for a frog walking left
 * @author psyjpf
 */
public class MoveLeft extends MoveState {

	public MoveLeft(MoveController base) {
		super(base);
	}
	
	public Image[] getFrames() {
		base.player.move(-MoveController.xDisplacment, 0);
		return new Image[] {
				 new Image(Player.class.getResource("file:src/resources/froggerLeft.png").toString(),base.player.getSize(), base.player.getSize(), true, true),
				 new Image(Player.class.getResource("file:src/resources/froggerLeftJump.png").toString(), base.player.getSize(), base.player.getSize(), true, true)		
		};  
	}		

}