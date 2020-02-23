package com.mycompany.a1;

import java.util.Random;
import com.codename1.charts.models.*;
import com.codename1.charts.util.ColorUtil;


/**
 * The Class GameObject is the abstract class
 * for all the objects in this game.
 */
public abstract class GameObject {

	/** The color and size of object */
	private int size, color;
	
	/** The x and y coordinate of location of object 
	 * used in point class*/
	private float x, y;
	
	/** The location represented by point. */
	private Point location;

	/** The Constant WIDTH of the world. */
	public static final int WIDTH = 1000;
	
	/** The Constant HEIGHT of the world. */
	public static final int HEIGHT = 1000;

	/**
	 * Instantiates a new game object.
	 */
	public GameObject() {

	}

	/**
	 * Sets the location.
	 *
	 * @param x the x is the x coordinate of the location
	 * @param y the y is the y coordinate of the location
	 */
	public void setLocation(float x, float y) {
		this.location = new Point(x, y);
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;

	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public int getColor() {
		return color;

	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the x.
	 *
	 * @param x is the new x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Sets the y.
	 *
	 * @param y is the new y
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Sets the color.
	 *
	 * @param r the red int
	 * @param g the green int
	 * @param b the blue int
	 */
	public void setColor(int r, int g, int b) {
		color = ColorUtil.rgb(r, g, b);
	}

	/**
	 * Sets the size.
	 *
	 * @param size is the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Point getLocation() {
		return this.location;
	}

}
