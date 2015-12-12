package gameProject;

import javax.swing.ImageIcon;

/**
 * Class to define a Parrot character. 40200606
 */
public class Parrot extends Character {
	/**
	 * Parrot default constructor
	 * 
	 * @param x
	 *            - Initial X coord of the Parrot.
	 * @param y
	 *            - Initial Y coord of the Parrot.
	 */
	public Parrot(int x, int y) {
		// Set Parrot icon and coordinates
		super(new ImageIcon("Resources/parrot.png"), x, y);
	}

}
