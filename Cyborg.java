package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;


/**
 * The Class Cyborg. Cyborg is a movable object that also has the ability to steer. The attributes
 * of Cyborg includes a steering direction, maximum speed, energy level, energy consumption rate, damage level and last base reached. Their
 * goal is to travel to each base in order while not getting damaged, running out of energy or running out of lives.  
 */
public class Cyborg extends Moveable implements ISteerable {
	
	/** The random number object. */
	Random ran = new Random();
	
	public static final int CYBORGSIZE = 40;
	/** The attributes of a Cyborg */
	private int steeringDirection=0, maximumSpeed, energyLevel, energyConsumptionRate, damageLevel, lastBasedReached, damagedMaxSpeed;
	
	
	/**
	 * Move of Cyborg. It takes the sum of steering direction and heading to determine
	 * the new location of the cyborg and sets the new location to that new position.
	 */
	public void move() {
		this.setHeading(this.getHeading()+steeringDirection);
		float deltaX=(float) (Math.cos(Math.toRadians(90.0-this.getHeading()))*this.getSpeed());
		float deltaY =(float) (Math.sin(Math.toRadians(90.0-this.getHeading()))*this.getSpeed());	
		if ((this.getX()+deltaX) < 1001 && (this.getX()+deltaX)>-1 && (this.getY()+deltaY)<1001 && (this.getY()+deltaY)>-1) {
			this.setLocation(this.getX()+deltaX, this.getY()+deltaY);
		}
		this.setSteeringDirection(0);
	}

	/**
	 * Creates the cyborg and initializes the attributes.
	 */
	public Cyborg() {
		this.setSize(CYBORGSIZE);
		this.setColor(255, 0, 0); // red
		this.setSpeed(0);
		this.setMaximumSpeed(ran.nextInt(20) + 30);
		this.setDamagedMaxSpeed(this.getMaximumSpeed());
		this.setEnergyLevel(50);
		this.setLocation(0, 0);
		this.setDamageLevel(0);
		this.setHeading(0);
		this.setSteeringDirection(0);
		this.setEnergyConsumptionRate(5);
		this.setLastBaseReached(1);

	}

	/**
	 * Sets the maximum speed.
	 *
	 * @param maxSpeed the new maximum speed
	 */
	public void setMaximumSpeed(int maxSpeed) {
		this.maximumSpeed = maxSpeed;
	}

	/**
	 * Sets the energy level.
	 *
	 * @param energy the new energy level
	 */
	public void setEnergyLevel(int energy) {
		this.energyLevel = energy;
	}

	/**
	 * Sets the damage level.
	 *
	 * @param damage the new damage level
	 */
	public void setDamageLevel(int damage) {
		this.damageLevel = damage;
	}

	/**
	 * Sets the steering direction.
	 *
	 * @param steer the new steering direction
	 */
	public void setSteeringDirection(int steer) {
		this.steeringDirection = steer;
	}

	/**
	 * Sets the energy consumption rate.
	 *
	 * @param rate the new energy consumption rate
	 */
	public void setEnergyConsumptionRate(int rate) {
		this.energyConsumptionRate = rate;
	}

	/**
	 * Sets the last base reached.
	 *
	 * @param lastBase the new last base reached
	 */
	public void setLastBaseReached(int lastBase) {
		this.lastBasedReached = lastBase;
	}
	
	/**
	 * Displays the status of all the attributes of cyborg.
	 *
	 * @return the string that holds the status of cyborg
	 */
	public String toString() {
		return ("Cyborg: loc = "+Math.round(getX())+","+Math.round(getY())+" color= ["+ ColorUtil.red(getColor())+","+ColorUtil.green(getColor())+","+ColorUtil.blue(getColor())+"] heading="+getHeading()+ " speed="+getSpeed()+" size="+getSize()+" maxSpeed="+getMaximumSpeed()+
				" steeringDirection="+getSteeringDirection()+ " energyLevel="+getEnergyLevel()+" damageLevel="+getDamageLevel());
	}

	/**
	 * Gets the damage level.
	 *
	 * @return the damage level
	 */
	public int getDamageLevel() {
		return damageLevel;
	}

	/**
	 * Gets the energy level.
	 *
	 * @return the energy level
	 */
	public int getEnergyLevel() {
		return energyLevel;
	}

	/**
	 * Gets the steering direction.
	 *
	 * @return the steering direction
	 */
	public int getSteeringDirection() {
		return steeringDirection;
	}

	/**
	 * Gets the last based reached.
	 *
	 * @return the last based reached
	 */
	public int getLastBasedReached() {
		return lastBasedReached;
	}

	/**
	 * Reduce energy.
	 */
	public void reduceEnergy() {
		int newEnergy = this.energyLevel - this.energyConsumptionRate;
		if (newEnergy < 0) {
			this.energyLevel = 0;
		} else {
			this.energyLevel = newEnergy;
		}
	}

	/**
	 * Gets the maximum speed.
	 *
	 * @return the maximum speed
	 */
	public int getMaximumSpeed() {
		return maximumSpeed;
	}

	/**
	 * Sets the damaged max speed.
	 *
	 * @param speed the new damaged max speed
	 */
	public void setDamagedMaxSpeed(int speed) {
		this.damagedMaxSpeed = speed;
	}

	/**
	 * Gets the damaged max speed.
	 *
	 * @return the damaged max speed
	 */
	public int getDamagedMaxSpeed() {
		return damagedMaxSpeed;
	}

	
	



	
	
}