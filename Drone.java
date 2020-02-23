package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

/**
 * The Class Drone.Drone moves on its own randomly and acts as
 * an obstacle for the cyborg. If collision happens, the drone
 * will cause damage to the cyborg. 
 */
public class Drone extends Moveable {
	 Random ran = new Random();
	
	 /**
		 * Creates the drone and initializes the attributes.
		 */
	public Drone() {
		this.setSize(ran.nextInt(40) + 10);
		this.setLocation(ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		this.setSpeed(5);
		this.setColor(51, 204, 255); // light blue
		this.setHeading(ran.nextInt(359));
	}
	
	
	/**
	 * The drone moves by having a random heading from -5 to 5. With that heading and
	 * speed, new location is calculated and is set for drone. 
	 */
		
	public void move() {
		Random ran = new Random();
		int tempHeading=ran.nextInt(10)-5;
		this.setHeading(this.getHeading()+tempHeading);
		float deltaX=(float) (Math.cos(Math.toRadians(90.0-this.getHeading()))*this.getSpeed());
		float deltaY =(float) (Math.sin(Math.toRadians(90.0-this.getHeading()))*this.getSpeed());	
		if ((this.getX()+deltaX) < 1000 && (this.getX()+deltaX)>0 && (this.getY()+deltaY)<1000 && (this.getY()+deltaY)>0) {
			this.setLocation(this.getX()+deltaX, this.getY()+deltaY);
		}
		
		
	
	}
	
	/**
	 * Sets the color.
	 */
	public void setColor() {
		
	}
	
	/**
	 * Displays the attributes and status of Drone. 
	 *
	 * @return the string holding the status
	 */
	public String toString() {
		return ("Drone: loc="+Math.round(getX()*10.0)/10.0+","+Math.round(getY()*10.0)/10.0+" color= ["+ ColorUtil.red(getColor())+","+ColorUtil.green(getColor())+","+ColorUtil.blue(getColor())+"] heading="+getHeading()+ " speed="+getSpeed()+" size="+getSize());
	}
}
