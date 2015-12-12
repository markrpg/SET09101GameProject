package gameProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * The receiver class for the command pattern. Used to encapsulate character
 * movements for undoing. 40200606
 */
public class CharacterMoveReceiver {

	/**
	 * Hashmap containing character references and historic X and Y
	 */
	private HashMap<Character, Stack<String>> historicCharacterMoves;
	/**
	 * Maximum X size of game grid.
	 */
	private int xSize;

	/**
	 * Maximum Y size of game grid.
	 */
	private int ySize;

	/**
	 * Default constructor used to initialise basic functionality.
	 * 
	 * @param xsize
	 *            - Maximum size of X.
	 * @param ysize
	 *            - Maximum size of Y.
	 */
	public CharacterMoveReceiver(int xsize, int ysize) {
		// Initialise Hashmap
		historicCharacterMoves = new HashMap<Character, Stack<String>>();
		// Set X and Y Limits
		xSize = xsize;
		ySize = ysize;
	}

	/**
	 * Method used to move character to another random square whilst storing
	 * last coordinates
	 * 
	 * @param characterToMove
	 *            - Character reference to move.
	 */
	public void moveCharacter(ArrayList<Character> charactersToMove) {

		// Perform random moving
		for (Character character : charactersToMove) {
			// Get Stack
			Stack<String> oldXYStack;

			if (historicCharacterMoves.containsKey(character)) { // get old
																	// moves to
																	// update
				oldXYStack = historicCharacterMoves.get(character);
				// Push new X and Y
				oldXYStack.push(character.X + "," + character.Y);
				// Replace current record with updates x and y change
				historicCharacterMoves.replace(character, oldXYStack);
				// Perform random move
				character.randomlyMove(xSize, ySize);
			} else {
				// Create stack for X and Y
				oldXYStack = new Stack<String>();
				// Push to stack
				oldXYStack.push(character.X + "," + character.Y);
				// Add to hashmap
				historicCharacterMoves.put(character, oldXYStack);
				// Perform random move
				character.randomlyMove(xSize, ySize);
			}
		}
	}

	/**
	 * Method to undo the last movement of character.
	 * 
	 * @param characterToUndo
	 *            - Character reference to undo movement.
	 */
	public void undoCharacterMove(ArrayList<Character> charactersToMove) {
		for (Character character : charactersToMove) {
			// Get Stack
			Stack<String> oldXYStack;

			if (historicCharacterMoves.containsKey(character)) { // get old
																	// moves to
																	// update
				oldXYStack = historicCharacterMoves.get(character);
				if (oldXYStack.size() >= 1) {
					// Get old X and Y store in array
					String array[] = oldXYStack.lastElement().split(",");
					// Pop X and Y
					oldXYStack.pop();
					// Replace current record with pops x and y change
					historicCharacterMoves.replace(character, oldXYStack);
					// Perform undo move
					character.X = Integer.parseInt(array[0]);
					character.Y = Integer.parseInt(array[1]);

					// If character dead revive it
					if (character.alive == false) {
						character.alive = true;
					}

				}
			}
		}

	}

}
