package gameProject;

/**
 * The Invoker class for the Command Pattern Used to set the type of command at
 * runtime. 40200606
 */
public class CharacterMoveInvoker {
	/**
	 * The instance of command used.
	 */
	private GameCommand gameCommand;

	/**
	 * Method to set the command.
	 * @param command - Command to use.
	 */
	public void setCommand(GameCommand command) {
		this.gameCommand = command;
	}

	/**
	 * Method to call the execute method within a command.
	 */
	public void moveCharacter() {
		gameCommand.execute();
	}
}
