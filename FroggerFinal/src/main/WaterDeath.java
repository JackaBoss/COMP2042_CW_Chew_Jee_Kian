package main;


import javafx.scene.image.Image;

/**
 * Implements the frames needed for the water death animation.
 */
public class WaterDeath implements DeathState{
	
	public Image[] getFrames(int size) {
		return new Image[] {
				new Image(DeathController.class.getResource("file:src/resources/waterdeath1.png").toString(), size, size, true, true),
				new Image(DeathController.class.getResource("file:src/resources/waterdeath2.png").toString(), size, size, true, true),
				new Image(DeathController.class.getResource("file:src/resources/waterdeath3.png").toString(), size, size, true, true),
				new Image(DeathController.class.getResource("file:src/resources/waterdeath4.png").toString(), size, size, true, true)
		};  
	}
	
}