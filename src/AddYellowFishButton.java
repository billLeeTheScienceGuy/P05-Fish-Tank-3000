//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Add Yellow Fish Button
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
 * This class is an extension of the Button class. And manages the positioning,
 * labeling, and the function of the Add Yellow button.
 */
public class AddYellowFishButton extends Button {
	/*
	 * This method labels and positions the Add Yellow button.
	 * @param x represents the horizontal position of the Add Yellow button.
	 * @param y represents the vertical position of the Add Yellow button.
	 */
	public AddYellowFishButton(float x, float y) {
		super("Add Yellow",x,y);
	}
	/*
	 * This method adds a new yellow fish when the mouse is pressed.
	 */
	@Override
	public void mousePressed() {
		if(isMouseOver())
			tank.objects.add(new Fish(2,"images" + File.separator + "yellow.png"));
	}

}
