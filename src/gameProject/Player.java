package gameProject;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Class used to define a Player (ogre) within the game. 40200606
 */
public class Player extends Character implements Observer {
	/**
	 * State of the players diet (very big macs or ogre enemies)
	 */
	private String PlayerDiet;

	/**
	 * Boolean so we can know if character is alive or not
	 */
	public boolean alive;

	/**
	 * Default constructor of the Player class.
	 * 
	 * @param x
	 *            - The initial X coord of the player (ogre).
	 * @param y
	 *            - The initial Y coord of the player (ogre).
	 */
	public Player(int x, int y) {
		// Set players icon
		super(new ImageIcon("Resources/ogre.png"), x, y);
		// Initially set the players diet to ogre enemies
		PlayerDiet = "ogre enemies";
		// Set character to alive initially
		alive = true;
	}

	/**
	 * Method used to set the players diet.
	 * 
	 * @param diet
	 *            - the diet to set.
	 */
	public void setDiet(String diet) {
		PlayerDiet = diet;
	}

	/**
	 * The observer method used to check if the player can beat the enemies
	 * based on amount of enemies nearby.
	 */
	@Override
	public boolean canPlayerBeatEnemies(int charactersInSquare) {
		// Temp int to hold number of enemies
		int numOfEnemies = charactersInSquare;
		// If one enemy in square kill it
		if (numOfEnemies == 2) {
			return true;
		}
		// If two enemies in square check diet and die/kill
		else if (numOfEnemies == 3) {
			// If players diet is ogre enemies kill enemies
			if (PlayerDiet == "ogre enemies")
				return true;
			// If players diet is not ogre enemies end game
			else
				GameWindow.endGame();
			return false;
		}
		// if three enemies in square die and end game
		else if (numOfEnemies == 4) {
			// Ogre cant fight that many enemies end the game
			GameWindow.endGame();
			return false;
		}

		// Return false should never reach this.
		return false;

	}

}
