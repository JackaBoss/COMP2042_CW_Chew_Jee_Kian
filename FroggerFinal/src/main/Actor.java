package main;

import javafx.scene.image.ImageView;
import java.util.ArrayList;


import main.World;


public abstract class Actor extends ImageView {

	public void move(double dx, double dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}

	public World getWorld() {
		return (World) getParent();
	}

	public double getWidth() {
		return this.getBoundsInLocal().getWidth();
	}

	public double getHeight() {
		return this.getBoundsInLocal().getHeight();
	}

	 public <A extends Actor> java.util.List<A> getIntersectingObjects(Class<A> cls){
	        ArrayList<A> someArray = new ArrayList<A>();
	        for (A actor: getWorld().getObjects(cls)) {
	            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
	                someArray.add(actor);
	            }
	        }
	        return someArray;
	    }
	    
	   
	    public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
	         return getIntersectingObjects(cls).get(0);
	    }
	}