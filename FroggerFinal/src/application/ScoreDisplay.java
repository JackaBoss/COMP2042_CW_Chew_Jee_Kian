package application;

import actors.Actor;
import javafx.scene.image.Image;

/**
 * Displays the score for the game
 * Used to be called Digit
 * @author Chew Jee Kian 10346178
 */

public class ScoreDisplay extends Actor {
	int dim;
	Image im1;

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub

	}

	public ScoreDisplay(int n, int dim, int x, int y) {
		im1 = new Image("file:src/resources/" + n + ".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}

}
