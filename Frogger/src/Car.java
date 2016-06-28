import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 * @author Daniel Tilgner, Sam Askew, Hunter Snellings, Ahmed Elgazar
 * The car class to be implemented in FrogScreen.
 *
 */
public class Car extends MovingScreenObject {
	
	/**
	 * Constructor to house Car object.
	 * @param location Origin of car when screen is initialized.
	 * @param size Size of Car when screen is initialized.
	 * @param image Image to be used when car is drawn.
	 */
	public Car(Point location, Rectangle size, Image image) {
		super(location, size, image, 0);
	}
}
