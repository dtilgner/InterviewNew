import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
/**
 * 
 * @author Daniel Tilgner, Sam Askew, Hunter Snellings, Ahmed Elgazar
 * The LilyPad class to be implemented in FrogScreen.
 *
 */
public class Water extends MovingScreenObject
{
	
	/**
	 * Constructor to house Water object.
	 * @param location Origin of Water when screen is initialized.
	 * @param size Size of Water when screen is initialized.
	 * @param image Image to be used when Water is drawn.
	 */
	public Water(Point location, Rectangle size, Image image)
	{
		super(location, size, image, 0);
	}
}