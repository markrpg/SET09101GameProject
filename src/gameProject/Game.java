package gameProject;

import javax.swing.JOptionPane;

/**
 * Swamp Wars - SET09101 - 40200606
 */
public class Game {

	/**
	 * Program entry point for game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RunGameWindow();
	}

	/**
	 * Method used to create game window
	 */
	public static void RunGameWindow() {
		try {
			// Get user input for swamp size
			String splitInputSwampSize[];
			String swampSize = (String) JOptionPane.showInputDialog(null,
					"Set Swamp size, Example: " + "\"4,4\"", "Swamp Size",
					JOptionPane.PLAIN_MESSAGE);

			// Split size into array
			splitInputSwampSize = swampSize.split(",");

			// Cast sizes into integers and pass to GameWindow for building
			GameWindow window = new GameWindow(
					Integer.parseInt(splitInputSwampSize[0]),
					Integer.parseInt(splitInputSwampSize[1]));
			// Show GameWindow
			window.setVisible(true);
		}
		// Catch any exceptions during sizes entry
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Please enter a correct value (ex: 4,4) " + e.getMessage());
		}
	}

}
