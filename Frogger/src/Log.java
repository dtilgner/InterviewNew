import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author Daniel Tilgner, Sam Askew, Hunter Snellings, Ahmed Elgazar.
 * The log class to be implemented in FrogScreen.
 *
 */
public class Log extends MovingScreenObject {

	/**
	 * Constructor to house Log object.
	 * @param location Origin of Log when screen is initialized.
	 * @param size Size of Log when screen is initialized.
	 * @param image Image to be used when Log is drawn.
	 */
	public Log(Point location, Rectangle size, Image image)
	{
		super(location, size, image, 0);
	}
}