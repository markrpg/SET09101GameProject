package gameProject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


/**
 * Square class can hold 4 characters. 40200606
 */
public class Square extends JPanel implements Observable {
	/**
	 * Private x and y attributes
	 */
	public int X, Y;

	/**
	 * Character list to hold all characters inside square.
	 */
	ArrayList<Character> charactersInSquare;

	/**
	 * Default constructor for square.
	 * 
	 * @param x
	 *            - The X coordinates of square.
	 * @param y
	 *            - The Y coordinates of square.
	 */
	public Square(int x, int y) {
		// Set X and Y
		X = x;
		Y = y;

		// Set Squares border
		Border border = LineBorder.createBlackLineBorder();
		setBorder(border);
		// Set each tile to specific size
		setPreferredSize(new Dimension(190, 190));
		setLayout(new GridLayout(2, 2, 0, 0));
		// Initialize charactersInSquare arraylist
		charactersInSquare = new ArrayList<Character>();
		// Construct Tile
		constructTileForCharacters();
	}

	/**
	 * Method used to add characters to square.
	 */
	public boolean addCharacterToSquare(Character inputCharacter) {
		// If there is space to add character to square
		if (charactersInSquare.size() < 4) {
			// Add new character to square
			charactersInSquare.add(inputCharacter);
			// Reconstruct square factoring in new character
			constructTileForCharacters();
			return true;
		}
		return false;
	}

	/**
	 * Method used to remove characters from square.
	 */
	public void removeCharacterFromSquare(Character characterToRemove) {
		// Set to dead
		characterToRemove.alive = false;
		charactersInSquare.remove(characterToRemove);
		constructTileForCharacters();
	}

	/**
	 * Method used to construct a tile whenever its created or changed.
	 */
	private void constructTileForCharacters() {
		// Remove all current characters from square
		removeAll();
		// Revalidate the Square
		revalidate();
		// Repaint the Square
		repaint();
		// Local variable to hold count
		int count = 0;
		// Load in swamp image and set all land by default swamp
		ImageIcon swampIcon = resizeImageToFit(new ImageIcon(
				"Resources/swamp.png"));

		// Generate Square depending on characters in it
		for (Character character : charactersInSquare) {
			count++;
			add(character);
		}

		// if count less than 4 construct the rest of the tiles as swamp
		for (int i = count; i < 4; i++) {
			add(new JLabel(swampIcon));
		}

	}

	/**
	 * Method to resize square image.
	 * 
	 * @param imageToResize
	 *            - Image to resize.
	 * @return - Image resized.
	 */
	private ImageIcon resizeImageToFit(ImageIcon imageToResize) {
		ImageIcon imageIcon = imageToResize;
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(190, 190,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		return imageIcon = new ImageIcon(newimg);

	}

	/**
	 * Notifies player that enemies have entered the square
	 */
	@Override
	public void notifyPlayer() {

		//Create thread to be run if player kills enemy
		Thread playSoundThread;
		
		// Go through all characters in square
		for (int i = 0; i < charactersInSquare.size(); i++) {

			// If player is in the square notify him that enemies are near
			// The player will respond with an answer
			if (charactersInSquare.get(i) instanceof Player) {
				// Tell the player how many enemies are in the square
				if (((Player) charactersInSquare.get(i))
						.canPlayerBeatEnemies(charactersInSquare.size()) == true) {
					// Remove enemies
					for (int ii = 0; ii < charactersInSquare.size(); ii++) {
						// Check if snake
						if (charactersInSquare.get(ii) instanceof Snake) {
							//Create new thread
							playSoundThread = new Thread(new PlaySound());
							//Play sound
							playSoundThread.start();
							//Show message
							JOptionPane
									.showMessageDialog(null,
											"Hek Shouts: Get Out My Swamp! whilst chewing a Snake!");
							removeCharacterFromSquare(((Snake) charactersInSquare
									.get(ii)));
							// Decrement to prevent out of bounds
							ii--;
						}
						if (charactersInSquare.get(ii) instanceof Donkey) {
							//Create new thread
							playSoundThread = new Thread(new PlaySound());
							//Play sound
							playSoundThread.start();
							//Show message
							JOptionPane
									.showMessageDialog(null,
											"Hek Shouts: Get Out My Swamp! whilst slaughtering a Donkey!");
							removeCharacterFromSquare(((Donkey) charactersInSquare
									.get(ii)));
							// Decrement to prevent out of bounds
							ii--;
						}
						if (charactersInSquare.get(ii) instanceof Parrot) {
							//Create new thread
							playSoundThread = new Thread(new PlaySound());
							//Play sound
							playSoundThread.start();
							//Show message
							JOptionPane
									.showMessageDialog(null,
											"Hek Shouts: Get Out My Swamp! whilst chomping a Parrot!");
							removeCharacterFromSquare(((Parrot) charactersInSquare
									.get(ii)));
							// Decrement to prevent out of bounds
							ii--;
						}
						if (charactersInSquare.get(ii) instanceof Knight) {
							//Create new thread
							playSoundThread = new Thread(new PlaySound());
							//Play sound
							playSoundThread.start();
							//Show message
							JOptionPane
									.showMessageDialog(null,
											"Hek Shouts: Get Out My Swamp! whilst gobbling up a Knight!");
							removeCharacterFromSquare(((Knight) charactersInSquare
									.get(ii)));
							// Decrement to prevent out of bounds
							ii--;
						}
					}
				}
				// Break from for loop
				break;
			}
		}

	}
}
