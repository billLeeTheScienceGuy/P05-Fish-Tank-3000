//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fish Tank
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
import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;
/*
 * This class is an extension of PApplet
 * This class sets up the graphics of this program and manages the user input.
 */
public class FishTank extends PApplet {

	private PImage backgroundImage; // PImage object which represents the background image
	protected ArrayList<TankListener> objects; // list storing interactive objects
	protected Random randGen; // Generator of random number

	private TankObject flower;
	private TankObject log;
	private TankObject shell;
	private TankObject ship;

	/*
	 * sets the size of this PApplet to 800 width x 600 height
	 */
	@Override
	public void settings() {
		size(800, 600);
	}

	/*
	 * The method defines the initial environment properties such as screen size and
	 * loads the background image and fonts as the program starts.
	 * It also initializes all data fields.
	 */
	@Override
	public void setup() {
		// Set and display the title of the display window
		this.getSurface().setTitle("Fish Tank 3000");
		// Set the location from which images are drawn to CENTER
		this.imageMode(PApplet.CENTER);
		// Set the location from which rectangles are drawn.
		this.rectMode(PApplet.CORNERS);
		// rectMode(CORNERS) interprets the first two parameters of rect() method
		// as the location of one corner, and the third and fourth parameters as
		// the location of the opposite corner.
		// rect() method draws a rectangle to the display window

		this.focused = true; // Confirms that our Processing program is focused,
		// meaning that it is active and will accept mouse or keyboard input.

		// sets the text alignment to center
		this.textAlign(PApplet.CENTER, PApplet.CENTER);

		// TODO load the background image and store the loaded image to backgroundImage
		backgroundImage = this.loadImage("images" + File.separator + "background.png");
		// Note that you can call the loadImage() method directly (this.loadImage())

		// TODO create an empty array list of objects
		objects = new ArrayList<>();

		// TODO set randGen to the reference of a new Random objects
		randGen = new Random();

		TankObject.setProcessing(this);

		flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
		log = new TankObject(580, 470, "images" + File.separator + "log.png");
		shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
		ship = new TankObject(280, 535, "images" + File.separator + "ship.png");
		BlackFish blackFish1 = new BlackFish(log, flower);
		BlackFish blackFish2 = new BlackFish(shell, flower);
		AddBlueFishButton blueFish = new AddBlueFishButton(43, 16);
		AddOrangeFishButton orangeFish = new AddOrangeFishButton(129, 16);
		AddYellowFishButton yellowFish = new AddYellowFishButton(215, 16);
		ClearTankButton clearTank = new ClearTankButton(301, 16);

		objects.add(flower);
		objects.add(log);
		objects.add(shell);
		objects.add(ship);
		objects.add(blackFish1);
		objects.add(blackFish2);
		
		Button.setProcessing(this);
		
		objects.add(blueFish);
		objects.add(orangeFish);
		objects.add(yellowFish);
		objects.add(clearTank);
		
	}

	/*
	 *  This method continuously draws and updates the application display window.
	 */
	@Override
	public void draw() {
		// TODO clear the display window by drawing the background image
		this.image(backgroundImage, this.width / 2, this.height / 2);
		// TODO traverse the objects list and draw each of the objects to this display
		// window
		for (int i = 0; i < objects.size(); i++)
			objects.get(i).draw();
	}

	/*
	 *  This method is the callback method that is called each time the user presses the mouse.
	 *  @return void
	 */
	@Override
	public void mousePressed() {
		// TODO traverse the objects list and call mousePressed method
		// of the first object being clicked in the list
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).isMouseOver()) {
				objects.get(i).mousePressed();
				return;
			}
		}
	}

	/*
	 *  This method is the callback method that is called each time the mouse is released.
	 */
	@Override
	public void mouseReleased() {
		// TODO traverse the objects list and call each object's mouseReleased() method
		for (int i = 0; i < objects.size(); i++)
			 objects.get(i).mouseReleased();
	}

	/*
	 * This method adds an instance of TankListener passed as input to the objects arraylist.
	 * @param object is the instance of TankListener that's added to the objects arraylist.
	 */
	public void addObject(TankListener object) {
		this.objects.add(object);
	}
	/*
	 * This is a callback method that is called each time the user presses a certain key
	 * that corresponds to a proper key input.
	 */
	@Override
	public void keyPressed() {
		switch (Character.toUpperCase(key)) {

		case 'O': // add a new fish if the maximum numbers of fish allowed to be
			objects.add(new Fish());
			break;

		case 'Y':
			objects.add(new Fish(2, "images" + File.separator + "yellow.png"));
			break;

		case 'B':
			objects.add(new BlueFish());
			break;

		case 'R':
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i).isMouseOver()) {
					objects.remove(i);
					break;
				}
			}
			break;

		case 'S':
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i) instanceof Fish) {
					((Fish) objects.get(i)).startSwimming();
				}
			}
			break;

		case 'X':
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i) instanceof Fish) {
					((Fish) objects.get(i)).stopSwimming();
				}
			}
			break;

		case 'C':
			clear();
			break;
		}

	}

	/*
	 * This method removes instances of the class Fish from this tank
	 */
	public void clear() {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) instanceof Fish) {
				objects.remove(i);
				i--;
			}
		}
	}
	/*
	 * This method takes a string input parameter that represents the name of the PApplet class.
	 * @param args is the string input that represents the name of the class.
	 */
	public static void main(String[] args) {
		PApplet.main("FishTank"); // do not add any other statement to the main method
		// The PApplet.main() method takes a String input parameter which represents
		// the name of your PApplet class.
	}
}
