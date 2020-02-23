package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String;

/**
 * The Class Game where the commands of user is handled.
 */
public class Game extends Form{
	
	/** The gameworld that game is being played on. */
	private GameWorld gw;
	
	/**
	 * Instantiates a new game.
	 */
	public Game() {
	gw = new GameWorld();
	gw.init(); //initializes the game world
	play();
	}
	
	/**
	 * Play takes command from user and uses switch case
	 * to do different things according to the command given from user. 
	 */
	private void play() {
		Label myLabel=new Label("Enter a Command:");
        this.addComponent(myLabel);
        final TextField myTextField=new TextField();
        this.addComponent(myTextField);
        this.show();

        myTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                    String sCommand=myTextField.getText().toString();
                        myTextField.clear();
                        if(sCommand.length() != 0) 
                            switch (sCommand.charAt(0)) {
                            case 'x'://exit game
                                gw.exit();
                                break;
                            case 'm':
                            	gw.map();//display map/status of the objects
                            	System.out.println("");
                            	break;
                            case 'd':
                            	gw.display();//display cyborg status
                            	System.out.println("");
                            	break;
                            case 'a': //accelerate cyborg
                            	gw.accelerate();
                            	break;
                            case 'b': //brake cyborg
                            	gw.brake();
                            	break;
                            case 'c': //collide with another cyborg
                            	gw.collided();
                            	break;
                            case '1': //collide with base 1
                            	gw.baseCollide(1);
                            	break;
                            case '2': //collide with base 2
                            	gw.baseCollide(2);
                            	break;
                            case '3': //collide with base 3
                            	gw.baseCollide(3);
                            	break;
                            case '4': //collide with base 4
                            	gw.baseCollide(4);
                            	break;
                            case '5': //collide with base 5
                            	gw.baseCollide(5);
                            	break;
                            case '6': //collide with base 6
                            	gw.baseCollide(6);
                            	break;
                            case '7': //collide with base 7
                            	gw.baseCollide(7);
                            	break;
                            case '8': //collide with base 8
                            	gw.baseCollide(8);
                            	break;
                            case '9': //collide with base 9
                            	gw.baseCollide(9);
                            	break;
                            case 'e': //collide with energy station
                            	gw.energyCollide();
                            	break;
                            case 't': //execute tick
                            	gw.tick();
                            	break;
                            case 'g': //collide with drone
                            	gw.droneCollide();
                            	break;
                            case 'y': //yes to exit
                            	gw.yes();
                            	break;
                            case 'n': //no to exit
                            	gw.no();
                            	break;
                            case 'l': //steer left
                            	gw.left();
                            	break;
                            case 'r': //steer right
                            	gw.right();
                            	break;
                        	default: //If none of these commands are inputed 
                        		System.out.println("Unknown Command");
                              } //switch
                        
            } //actionPerformed

			
        }  //new ActionListener()
        );
	} //play



    }

