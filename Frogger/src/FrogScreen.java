import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//Get frog moving in cardinal directions, animate jump by extending legs/etc. later, 
/**
 * 
 * @author Daniel Tilgner, Sam Askew, Hunter Snellings, Ahmed Elgazar
 * Main game screen. Adds all components and initializes them.
 * 
 *
 */
public class FrogScreen extends JPanel implements KeyListener
{
	public static int screenWidth = 1000;
	public static int screenHeight = 730; 
	public static ImageIcon frogImg = new ImageIcon("Frug1.png");
	public static ImageIcon carImg = new ImageIcon("car1.png");
	public static ImageIcon car2Img = new ImageIcon("car2.png");
	public static ImageIcon truckImg = new ImageIcon("truck1.png");
	public static ImageIcon logImg = new ImageIcon("log.png");
	public static ImageIcon lilyPadImg = new ImageIcon("lilyPad.png");
	public static Image background = Toolkit.getDefaultToolkit().createImage("background.png");
	public static Image gameOver = Toolkit.getDefaultToolkit().createImage("gameOver.png");
	private javax.swing.Timer ogTimer;
	private ArrayList<ScreenObject> screenObjects;
	private int lives = 3;
	private int log3speed = 5;
	private int log2speed = 6;
	private int log1speed = 7;
	private int car1speed = 5;
	private int car2speed = 3;
	private int truck1speed = 5;
	private int truck2speed = 2;
	private JLabel label;
	
	/**
	 * Initializes the screen, adds the objects, and starts a timer.
	 */
	public FrogScreen()
	{
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		screenObjects = new ArrayList<ScreenObject>();
		label = new JLabel("Lives: " + lives);
		label.setPreferredSize(new Dimension(950, 1400));
		label.setForeground(Color.WHITE);
		addFrog();
		addCar();
		addLog();
		addLilyPad();
		addWater();
		add(label);
		label.setLocation(new Point(10, screenHeight - 90));
		
		this.addKeyListener(this);
		ogTimer = new javax.swing.Timer(30, new TimerListener());
		ogTimer.start();
	}
	
