package main;

import javafx.scene.image.Image;

public class End extends Actor {
	
	//changed to private
	private boolean activated = false;


	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image(End.class.getResource("file:src/resources/End.png").toString(), 70, 70, true, true));
	}

	public void setEnd() {
		setImage(new Image(End.class.getResource("file:src/resources/FrogEnd.png").toString(), 70, 70, true, true));
		activated = true;
	}

	public boolean isActivated() {
		return activated;
	}

}




