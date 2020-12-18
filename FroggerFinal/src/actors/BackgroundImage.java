package actors;

import javafx.scene.image.Image;

/**
 * Displays the background of the game
 * Changed values to width and height for easy maintainability
 * @author Chew Jee Kian 10346178
 */

public class BackgroundImage extends Actor {
		
	public static String BackGroundStageImg = "file:src/resources/background.png";
	public int width = 600;
	public int height = 800;

	@Override
	public void act(long now) {

	}

	public BackgroundImage() {

		setImage(new Image(BackGroundStageImg, width, height, true, true));

	}

}
