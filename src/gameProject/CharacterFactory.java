package gameProject;

/**
 * CharacterFactory class using Factory Pattern 40200606
 */
public class CharacterFactory {

	/**
	 * Method used to create characters depending on type.
	 * 
	 * @param typeOfCharacter
	 *            - The type of character to create
	 * @param x
	 *            - The X coordinates of character.
	 * @param y
	 *            - The Y coordinates of character.
	 * @return - Returns character instance.
	 */
	public Character createCharacter(String typeOfCharacter, int x, int y) {
		// Temporary character variable to return character
		Character character = null;

		// Switch statement used to create specific character type depending on
		// input
		switch (typeOfCharacter) {
		// Create Player
		case "Player":
			// Create new player with its coordinates
			character = new Player(x, y);
			break;
		// Create Donkey
		case "Donkey":
			// Create new donkey with its coordinates
			character = new Donkey(x, y);
			break;
		// Create Snake
		case "Snake":
			character = new Snake(x, y);
			break;
		// Create Knight
		case "Knight":
			character = new Knight(x, y);
			break;
		// Create Parrot
		case "Parrot":
			character = new Parrot(x, y);
			break;
		}

		// Return character
		return character;
	}

}
