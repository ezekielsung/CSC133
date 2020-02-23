package com.mycompany.a1;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

/**
 * The Class GameWorld holds all the events
 * that can happen within the game.
 */
public class GameWorld {

	/** The Constant MAX_LIVES. */
	public static final int MAX_LIVES = 3;
	
	/** The Constant MAX_DAMAGE_LEVEL. */
	public static final int MAX_DAMAGE_LEVEL = 10;
	
	/** The game is over. */
	private boolean confirmation = false, gameOver = false;
	
	/** The sequence. */
	private int lives = MAX_LIVES, tick,sequence=1;
	
	/** The random number object. */
	 Random ran = new Random();
	
	/** The list of gameObjects. */
	public Vector<GameObject> objects = new Vector<GameObject>();
	
	/** The cyborg. */
	private Cyborg cyborg;
	
	/** The drone. */
	private Drone drone;
	
	/** The base. */
	private Bases base;
	
	/** The station. */
	private EnergyStation station;

	/**
	 * Inits the game world with all the gameobjects created.
	 */
	public void init() {
		objects.add(cyborg = new Cyborg());
		objects.add(drone = new Drone());
		objects.add(drone = new Drone());
		objects.add(drone = new Drone());
		objects.add(base = new Bases(0,0,sequence));
		incrementSequence();
		objects.add(base = new Bases(50,50,sequence));
		incrementSequence();
		objects.add(base = new Bases(200,200,sequence));
		incrementSequence();
		objects.add(base = new Bases(800,800,sequence));
		incrementSequence();
		objects.add(station = new EnergyStation());
		objects.add(station = new EnergyStation());

	}

	/**
	 * Exit asks user for one more confirmation before exiting.
	 */
	public void exit() {
		System.out.println("Are You Sure? y or n");
		confirmation = true;
	}

	/**
	 * Map displays the status/attributes of each gameobject
	 */
	public void map() {
		System.out.println("");
		Enumeration e = objects.elements();
		while (e.hasMoreElements()) {
			System.out.println(((GameObject) e.nextElement()).toString());
		}
	}
	
	
	public void incrementSequence() {
		sequence++;
	}

