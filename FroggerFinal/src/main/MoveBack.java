package main;

import main.Player;

import javafx.scene.image.Image;

/**
 * Implements the logic for theplayer moving backwards
 */
public class MoveBack extends MoveState {		
	
	public MoveBack(MoveController base) {
		super(base);
	}

	public Image[] getFrames() {
		base.player.move(0, MoveController.yDisplacment);
		return new Image[] {
				 new Image(Player.class.getResource("file:src/resources/froggerDown.png").toString(), base.player.getSize(), base.player.getSize(), true, true),
				 new Image(Player.class.getResource("file:src/resources/froggerDownJump.png").toString(), base.player.getSize(), base.player.getSize(), true, true)		
		};  
	}		
}