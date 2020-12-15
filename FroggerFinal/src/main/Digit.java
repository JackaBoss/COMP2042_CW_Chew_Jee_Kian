package main;

import javafx.scene.image.Image;

public class Digit extends Actor {


	// renamed n to name, dim to dimensions,
	public Digit(String name, int dimensions, int x, int y) {
		Image im1 = new Image(name, dimensions, dimensions, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}

}
