import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;

/** The ScreenObject is comprised of a location and size.
 * 
 * @author Daniel Tilgner, Sam Askew, Hunter Snellings, Ahmed Elgazar
 */
public abstract class ScreenObject 
{
	protected Point location;
	protected Rectangle size;
	
	/** Makes the screen object with its location and size.
	 * @param location The location of the screen object.
	 * @param size The size of the screen object. */
	public ScreenObject(Point location, Rectangle size)
	{
		super();
		this.location = location;
		this.size = size;
	}
	
	/** @return the location of the screen object. */
	public Point getLocation()
	{return this.location;}
	
	/** @return the size of the screen object. */
	public Rectangle getSize()
	{return this.size;}
	
	/** @param newLoc the new location. */
	public void setLocation(Point newLoc)
	{this.location = newLoc;}
	
	/** @param s the new size. */
	public void setSize(Rectangle s)
	{this.size = s;}
	
	abstract public void draw(Graphics g);
	

}
