
public class MyVector 
{
	private double changeX;
	private double changeY;
	
	public MyVector(double x, double y)
	{
		super();
		this.changeX = x;
		this.changeY = y;
	}
	
	public void setChange(double x, double y)
	{
		this.changeX = x;
		this.changeY = y;
	}
	
	public double getChangeX()
	{return changeX;}
	
	public double getChangeY()
	{return changeY;}
	
	public void setChangeX(int x)
	{this.changeX = x;}
	
	public void setChangeY(int y)
	{this.changeY = y;}

}
