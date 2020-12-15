package main;

import main.Player;
import javafx.scene.image.Image;


public class MoveRight extends MoveState {

	public MoveRight(MoveController base) {
		super(base);
	}
	
	public Image[] getFrames() {
		base.player.move(MoveController.xDisplacment, 0);
		return new Image[] {
				 new Image(Player.class.getResource("file:src/resources/froggerRight.png").toString(), base.player.getSize(), base.player.getSize(), true, true),
				 new Image(Player.class.getResource("file:src/resources/froggerRightJump.png").toString(), base.player.getSize(), base.player.getSize(), true, true)			
		};  
	}	
}