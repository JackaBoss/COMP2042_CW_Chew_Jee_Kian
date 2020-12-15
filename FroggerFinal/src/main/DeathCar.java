package main;

import javafx.scene.image.Image;

/**
 * For the death animation
 */
public class DeathCar implements DeathState  {	
	
	public Image[] getFrames(int size) {
		return new Image[] {
				new Image(DeathController.class.getResource("file:src/resources/cardeath1.png").toString(), size, size, true, true),
				new Image(DeathController.class.getResource("file:src/resources/cardeath2.png").toString(), size,size, true, true),
				new Image(DeathController.class.getResource("file:src/resources/cardeath3.png").toString(), size, size, true, true)
		};  
	}		
}