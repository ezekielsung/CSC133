package com.mycompany.a1;

/**
 * The Class Movable.
 */
public abstract class Moveable extends GameObject {

	/** The speed and heading attribute of movable */
	private int heading,speed;
	
	/**
	 * Move.
	 */
	public abstract void move(); 
	
	/**
	 * Sets the heading.
	 *
	 * @param heading is the new heading
	 */
	public void setHeading(int heading) {
		this.heading=heading;
	}
	
	/**
	 * Sets the speed.
	 *
	 * @param speed is the new speed
	 */
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	
	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Gets the heading.
	 *
	 * @return the heading
	 */
	public int getHeading() {
		return heading;
	}
	
}