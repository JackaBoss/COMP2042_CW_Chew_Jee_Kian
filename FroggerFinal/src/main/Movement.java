package main;

import main.Act;
import main.Actor;
import main.BackgroundImage;
import javafx.scene.image.Image;


public class Movement extends Actor implements Act {
	
	/**
	 * Speed of object
	 */
	private double speed;
	/**
	 * If the player collides with this will it kill the player.
	 */
	private boolean isSafe = true;

	
	public Movement(String imageLink, int xpos, int ypos, int size,  double speed, boolean isSafe) {
		this(xpos,ypos, speed);
		setIsSafe(isSafe);
		setImage(new Image(imageLink, size,size, true, true));
	}
	
	/**
	 * Constructs a new panning actor
	 * xpos states the X position of the sprite
	 * ypos states the Y position of the sprite
	 * speed states the speed at which the sprite moves
	 */
	protected Movement(int xpos, int ypos, double speed) {
		setX(xpos);
		setY(ypos);
		setSpeed(speed);
	}
	
	
	/**
	 * Defines what the actor should do each frame, this is abstracted out, when an actor moves off screen
	 * then move the actor back to the opposite side of the screen.
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
	
		if (getX()> BackgroundImage.width && speed>0)
			setX(-getWidth());
		if (getX()< -getWidth() && speed<0)
			setX(BackgroundImage.width );
	}
	/**
	 * This is used for when the player is on top of a log or turle so that the player can move with the panning obstacle.
	 * @return the speed of the current actor
	 */
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * @param speed sets the speed of the object.
	 */
	protected void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/**
	 * @return If the Actor is safe or not too touch
	 */
	public boolean isSafe() {
		return isSafe;
	}

	/**
	 * @param isSafe Is this a safe object to touch or not.
	 */
	protected void setIsSafe(boolean isSafe) {
		this.isSafe = isSafe;
	}
}