package gameProject;

/**
 * Observer interface part of the Observer design pattern. 40200606
 */
public interface Observer {

	/**
	 * Define the method to check if the player (observer) can beat the enemies
	 * nearby or not.
	 * 
	 * @param charactersInSquare
	 *            - The number of characters in a square.
	 * @return - Returns true if the player can defeat enemies.
	 */
	public boolean canPlayerBeatEnemies(int charactersInSquare);
}
