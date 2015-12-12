package gameProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * ControlPanelBehaviour interface using the strategy pattern to set the games
 * controls behaviour. 40200606
 */
public interface ControlPanelBehaviour extends ActionListener {

	/**
	 * Class implementing ControlPanelBehaviour used to create new games.
	 */
	public class NewGame implements ControlPanelBehaviour {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			GameWindow.newGame();
		}

	}

	/**
	 * Class implementing ControlPanelBehaviour Used to perform a new move.
	 */
	public class NewMove implements ControlPanelBehaviour {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			GameWindow.newMove();

		}

	}

	/**
	 * Class implementing ControlPanelBehaviour used to undo move.
	 */
	public class UndoMove implements ControlPanelBehaviour {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			GameWindow.undoLastMove();

		}

	}

	/**
	 * Class implementing ControlPanelBehaviour used to change players diet to
	 * ogre enemies.
	 */
	public class ChangeDietToOgreEnemies implements ControlPanelBehaviour {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Set diet to ogre enemies
			GameWindow.changePlayerDiet("ogre enemies");
			// Show confirmation message
			JOptionPane.showMessageDialog(null,
					"Players diet changed to ogre enemies!");
		}

	}

	/**
	 * Class implementing ControlPanelBehaviour used to change players diet to
	 * very big macs.
	 */
	public class ChangeDietToVeryBigMacs implements ControlPanelBehaviour {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Set diet to very big macs
			GameWindow.changePlayerDiet("very big macs");
			// Show confirmation message
			JOptionPane.showMessageDialog(null,
					"Players diet changed to very big macs!");

		}

	}
}
