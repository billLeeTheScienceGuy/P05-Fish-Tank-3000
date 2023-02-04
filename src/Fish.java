//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fish
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
 * This class is the extension of the TankObject class and it
 * manages the behavior of fish on the display screen.
 */
public class Fish extends TankObject {

	private int speed;
	private boolean isSwimming;
	/*
	 * This method creates a new fish object at a random position of the display and sets its speed.
	 * If the speed of the fish is negative then it throws an error.
	 * @param speed is the speed value of the fish object.
	 * @param fishImageFileName is the name of the image file that contains the image of the fish.
	 * @throws an IlleagalArgumentException when the speed of the fish is less or equal to zero.
	 */
	public Fish(int speed, String fishImageFileName) throws IllegalArgumentException {

		super((float) tank.randGen.nextInt(tank.width), (float) tank.randGen.nextInt(tank.height), fishImageFileName);

		if (speed <= 0)
			throw new IllegalArgumentException("Warning: speed cannot be negative");

		this.speed = speed;

	}
	/*
	 * This method creates a new fish object located at a random position of the display with
	 * speed 5 and the image of orange.png.
	 */

	public Fish() {
		this(5, "images" + File.separator + "orange.png");
	}
	/*
	 * This method sets the position of this fish to follow the
	 * mouse moves if it is dragging, calls its swim() method
	 * if it is swimming, and draws it to the display window.
	 */
	@Override
	public void draw() {

		if (isSwimming) {
			swim();
		}

		super.draw();

	}
	/*
	 * This method checks whether this fish is swimming
	 * @return isSwimming
	 */
	public boolean isSwimming() {
		return isSwimming;
	}

	/*
	 * This method starts makes the fish start swimming
	 */
	public void startSwimming() {
		stopDragging();
		isSwimming = true;
	}

	/*
	 * This method stops swimming the fish
	 */
	public void stopSwimming() {
		isSwimming = false;
	}

	/*
	 * This method gets and returns the speed of this fish
	 * @return speed
	 */
	public int speed() {
		return speed;
	}

	/*
	 * This method moves the fish horizontally one speed step from left to right.
	 */
	public void swim() {
		setX((getX() + speed) % tank.width);
	}

}