	/**
	 * Display the status of cyborg
	 */
	public void display() {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.elementAt(i) instanceof Cyborg) {
				System.out.println("");
				System.out.println("Lives left:" + lives + ", Current Tick:" + tick + ", Highest Based Reached: "
						+ ((Cyborg) objects.elementAt(i)).getLastBasedReached() + ", Current Energy Level:"
						+ ((Cyborg) objects.elementAt(i)).getEnergyLevel() + ", Current Damage Level:"
						+ ((Cyborg) objects.elementAt(i)).getDamageLevel());
			}
		}
	}

	/**
	 * Accelerate increases the speed of cyborg by 2 if
	 * it is valid
	 */
	public void accelerate() {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.elementAt(i) instanceof Cyborg) {

				if (((Cyborg) objects.elementAt(i)).getEnergyLevel() == 0) { // setSpeed to zero if energyLevel is 0
					((Cyborg) objects.elementAt(i)).setSpeed(0);
					break;
				}

				if ((((Cyborg) objects.elementAt(i)).getSpeed() + 2) < ((Cyborg) objects.elementAt(i)).getDamagedMaxSpeed()) { // check if it goes over maxSpeed, change speed accordingly
					((Cyborg) objects.elementAt(i)).setSpeed(((Cyborg) objects.elementAt(i)).getSpeed() + 2);
				} else {
					((Cyborg) objects.elementAt(i)).setSpeed(((Cyborg) objects.elementAt(i)).getDamagedMaxSpeed());
				}
			}
		}
		System.out.println("");
		System.out.println("Accelerated");
	}

	/**
	 * Brake decreases the speed of cyborg by 1 if it is valid
	 */
	public void brake() {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.elementAt(i) instanceof Cyborg) {
				int tempSpeed = ((Cyborg) objects.elementAt(i)).getSpeed();
				if (tempSpeed > 0) {
					((Cyborg) objects.elementAt(i)).setSpeed(tempSpeed - 1);
				}
			}
		}
		System.out.println("");
		System.out.println("Applied brake");
	}

	/**
	 * Collided collides with another cyborg
	 * and does the effects of it
	 */
	public void collided() {

		for (int i = 0; i < objects.size(); i++) {
			if (objects.elementAt(i) instanceof Cyborg) {
				int damageLevel = ((Cyborg) objects.elementAt(i)).getDamageLevel();
				if (damageLevel + 2 > MAX_DAMAGE_LEVEL - 2) {
					takeCyborgLife(i);
				} else {
					adjustDamagedMaxSpeed(i,damageLevel,2);
				}
				checkGameOver();
			}
		}
		System.out.println("");
		System.out.println("Collided with a cyborg");
	}
	
	/**
	 * Checks if there are any lives left.
	 * If not, exit game and prompt user
	 */
	public void checkGameOver() {
		if (lives < 1) {
			System.out.println("");
			System.out.println("Game Over, you failed!");
			System.exit(0);
			gameOver = true;
		}
	}

	/**
	 * Adjust the maximum speed cyborg can take 
	 * after taking damage
	 */
	public void adjustDamagedMaxSpeed(int i, int damageLevel, int damage) {
		((Cyborg) objects.elementAt(i)).setDamageLevel(damageLevel + damage);
		((Cyborg) objects.elementAt(i)).setColor(255, 102, 102); // light red
		double percentage = (1.0 - (double) ((damageLevel + 1.0) / 10.0));
		((Cyborg) objects.elementAt(i)).setDamagedMaxSpeed((int) (((Cyborg) objects.elementAt(i)).getMaximumSpeed() * percentage));
		
		if (((Cyborg) objects.elementAt(i)).getSpeed() > ((Cyborg) objects.elementAt(i)).getDamagedMaxSpeed()) {
			((Cyborg) objects.elementAt(i)).setSpeed(((Cyborg) objects.elementAt(i)).getDamagedMaxSpeed());
		}
	}

	/**
	 * Base collide with a specific base and see 
	 * if it is the next base it goes to.
	 *
	 * @param base the base that it collided with
	 */
	public void baseCollide(int base) {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.elementAt(i) instanceof Cyborg) {
				int tempBase = ((Cyborg) objects.elementAt(i)).getLastBasedReached();
				if ((tempBase + 1) == base) {
					((Cyborg) objects.elementAt(i)).setLastBaseReached(base);
				}
			}
		}
		System.out.println("");
		System.out.println("Collided with base " + base);

	}


	/**
	 * Energy collide collides with an energy station with cyborg.
	 * The energy station capacity goes to cyborg energy level, and 
	 * a new station is created. 
	 */
	public void energyCollide() {
		int refill = 0;
		boolean done = false;
		for (int i = 0; i < objects.size(); i++) {
			if (objects.elementAt(i) instanceof EnergyStation) {

				if (((EnergyStation) objects.elementAt(i)).getCapacity() != 0 && done == false) {
					refill = ((EnergyStation) objects.elementAt(i)).getCapacity();
					((EnergyStation) objects.elementAt(i)).setCapacity(0);
					((EnergyStation) objects.elementAt(i)).setColor(204, 204, 204);// light gray
					done = true;
				}

			}
		}
		for (int i = 0; i < objects.size(); i++) {
			if (objects.elementAt(i) instanceof Cyborg) {
				int tempEnergy = ((Cyborg) objects.elementAt(i)).getEnergyLevel();
				((Cyborg) objects.elementAt(i)).setEnergyLevel(tempEnergy + refill);
			}
		}
		objects.add(station = new EnergyStation());
		System.out.println("");
		System.out.println("Collided with energy station");
	}

	/**
	 * Tick increments the game time, reduces the cyborg energy and makes
	 * a move for drone and cyborg.
	 */
	public void tick() {

		if (gameOver == false) {
			for (int i = 0; i < objects.size(); i++) {

				if (objects.elementAt(i) instanceof Cyborg) {
					((Cyborg) objects.elementAt(i)).move();
					((Cyborg) objects.elementAt(i)).reduceEnergy();
					if (((Cyborg) objects.elementAt(i)).getEnergyLevel()==0) {
							takeCyborgLife(i);
							checkGameOver();
					}
				}

				if (objects.elementAt(i) instanceof Drone) {
					((Drone) objects.elementAt(i)).move();
				}

			}
			tick++;
		} else {
			System.out.println("You are out of lives");
		}

		System.out.println("");
		System.out.println("Incremented tick");
	}


	/**
	 * Drone collide collides with a drone and does the effects of it.
	 */
	public void droneCollide() {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.elementAt(i) instanceof Cyborg) {
				int damageLevel = ((Cyborg) objects.elementAt(i)).getDamageLevel();
				if (damageLevel + 1 > MAX_DAMAGE_LEVEL - 1) {
					takeCyborgLife(i);
				} else {
					adjustDamagedMaxSpeed(i,damageLevel,1);
				}
			}
			checkGameOver();
		}
		System.out.println("");
		System.out.println("Collided with a drone");
	}
	
	/**
	 * After reaching max damage level, cyborg takes a life
	 * and resets back to original state
	 */
	public void takeCyborgLife(int i) {
		lives--;
		System.out.println("");
		System.out.println("You lost a life");
		((Cyborg) objects.elementAt(i)).setDamageLevel(0);
		((Cyborg) objects.elementAt(i)).setEnergyLevel(50);
		((Cyborg) objects.elementAt(i)).setHeading(0);
		((Cyborg) objects.elementAt(i)).setLastBaseReached(1);
		((Cyborg) objects.elementAt(i)).setLocation(0,0);
		((Cyborg) objects.elementAt(i)).setDamagedMaxSpeed(((Cyborg) objects.elementAt(i)).getMaximumSpeed());
		((Cyborg) objects.elementAt(i)).setColor(255, 0, 0); // set it back to red
	}

	/**
	 * Yes checks if user wants to exit and exits if so.
	 */
	public void yes() {
		if (confirmation == true) {
			System.exit(0);
		} else {
			System.out.println("Please press x first to exit");
		}
	}

	/**
	 * No tells that user does not want to quit.
	 */
	public void no() {
		confirmation = false;
		System.out.println("");
		System.out.println("You will not exit");
	}

	/**
	 * Left decreases the cyborg heading direction by 5. 
	 */
	public void left() {

		for (int i = 0; i < objects.size(); i++) {
			if (objects.elementAt(i) instanceof Cyborg) {
				int steeringDirection = ((Cyborg) objects.elementAt(i)).getSteeringDirection();
				if (steeringDirection > -40) {
					((Cyborg) objects.elementAt(i)).setSteeringDirection((((Cyborg) objects.elementAt(i)).getSteeringDirection() - 5));
				}
			}

		}
		System.out.println("");
		System.out.println("Steer Left");
	}

	/**
	 * Right increases the cyborg heading direction by 5.
	 */
	public void right() {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.elementAt(i) instanceof Cyborg) {
				int steeringDirection = ((Cyborg) objects.elementAt(i)).getSteeringDirection();
				if (steeringDirection < 40) {
				((Cyborg) objects.elementAt(i)).setSteeringDirection((((Cyborg) objects.elementAt(i)).getSteeringDirection() + 5));
				}
			}
	}
		System.out.println("");
		System.out.println("Steer Right");
}
}
