import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

/** The frog class has its own image, size, location, and angle. It's controlled by the player. 
 * @author Daniel Tilgner, Sam Askew, Hunter Snellings, Ahmed Elgazar */
public class Frog extends MovingScreenObject 
{
	
	/** Constructs a frog with the specified starting location, size, and image. 
	 * @param location The starting location.
	 * @param size The starting size.
	 * @param image The image for the frog. */
	public Frog(Point location, Rectangle size, Image image)
	{
		super(location, size, image, 0);
		moveCheck();
		myAngle = 90;
	}

}
