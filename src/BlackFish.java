//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Black Fish
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
 * black fish object where the object constantly travels back and forward between
 * two TankObject objects.
 */
public class BlackFish extends Fish {

	private TankObject source; // The source object where the fish will travel to
	private TankObject destination; // The destination object where the fish will travel to
	/*
	 * This method creates a black fish object and sets its speed, and the objects
	 * that it will travel in between.
	 * @param source is the first TankObject object that the black fish object will travel to.
	 * @param source is the second TankObject object that the black fish object will travel to.
	 */
	public BlackFish(TankObject source, TankObject destination) {
		super(2, "images" + File.separator + "black.png");
		this.source = source;
		this.destination = destination;
	}

	/*
	 * This method makes the black fish move one speed towards the destination object.
	 */
	public void moveTowardsDestination() {
		float dx = destination.getX() - this.getX();
		float dy = destination.getY() - this.getY();

		int d = (int) Math.sqrt(dx * dx + dy * dy);

		this.setX(this.getX() + (this.speed() * dx) / d);
		this.setY(this.getY() + (this.speed() * dy) / d);
	}

	/*
	 * This method checks if the black fish is over the TankObject or not.
	 * @param other is the TankObject object where the fish is getting checksed
	 * @if it is over that object or not.
	 * @return true if this black fish is over another TankObject, and false otherwise.
	 */
	public boolean isOver(TankObject other) {
		if ((this.getX() - this.image.width / 2) <= other.getX() + other.image.width / 2
				&& (this.getX() + this.image.width / 2) >= other.getX() - other.image.width / 2)
			if ((this.getY() - this.image.height / 2) <= other.getY() + other.image.height / 2
					&& (this.getY() + this.image.height / 2) >= other.getY() - other.image.height / 2)
				return true;
		return false;
	}

	/*
	 * This method overrides Fish.swim() method and makes the black fish object towards
	 * its destination object.
	 * Once the fish has reached its destination (meaning if the isOver returns true).
	 * then the source and destination objects get switched.
	 */
	@Override
	public void swim() {
		moveTowardsDestination();

		if (isOver(destination)) {
			TankObject temp = source;
			this.source = destination;
			this.destination = temp;
		}
	}
}
