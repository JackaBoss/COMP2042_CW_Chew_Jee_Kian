package main;

import javafx.scene.image.Image;

/**
 * Defines an interface used for the death states of a frog
 */
public interface DeathState {
	 public abstract Image[] getFrames(int size);
}