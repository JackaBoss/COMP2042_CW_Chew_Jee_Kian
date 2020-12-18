package actors;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor {
		
	/**
	 * Displays the background of the game
	 * Changed values to width and height for easy maintainability
	 * @Jack Chew 10346178
	 */
	public int width = 600;
	public int height = 800;

	@Override
	public void act(long now) {

	}

	public BackgroundImage() {

		setImage(new Image("file:src/resources/background.png", width, height, true, true));

	}

}
