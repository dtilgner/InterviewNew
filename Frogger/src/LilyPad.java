import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
/**
 * 
 * @author Daniel Tilgner, Sam Askew, Hunter Snellings, Ahmed Elgazar
 * The LilyPad class to be implemented in FrogScreen.
 *
 */
public class LilyPad extends MovingScreenObject
{
	
	/**
	 * Constructor to house LilyPad object.
	 * @param location Origin of LilyPad when screen is initialized.
	 * @param size Size of LilyPad when screen is initialized.
	 * @param image Image to be used when LilyPad is drawn.
	 */
	public LilyPad(Point location, Rectangle size, Image image)
	{
		super(location, size, image, 0);
	}
}
