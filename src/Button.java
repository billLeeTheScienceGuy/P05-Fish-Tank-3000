//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Button
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
 * This class manages the creation, positioning, and labeling of a button
 * on the display screen.
 */
public class Button implements TankListener {
	private static final int WIDTH = 85; // Width of this Button
	private static final int HEIGHT = 32; // Height of this Button
	protected static FishTank tank; // PApplet object where this button will be displayed
	private float x; // x-position of this button in the display window
	private float y; // y-position of this button in the display window
	protected String label; // text/label which represents this button

	/*
	 * This method creates a new Button at a given position within the display window
	 * and sets its label.
	 * @param label is the string that will be the lable of the button.
	 * @param x is the horizontal position of the button.
	 * @param y is the vertical position of the button.
	 */ 
	public Button(String label, float x, float y) {
		this.x = x;
		this.y = y;

		this.label = label;
	}

	/*
	 * This method sets the PApplet display window where this button is displayed and handled.
	 * @param tank represents the FishTank object where the button will be displayed.
	 */
	public static void setProcessing(FishTank tank) {
		Button.tank = tank;
	}
	/*
	 * This method overrides the TankListener.isMouseOver() method
	 * Checks whether the mouse is over this button.
	 * @return true if the mouse is over this button, false otherwise.
	 */
	@Override
	public boolean isMouseOver() {
		int width = WIDTH;
		int height = HEIGHT;

		// checks if the mouse is over this fish
		return tank.mouseX >= x - width / 2 && tank.mouseX <= x + width / 2 && tank.mouseY >= y - height / 2
				&& tank.mouseY <= y + height / 2;

	}
	/*
	 * This method overrides the TankListener.draw() method and Draws this button to the display window
	 */
	@Override
	public void draw() {
		tank.stroke(0);// set line value to black

		// TODO if the mouse is over this button, sets the fill color to dark gray.
		if(isMouseOver())
			tank.fill(100);
		tank.fill(200);
		// Sets the fill color to light gray otherwise

		// draw the button (rectangle with a centered text)
		tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f, x + WIDTH / 2.0f, y + HEIGHT / 2.0f);
		tank.fill(0); // set the fill color to black
		tank.text(label, x, y); // display the text of the current button
	}
	/*
	 * This method overrides the TankListener.mousePressed() method and 
	 * implements the default behavior of this button when the mouse is pressed.
	 */
	@Override
	public void mousePressed() {
		// TODO if the mouse is over this button, print
		// "A button was pressed." to the console
		if(isMouseOver())
			System.out.println("A button was pressed.");

	}
	/*
	 * This method Overrides the TankListener.mouseReleased() method and
	 * implements the default behavior of this button when the mouse is released.
	 * This method must be overridden in the sub-classes to implement a specific
	 * behavior if needed.
	 */
	@Override
	public void mouseReleased() {
		// Leave this method empty
	}

}
