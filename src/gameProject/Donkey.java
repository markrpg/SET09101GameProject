package gameProject;

import javax.swing.ImageIcon;

/**
 * Donkey class for the game 40200606
 */
public class Donkey extends Character {
	/**
	 * Donkey default constructor
	 * 
	 * @param x
	 *            - The initial X coord of the Donkey.
	 * @param y
	 *            - The initial Y coord of the Donkey.
	 */
	public Donkey(int x, int y) {
		// Set Donkey icon and coordinates through super class
		super(new ImageIcon("Resources/donkey.png"), x, y);
	}

}
