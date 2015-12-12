package gameProject;

/**
 * Observable class used to define an observable class within the game. 40200606
 */
public interface Observable {

	/**
	 * Define the method to add characters to a observable square
	 * 
	 * @param s
	 *            - Character to add to a square.
	 * @return - Returns true if character successfully added.
	 */
	public boolean addCharacterToSquare(Character s);

	/**
	 * Define the method to remove a character from a observable square.
	 * 
	 * @param s
	 *            - The character to remove from a square.
	 */
	public void removeCharacterFromSquare(Character s);

	/**
	 * Define the method to notify a player (observer) of the observable square.
	 */
	public void notifyPlayer();

}
