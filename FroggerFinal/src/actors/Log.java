package actors;

import javafx.scene.image.Image;


/*
 * This class generates the moving logs on the river for the player to stand on
 * @author Chew Jee Kian 10346178
 */

public class Log extends Actor {
	public static String LOG_3 = "file:src/resources/log3.png";
	
	private double speed;

	@Override
	public void act(long now) {
		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-180);
		if (getX() < -300 && speed < 0)
			setX(700);
	}

	
	public Log(int size, int xpos, int ypos, double s) {	
		setImage(new Image(LOG_3, size, size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;

	}

	public boolean getLeft() {
		return speed < 0;
	}
}
