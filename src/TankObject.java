//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Tank Object
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
import processing.core.PImage;
/*
 * This class implements the TankListener interface.
 * This class manages the background objects of the tank and their image,
 * positioning, and process of the object being dragged.
 */
public class TankObject implements TankListener {
	protected static FishTank tank; // PApplet object which represents
	// the display window
	protected PImage image; // image of this tank object
	private float x; // x-position of this tank in the display window
	private float y; // y-position of this tank in the display window
	private boolean isDragging; // indicates whether this tank object
	// is being dragged or not
	private static int oldMouseX; // old x-position of the mouse
	private static int oldMouseY; // old y-position of the mouse
	/*
	 * This method defines the position and the image of the background object.
	 * @param x represents the horizontal position of the object.
	 * @param y represents the vertical position of the object.
	 * @param imageFilename is the name of the image file of the object.
	 */
	public TankObject(float x, float y, String imageFileName) {
		// x x-position of the image of this fish in the display window
		this.x = x;
		// y y-position of the image of this fish in the display window
		this.y = y;
		// imageFileName file name of the image of the object to be created
		this.image = tank.loadImage(imageFileName);
	}

	/*
	 * This method sets the PApplet graphic display window for all TankObjects.
	 * @param tank is the PApplet object that represents the display window.
	 */
	public static void setProcessing(FishTank tank) {
		TankObject.tank = tank;
	}

	/*
	 *  This object moves the tank object with dx and dy
	 *  @param dx is the value that moves the x-position of this tank object.
	 *  @param dy is the value that moves the y-position of this tank object.
	 */
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}

	/*
	 * This method returns the x-position of this tank object.
	 * @return the x-position of this tank object.
	 */
	public float getX() {
		return x;
	}

	/*
	 * This method returns the y-position of this tank object.
	 * @return the y-position of this tank object.
	 */
	public float getY() {
		return y;
	}

	/*
	 * This method sets the x-position of the object
	 * @param x is the x-position of the object
	 */
	public void setX(float x) {
		this.x = x;
	}

	/*
	 * This method sets the y-position of the object
	 * @param y is the y-position of the object
	 */
	public void setY(float y) {
		this.y = y;
	}

	/*
	 * This method returns the image of the tank object
	 * @return image of the tank object
	 */
	public PImage getImage() {
		return image;
	}

	/*
	 * This method is the getter of the isDragging field.
	 *  @return true if this object is being dragged, false otherwise.
	 */
	public boolean isDragging() {
		return isDragging;
	}

	/*
	 * This method starts dragging this tank object.
	 */
	public void startDragging() {
		oldMouseX = tank.mouseX;
		oldMouseY = tank.mouseY;
		this.isDragging = true;
	}

	/*'
	 * This method stops dragging the tank object.
	 */
	public void stopDragging() {
		isDragging = false;
	}

	/*
	 * This method draws the tank object to the display window.
	 */
	@Override
	public void draw() {
		if (this.isDragging) {
			int dx = tank.mouseX - oldMouseX;
			int dy = tank.mouseY - oldMouseY;
			move(dx, dy);
			oldMouseX = tank.mouseX;
			oldMouseY = tank.mouseY;
		}

		tank.image(this.image, this.x, this.y);
	}

	/*
	 * This method called each time the mouse is pressed
	 * and sets isDragging to true.
	 */
	@Override
	public void mousePressed() {
		startDragging();
		isDragging = true;
	}

	/*
	 * This method is called each time the mouse is Released
	 * and sets isDragging to false.
	 */
	@Override
	public void mouseReleased() {
		stopDragging();
		isDragging = false;
	}

	/*
	 * The method checks whether the mouse is over this Tank GUI
	 * @return true if the mouse is over this tank GUI object, false otherwise
	 */
	@Override
	public boolean isMouseOver() {
		int width = image.width;
		int height = image.height;

		// checks if the mouse is over this fish
		return tank.mouseX >= x - width / 2 && tank.mouseX <= x + width / 2 && tank.mouseY >= y - height / 2
				&& tank.mouseY <= y + height / 2;
	}

}
