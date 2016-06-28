import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.geom.AffineTransform;

/** 
 * A moving screen object has a vector, an angle, an image, an age, and a maximum age. 
 * 
 * @author Daniel Tilgner, Sam Askew, Hunter Snellings, Ahmed Elgazar
 */
public class MovingScreenObject extends ScreenObject
{
	protected MyVector myVector;
	protected double myAngle;
	protected Image myImage;
	protected int myAge;
	protected int myMaxAge;
	
	/** Makes a moving screen object with a particular location, size, and angle. 
	 * The age will be initialized at zero.
	 * @param location the location of the moving screen object.
	 * @param size the size of the moving screen object.
	 * @param image the image used for the moving screen object.
	 * @param angle the angle of the moving screen object. */
	public MovingScreenObject(Point location, Rectangle size, Image image, double angle)
	{
		super(location, size);
		myImage = image;
		this.myAngle = angle;
	}
	
	/**
	 * Checks to see if object has moved off screen and moves it to the other side.
	 */
	public void moveCheck()
	{
//		location.x += myVector.getChangeX();
//		location.y += myVector.getChangeY();
//		
		if (location.x > FrogScreen.screenWidth)
		{location.x -= FrogScreen.screenWidth;}
		
		if (location.x < 0)
		{location.x += FrogScreen.screenWidth;}
		
	}
	
	/**
	 * Draws the frog.
	 */
	public void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		if (this instanceof Frog) 
		{
			Frog frog = (Frog) this;
			AffineTransform trans = new AffineTransform();
			trans.translate(location.x, location.y);
			trans.scale(0.25, 0.25);      // (?)
			
			trans.rotate(Math.toRadians(frog.getAngle()), 
					myImage.getWidth(null) / 2, myImage.getHeight(null) / 2);
			
			g2.drawImage(myImage, trans, null);
		}
		
		else {g2.drawImage(myImage, location.x, location.y, size.width, size.height, null);}
	}
	
	/**
	 * Boolean to check for collision between objects.
	 * @param otherObj Object to be checked for collision.
	 * @return True if there was a collision, false if not.
	 */
	public boolean collide(MovingScreenObject otherObj) {
		Rectangle otherR = otherObj.getSize();
		otherR.setLocation(otherObj.getLocation());
		this.getSize().setLocation(this.getLocation());
		if (otherR.intersects(this.getSize())) {
			return true;
		}
		return false;
	}
	
	
	public MyVector getVector()
	{return myVector;}
	
	public void setVector(MyVector newVec)
	{myVector = newVec;}
	
	public double getAngle()
	{return myAngle;}
	
	public void setAngle(double newAng)
	{myAngle = newAng;}
	
	public Image getImage()
	{return myImage;}
	
	public void setImage(Image newIm)
	{myImage = newIm;}
	
}