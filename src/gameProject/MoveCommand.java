package gameProject;

import java.util.ArrayList;

/**
 * The MoveCommand class implementing the GameCommand interface used in the
 * command pattern. 40200606
 */
public class MoveCommand implements GameCommand {
	/**
	 * Instance of character move receiver.
	 */
	CharacterMoveReceiver characterMoveReceiver;

	/**
	 * Instance of character.
	 */
	ArrayList<Character> charactersToMove;

	/**
	 * Default constructor for MoveCommand.
	 * 
	 * @param charactermoveReceiver
	 *            - The receiver to be used when moving character.
	 * @param charactertoMove
	 *            - The character to move.
	 */
	public MoveCommand(CharacterMoveReceiver charactermoveReceiver,
			ArrayList<Character> characterstoMove) {
		// Set receiver
		characterMoveReceiver = charactermoveReceiver;
		// Set character
		charactersToMove = characterstoMove;
	}

	/**
	 * Execute method implemented from GameCommand.
	 */
	@Override
	public void execute() {
		characterMoveReceiver.moveCharacter(charactersToMove);

	}

}
