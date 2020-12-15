package main;

import javafx.scene.image.Image;

public class Turtle extends Movement {
	
	private Image[] stageTurtles;
	


	public Turtle(int xpos, int ypos, double speed, int width, int height, boolean isSinkable) {
		super(xpos, ypos, speed);
		if(isSinkable) {
			stageTurtles = new Image[] {
				new Image(Turtle.class.getResource("file:src/resources/TurtleAnimation2Wet.png").toString(), width, height, true, true),	
				new Image(Turtle.class.getResource("file:src/resources/TurtleAnimation1.png").toString(), width, height, true, true),
				new Image(Turtle.class.getResource("file:src/resources/TurtleAnimation3Wet.png").toString(), width, height, true, true),
				new Image(Turtle.class.getResource("file:src/resources/TurtleAnimation4Wet.png").toString(), width, height, true, true)
			};
		}
		
		else {
			stageTurtles = new Image[] {
					new Image(Turtle.class.getResource("file:src/resources/TurtleAnimation2.png").toString(), width, height, true, true),	
					new Image(Turtle.class.getResource("file:src/resources/TurtleAnimation1.png").toString(), width, height, true, true),
					new Image(Turtle.class.getResource("file:src/resources/TurtleAnimation3.png").toString(), width, height, true, true),
			};
		}
		
		setImage(stageTurtles[0]);
	}

/**
 * For the moving turtles, it will cycle through its animation to submerge over time
 */
	
	@Override
	public void act(long now) {
		super.act(now);
		setImage(stageTurtles[(int) (now/900000000  % stageTurtles.length)]);
		setIsSafe(((int) (now/900000000  % stageTurtles.length) != 3));
	}
}