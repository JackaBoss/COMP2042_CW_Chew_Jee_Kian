package application;

import actors.Actor;
import javafx.scene.image.Image;

/**
 * Displays the end goal area of the game
 * Used to be called End
 * @author Chew Jee Kian 10346178
 */

public class GoalState extends Actor {
	boolean activated = false;

	@Override
	public void act(long now) {
		// TODO Auto-generated method 
	}

	public GoalState(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/resources/End.png", 60, 60, true, true));
	}

	public void setEnd() {
		setImage(new Image("file:src/resources/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	public boolean isActivated() {
		return activated;
	}

}
