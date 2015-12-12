package gameProject;

/**
 * Abstract GameCommand used for the command pattern
 * 40200606
 */
public interface GameCommand {

	/**
	 * Defines the execute action for moving and undoing movement of characters
	 */
	public abstract void execute();

}
