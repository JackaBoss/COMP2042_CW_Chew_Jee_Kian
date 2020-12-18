package actors;

import javafx.scene.image.Image;

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
