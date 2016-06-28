import javax.swing.JFrame;
/**
 * 
 * @author Daniel Tilgner, Sam Askew, Hunter Snellings, Ahmed Elgazar
 *
 */
public class GameWindow extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Main window to add panels to in order to see the GUI.
	 */
	public GameWindow()
	{
		setTitle("Frug Fun!");
		FrogScreen screen = new FrogScreen();
		//MainPanel panel = new MainPanel();
		add(screen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		screen.setFocusable(true);
		screen.requestFocusInWindow();
		
		setVisible(true);
		
	}
	
	/**
	 * Main method to create the Game Window.
	 * @param args
	 */
	public static void main(String[] args)
	{@SuppressWarnings("unused")
	GameWindow window = new GameWindow();}

}
