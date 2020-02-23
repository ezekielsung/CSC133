package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

/**
 * The Class EnergyStation.
 */
public class EnergyStation extends Fixed {

	/** The capacity. */
	private int capacity;
	
	/** The random number object. */
	 Random ran = new Random();
	
	/**
	 * Creates the energy station and initializes the attributes.
	 */
	public EnergyStation() {
		this.setSize(ran.nextInt(40) + 10);
		this.setLocation(ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		this.setColor(51, 51, 51); // dark gray
		this.setCapacity(this.getSize());
	}
	
	/**
	 * Sets the capacity.
	 *
	 * @param capacity the new capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity=capacity;
	}
	
	/**
	 * Gets the capacity.
	 *
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return ("EnergyStation: loc="+getX()+","+getY()+" color= ["+ ColorUtil.red(getColor())+","+ColorUtil.green(getColor())+","+ColorUtil.blue(getColor())+"] size="+getSize()+" capacity="+getCapacity());
	}
}
