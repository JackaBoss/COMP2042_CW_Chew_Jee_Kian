package actors;

import javafx.scene.image.Image;


/*
 * This class acts as a constructor for the other objects, since there is more than 1 type of vehicle, this class is used to generate those moving vehicles as obstacles
 * With more time I could have converted the still turtle to use this class for more efficiency
 * @author Chew Jee Kian 10346178
 */

public class Obstacle extends Actor {
	private int speed;

	@Override
	public void act(long now) {
		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -50 && speed < 0)
			setX(600);
	}

	public Obstacle(String imageLink, int xpos, int ypos, int s, int width, int height) {
		setImage(new Image(imageLink, width, height, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
