package main;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor {
		
	/**
	 * Displays the background of the game
	 * Changed values to width and height for easy maintainability
	 */
	public static final int width = 600;
	public static final int height = 800;

	@Override
	public void act(long now) {

	}

	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, width, height, true, true));

	}

}
