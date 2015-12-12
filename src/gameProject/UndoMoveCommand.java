package gameProject;

import java.util.ArrayList;

/**
 * Defines command to undo movement for characters in the game. 40200606
 */
public class UndoMoveCommand implements GameCommand {

	/**
	 * The receiver for the character movement.
	 */
	CharacterMoveReceiver characterMoveReceiver;

	/**
	 * Character to undo its movement.
	 */
	ArrayList<Character> charactersToUndoMove;

	/**
	 * Default constructor for UndoMoveCommand.
	 * 
	 * @param charactermoveReceiver
	 *            - Receiver for command pattern in undoing movement.
	 * @param charactertoUndoMove
	 *            - The character to undo its movement.
	 */
	public UndoMoveCommand(CharacterMoveReceiver charactermoveReceiver,
			ArrayList<Character> characterstoUndoMove) {
		// Initialise receiver
		characterMoveReceiver = charactermoveReceiver;
		// Initialise character
		charactersToUndoMove = characterstoUndoMove;
	}

	/**
	 * Part of the GameCommand, in the command pattern used to carryout undoing
	 * of character movement.
	 */
	@Override
	public void execute() {
		characterMoveReceiver.undoCharacterMove(charactersToUndoMove);

	}

}
