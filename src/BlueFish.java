//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Blue Fish
// Course:   CS 300 Fall 2021
//
// Author:   Bill Lee
// Email:    blee266@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Leobardo Guardado Jr
// Partner Email:   guardadojr@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x_ Write-up states that pair programming is allowed for this assignment.
//   _x_ We have both read and understand the course Pair Programming Policy.
//   _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
/*
 * This class is an extension of the Fish class. And manages the behavior of the
 * blue fish object where the object moves from right and to the left on the display.
 */
public class BlueFish extends Fish {
	/*
	 * This method sets the speed and the image of the blue fish.
	 */
	public BlueFish() {
		super(2, "images" + File.separator + "blue.png");
	}
	/*
	 * This method overrides Fish.swim() method and makes the blue fish object
	 * swim from the right side of the display to the left side of the display.
	 */
	@Override
	public void swim() {
		setX((getX() - speed()) % tank.width); // BUG
		if (getX() <= 0) // POSSIBLE SOLUTION
			setX(tank.width);
	}
}
