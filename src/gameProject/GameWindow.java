package gameProject;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 * GameWindow class builds whole window. 40200606
 */
public class GameWindow extends JFrame {

	/**
	 * The actual game grid side of the window.
	 */
	private static GamePanel gamePanel;

	/**
	 * The controls side of the game window.
	 */
	private static ControlPanel controlPanel;

	/**
	 * X size of Game Grid
	 */
	private static int xSize;

	/**
	 * Y size of Game Grid
	 */
	private static int ySize;

	/**
	 * Create the application window.
	 * 
	 * @param xsize
	 *            - X Size of game grid.
	 * @param ysize
	 *            - Y Size of game grid.
	 */
	public GameWindow(int xsize, int ysize) {
		// Set game grid x size
		xSize = xsize;
		// Set game grid y size
		ySize = ysize;
		// Initialise GameWindow
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		// Set title for GameFrame
		setTitle("Swamp Wars - SET09101 - 40200606");
		// Set close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Set size of GameFrame
		setSize(1024, 800);
		// Disable ability to resize
		setResizable(false);
		// Make new GameFrame visible
		setVisible(true);
		// GamePanel to add to GameFrame
		gamePanel = new GamePanel(xSize, ySize);
		// ControlsPanel to add to GameFrame
		controlPanel = new ControlPanel();
		// Creates SplitPane to split GamePanel and ControlsPanel
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				new JScrollPane(gamePanel), new JScrollPane(controlPanel));
		// Disable SplitPane to avoid user resizing it at runtime
		splitPane.setEnabled(false);
		// Gives the GamePanel more space
		splitPane.setDividerLocation(800);
		// Add the GamePanel and ControlsPanel divided by the SplitPane to
		// GameFrame
		add(splitPane);
		// Spawn player on creating window
		newGame();
	}

	/**
	 * Static method perform a new move for the game.
	 */
	public static void newMove() {

		gamePanel.moveCharacters();
	}

	/**
	 * Static method to end the game whenever called.
	 */
	public static void endGame() {

		// Show message that player died.
		JOptionPane.showMessageDialog(null, "You died!");
		// Create new game after last game ended
		newGame();
	}

	/**
	 * Static method to undo last move.
	 */
	public static void undoLastMove() {
		gamePanel.undoLastMove();
	}

	/**
	 * Method used to change the players diet
	 * 
	 * @param diet
	 *            - The diet to set.
	 */
	public static void changePlayerDiet(String diet) {
		// Find player and set his diet
		for (Square square : gamePanel.squares) {
			for (Character player : square.charactersInSquare) {
				if (player instanceof Player) {
					((Player) player).setDiet(diet);
					break;
				}
			}
		}
	}

	/**
	 * Static Method to create a new game.
	 */
	public static void newGame() {
		// Regenerate squares
		gamePanel.generateSquares(xSize, ySize, true);
		// Used to perform random number generation
		Random randGen = new Random();
		int x = 0;
		int y = 0;

		while (x == 0 && y == 0) {
			// X and Y that is generated
			x = getRandomNum(0, xSize - 1);
			y = getRandomNum(0, ySize - 1);
		}

		// Add player to game
		gamePanel.addCharacterToGame(new Player(x, y));
	}

	/**
	 * Method used to get a random number for x and y.
	 * 
	 * @param min
	 *            - The minimum number to randomly return.
	 * @param max
	 *            - The maximum number to randomly return.
	 * @return - returns a random number based on range.
	 */
	private static int getRandomNum(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