	/**
	 * Initializes all car objects to be added to the screen and makes them move in a direction with a speed.
	 */
	public void addCar()	
	{
	  		
		final Car car1 = new Car(new Point(0,360), new Rectangle(119, 57), carImg.getImage());
		screenObjects.add(1, car1);
		Action paintTimer1 = new AbstractAction() 
		{
		public void actionPerformed(ActionEvent e) 
		{
			
			Point location = car1.getLocation();
			double newDown = location.x += car1speed;
			MyVector vector = new MyVector(newDown, location.y);
			car1.setVector(vector);
			car1.moveCheck();
			//repaint();
			}
		};
		Timer timer1 = new Timer(15, paintTimer1);
		timer1.start();
		if (lives == 0)
			timer1.stop();
		
		
		final Car car1A = new Car(new Point(-150, 360), new Rectangle(119, 57), carImg.getImage());
		screenObjects.add(2, car1A);
		Action paintTimer1A = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				Point location = car1A.getLocation();
				double newDown = location.x += car1speed;
				MyVector vector = new MyVector(newDown, location.y);
				car1A.setVector(vector);
				car1A.moveCheck();
			//	repaint();		
				}
			};
			Timer timer1A = new Timer(15, paintTimer1A);
			timer1A.setInitialDelay(1500);
			timer1A.start();
			if (lives == 0)
				timer1A.stop();
			
			
		final Car car2 = new Car(new Point(0, 510), new Rectangle(123, 54), car2Img.getImage());
		screenObjects.add(3, car2);
		Action paintTimer3 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				Point location = car2.getLocation();
				double newDown = location.x += car2speed;
				MyVector vector = new MyVector(newDown, location.y);
				car2.setVector(vector);
				car2.moveCheck();
			//	repaint();						
				}
			};
			Timer timer2 = new Timer(15, paintTimer3);
			timer2.start();
			if (lives == 0)
				timer2.stop();
		
				
		final Car car2A = new Car(new Point(-150, 510), new Rectangle(123, 54), car2Img.getImage());
		screenObjects.add(4, car2A);
		Action paintTimer3A = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {			
				Point location = car2A.getLocation();
				double newDown = location.x += car2speed;
				MyVector vector = new MyVector(newDown, location.y);
				car2A.setVector(vector);
				car2A.moveCheck();
	//			repaint();							
				}
			};
			Timer timer2A = new Timer(15, paintTimer3A);
			timer2A.setInitialDelay(1000);
			timer2A.start();
			if (lives == 0)
				timer2A.stop();
		
					
		final Car truck1 = new Car(new Point(1000, 430), new Rectangle(240, 60), truckImg.getImage());
		screenObjects.add(5, truck1);
		Action paintTimer2 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {			
				Point location = truck1.getLocation();
				double newDown = location.x -= truck1speed;
				MyVector vector = new MyVector(newDown, location.y);
				truck1.setVector(vector);
				truck1.moveCheck();
			//	repaint();				
				}
			};
			Timer timer3 = new Timer(15, paintTimer2);
			timer3.start();
			if (lives == 0)
				timer3.stop();
		
			
		final Car truck2 = new Car(new Point(1000, 575), new Rectangle(240, 60), truckImg.getImage());
		screenObjects.add(6, truck2);
		Action paintTimer4 = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {				
				Point location = truck2.getLocation();
				double newDown = location.x -= truck2speed;
				MyVector vector = new MyVector(newDown, location.y);
				truck2.setVector(vector);
				truck2.moveCheck();
			//	repaint();							
				}
			};
			Timer timer4 = new Timer(15, paintTimer4);
			timer4.start();
			if (lives == 0)
				timer4.stop();
		
					
		final Car truck2A = new Car(new Point(1000, 575), new Rectangle(240, 60), truckImg.getImage());
		screenObjects.add(7, truck2A);
		Timer timer4A = new Timer(15, new ActionListener() {	
			public void actionPerformed(ActionEvent e) {		
				Point location = truck2A.getLocation();
				double newDown = location.x -= truck2speed;
				MyVector vector = new MyVector(newDown, location.y);
				truck2A.setVector(vector);
				truck2A.moveCheck();
		//		repaint();				
				}
		});
		timer4A.setInitialDelay(5000);
		timer4A.start();
		if (lives == 0)
			timer4A.stop();
		
	}
	
	/**
	 * Initializes all Log objects and starts moving them in a direction with a speed.
	 */
	public void addLog()
	{
		
		final Log logUpper = new Log(new Point(-150, 86), new Rectangle(80, 42),logImg.getImage());
		screenObjects.add(8, logUpper);
		Timer timerLog1 = new Timer(15, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point location = logUpper.getLocation();
				double newX = location.x += log1speed;
				MyVector vector = new MyVector(newX, location.y);
				logUpper.setVector(vector);
				logUpper.moveCheck();
			//	repaint();
			}
		});
		//timerLog1.setInitialDelay(2000);
		timerLog1.start();
		if (lives == 0)
			timerLog1.stop();
		
		
		final Log logMid = new Log(new Point(1000, 156), new Rectangle(80, 42),logImg.getImage());
		screenObjects.add(9, logMid);
		Timer timerLog2 = new Timer(15, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point location = logMid.getLocation();
				double newX = location.x -= log2speed;
				MyVector vector = new MyVector(newX, location.y);
				logMid.setVector(vector);
				logMid.moveCheck();
	//			repaint();
			}
		});
		//timerLog2.setInitialDelay(1000);
		timerLog2.start();
		if (lives == 0)
			timerLog2.stop();
		
		
		final Log logDown = new Log(new Point(0, 220), new Rectangle(80, 42),logImg.getImage());
		screenObjects.add(10, logDown);
		Timer timerLog3 = new Timer(15, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point location = logDown.getLocation();
				double newX = location.x += log3speed;
				MyVector vector = new MyVector(newX, location.y);
				logDown.setVector(vector);
				logDown.moveCheck();
				repaint();
			}
		});
		timerLog3.start();
		if (lives == 0)
			timerLog3.stop();
		
	}
	
	/**
	 * Initializes all LilyPad objects and sets their location.
	 */
	public void addLilyPad()
	{
		LilyPad lily1 = new LilyPad(new Point(186, 28), new Rectangle(102, 52), lilyPadImg.getImage());
		lily1.setVector(new MyVector(0, 0));
		lily1.setAngle(0);
		screenObjects.add(11, lily1);
		
		LilyPad lily2 = new LilyPad(new Point(451, 28), new Rectangle(102, 52), lilyPadImg.getImage());
		lily2.setVector(new MyVector(0, 0));
		lily2.setAngle(0);
		screenObjects.add(12, lily2);
		
		LilyPad lily3 = new LilyPad(new Point(715, 28), new Rectangle(102, 52), lilyPadImg.getImage());
		lily3.setVector(new MyVector(0, 0));
		lily3.setAngle(0);
		screenObjects.add(13, lily3);
	}
	
	public void addWater()
	{
		Water water = new Water(new Point(0, 84), new Rectangle(1000, 180), lilyPadImg.getImage());
		water.setVector(new MyVector(0, 0));
		water.setAngle(0);
		screenObjects.add(14, water);
	}
	
	/**
	 * Initializes the player controlled frog and sets its starting location.
	 */
	public void addFrog()
	{
		int x = screenWidth / 2 - 25;
		int y = screenHeight - 90;
		Frog playerFrog = new Frog(new Point(x, y), new Rectangle(50, 50), frogImg.getImage());
		playerFrog.setVector(new MyVector(0, 0));
		playerFrog.setAngle(0);
		screenObjects.add(0, playerFrog);

	}
	
	/**
	 * Draws the images to be displayed on the screen.
	 */
	public void paintComponent(Graphics g)
	{
		screenWidth = this.getWidth();
		screenHeight = this.getHeight();
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		for (int i = 1; i < screenObjects.size(); i++)
		{
			ScreenObject ref = screenObjects.get(i);
			ref.draw(g);
		}
		ScreenObject first = screenObjects.get(0);
		first.draw(g);
		if (lives == 0)
			g.drawImage(background, 0, 0, null);

	}
	
	/**
	 * Timer listener that checks for collisions between objects and updates accordingly.
	 */
	private class TimerListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			for (int i = 0; i < screenObjects.size(); i++) 
			{
				ScreenObject obj = screenObjects.get(i);
				if (obj instanceof MovingScreenObject) 
				{
					MovingScreenObject playerFrog = (MovingScreenObject) obj;
					// now see if it collides with any other objects
					for (int j = i + 1; j < screenObjects.size(); j++) 
					{
						ScreenObject otherObj = screenObjects.get(j);
						if (!(otherObj instanceof MovingScreenObject)) {
							continue;
						}
						if (playerFrog == otherObj) {
							continue;  // in other words, don't compare to self
						}
						if (otherObj instanceof MovingScreenObject) 
						{
							MovingScreenObject otherMovingObj = (MovingScreenObject) otherObj;
							
							if (playerFrog instanceof Frog) 
							{								
								
								// Check for collision with Lily Pad.  Reset Frog to start and do victory conditions.
								if (otherMovingObj instanceof LilyPad)
								{
									if (playerFrog.collide(otherMovingObj))
									{
										lives ++;
										label.setText("Lives: " + lives);
										int x = screenWidth / 2 - 25;
										int y = screenHeight - 90;
										playerFrog.setLocation(new Point(x, y));
										log3speed++;
										log2speed++;
										log1speed++;
										car1speed++;
										car2speed++;
										truck1speed++;
										truck2speed++;
										repaint();										
										//TODO: play sound
									}
								}
								
								// Check for collision with Car.  Decrement lives and reset position.  Check for game over conditions.
								if (otherMovingObj instanceof Car) 
								{
									if (playerFrog.collide(otherMovingObj)) 
									{
										lives --;
										label.setText("Lives: " + lives);
										int x = screenWidth / 2 - 25;
										int y = screenHeight - 90;
										playerFrog.setLocation(new Point(x, y));
										repaint();
										
										if (lives == 0) 
										{
											playerFrog.setLocation(new Point(x, y));
											background = gameOver;
											ogTimer.stop();
											repaint();
										}
									}
									//TODO: play sound
								}
								
									// Check for collision with Log and move Frog along the Log.
									if (otherMovingObj instanceof Log)
									{								
										if (playerFrog.collide(otherMovingObj))
										{
											Point location = otherMovingObj.getLocation();
											playerFrog.moveCheck();
											playerFrog.setLocation(new Point(location.x, location.y));
											break;
										}										
									}
									
									// If frog is not on a log, check for collision with water.
									else if (otherMovingObj instanceof Water)
									{
										if (playerFrog.collide(otherMovingObj))
										{
											lives --;
											label.setText("Lives: " + lives);
											int x = screenWidth / 2 - 25;
											int y = screenHeight - 90;
											playerFrog.setLocation(new Point(x, y));
											repaint();
											
											if (lives == 0) 
											{
												playerFrog.setLocation(new Point(x, y));
												background = gameOver;
												ogTimer.stop();
												repaint();
											}
										}
									}
							}							
						}						
					}
				}
			}
		}
	}
	
			
			
			
		
							
		
		
		
		
	
	/**
	 * Key Listener that moves the frog in the four cardinal directions.
	 */
	public void keyPressed (KeyEvent event)
	{
		int keyCode = event.getKeyCode();
		Frog playerFrog = null;
		if (screenObjects.get(0) instanceof Frog) 
			{playerFrog = (Frog) screenObjects.get(0);}
		
		switch (keyCode) 
		{

			case KeyEvent.VK_UP:
			if (playerFrog != null) 
			{
				Point location = playerFrog.getLocation();
				double newUp = location.y -= 70;
				MyVector vector = new MyVector(location.x, newUp);
				playerFrog.setVector(vector);
				playerFrog.moveCheck();
			}
			break;
		
			
			case KeyEvent.VK_DOWN:
			if (playerFrog != null) 
			{
				Point location = playerFrog.getLocation();
				double newDown = location.y += 70;
				MyVector vector = new MyVector(location.x, newDown);
				playerFrog.setVector(vector);
				playerFrog.moveCheck();
			}
			break;
		
			
			case KeyEvent.VK_RIGHT:
			if (playerFrog != null) 
			{
				Point location = playerFrog.getLocation();
				double newRight = location.x += 70;
				MyVector vector = new MyVector(newRight, location.y);
				playerFrog.setVector(vector);
				playerFrog.moveCheck();
			}
			break;
		
			
			case KeyEvent.VK_LEFT:
			if (playerFrog != null) 
			{
				Point location = playerFrog.getLocation();
				double newLeft = location.x -= 70;
				MyVector vector = new MyVector(newLeft, location.y);
				playerFrog.setVector(vector);
				playerFrog.moveCheck();
			//	vector.moveCheck();
			}
			break;
			
		}

		repaint();

	}


	public void keyReleased(KeyEvent arg0) 
	{// TODO Auto-generated method stub
	}

	
	public void keyTyped(KeyEvent arg0) 
	{// TODO Auto-generated method stub
	}

}
