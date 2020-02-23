package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

/**
 * The Class Bases. Each base has a predetermined location and is placed throughout the game world. 
 * Cyborg's goal is to land on all the bases. 
 */
public class Bases extends Fixed {

	/** The Constant BASESIZE. */
	public static final int BASESIZE = 10;
	
	/** The sequence number. */
	private int sequenceNumber;


	
	/**
	 * Creates the base.
	 *
	 * @param x the x coordinate of location
	 * @param y the y coordinate of location
	 * @param sequence is the sequenceNumber of the base
	 */
	public  Bases(float x, float y, int sequence) {
		this.setSize(BASESIZE);
		this.setColor(255, 255, 0); // yellow
		this.setSequenceNumber(sequence);
		this.setLocation(x, y);
	}
	
	
	/**
	 * Gets the sequence number.
	 *
	 * @return the sequence number
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * Sets the color.
	 */
	public void setColor() {

	}

	/**
	 * Sets the sequence number.
	 *
	 * @param sequence the new sequence number
	 */
	public void setSequenceNumber(int sequence) {
		this.sequenceNumber = sequence;

	}

	/**
	 * Displays the attributes of base.
	 *
	 * @return the string that displays the attributes of base
	 */
	public String toString() {
		return ("Base: loc=" + getX() + "," + getY() + " color=" + ColorUtil.red(getColor()) + ","
				+ ColorUtil.green(getColor()) + "," + ColorUtil.blue(getColor()) + " size=" + getSize() + " seqNum="
				+ getSequenceNumber());
	}
}
