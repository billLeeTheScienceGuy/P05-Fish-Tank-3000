//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Clear Tank Button
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
/*
 * This class is an extension of the Button class. And manages the positioning,
 * labeling, and the function of the clear button.
 */
public class ClearTankButton extends Button {
	/*
	 * This method labels and positions the clear button.
	 * @param x represents the horizontal position of the clear button
	 * @param y represents the vertical position of the clear button
	 */
	public ClearTankButton(float x, float y) {
		super("clear",x,y);
	}
	/*
	 * This method erases all the fishes on the screen once the clear button
	 * is pressed.
	 */
	@Override
	public void mousePressed() {
		// Leave this method empty
		if(isMouseOver())
			tank.clear();
	}

}
