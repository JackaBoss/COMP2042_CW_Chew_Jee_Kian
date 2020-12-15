package main;

public abstract class MoveState implements Framerate {
	protected MoveController base;
		
	public MoveState(MoveController base) {
		this.base = base;
	}
}