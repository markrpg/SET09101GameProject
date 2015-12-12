package gameProject;

import javax.swing.ImageIcon;

/**
 * Class used to define a Knight Character. 40200606
 */
public class Knight extends Character {
	/**
	 * Default constructor of Knight
	 * 
	 * @param x
	 *            - Initial X coord of Knight.
	 * @param y
	 *            - Initial Y coord of Knight.
	 */
	public Knight(int x, int y) {
		// Set Knight icon and coordinates
		super(new ImageIcon("Resources/knight.png"), x, y);
	}
}
