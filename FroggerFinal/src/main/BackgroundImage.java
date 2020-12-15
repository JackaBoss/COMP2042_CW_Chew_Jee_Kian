package main;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor {

	public static final int width = 600;
	public static final int height = 800;

	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, width, height, true, true));

	}

}
