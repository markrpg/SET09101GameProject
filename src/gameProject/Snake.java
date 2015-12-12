package gameProject;

import javax.swing.ImageIcon;

/**
 * Class used to define a Snake in the game. 40200606
 */
public class Snake extends Character {
	/**
	 * The default constructor for the Snake.
	 * 
	 * @param x
	 *            - The initial X coord of the Snake.
	 * @param y
	 *            - The initial Y coord of the Snake.
	 */
	public Snake(int x, int y) {
		// Set snake icon and coordinates
		super(new ImageIcon("Resources/snake.png"), x, y);
	}

}
