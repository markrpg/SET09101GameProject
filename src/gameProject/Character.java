package gameProject;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Character Abstract Class to make many different types of characters including
 * player. 40200606
 */
public abstract class Character extends JLabel {
	/**
	 * The state of the character true for alive, false for dead
	 */
	public boolean alive;
	/**
	 * The X & Y coordinates of character.
	 */
	public int X, Y;

	/**
	 * The image of particular character.
	 */
	private ImageIcon characterIcon;

	/**
	 * The Character class default constructor
	 */
	public Character(ImageIcon charactericon, int x, int y) {
		// Set character icon
		characterIcon = resizeImageToFit(charactericon);
		// Set Icon
		setImageIcon();
		// Set X and Y
		X = x;
		Y = y;
		// Set to alive by default
		alive = true;
	}

	/**
	 * Method to move the character in any direction by one
	 * 
	 * @param xSize
	 *            - The size of the maximum X.
	 * @param ySize
	 *            - The size of the maximum Y.
	 */
	public void randomlyMove(int xSize, int ySize) {
		// Temp variable to hold new movement coordinates
		int newMoveX = 0;
		int newMoveY = 0;

		// change x y by one within bounds of grid
		while ((newMoveX >= xSize || newMoveY >= ySize)
				|| (newMoveX == 0 && newMoveY == 0)
				|| (newMoveX < 0 || newMoveY < 0)) {
			// Randomly pick x or y to move
			int random = getRandomNum(0, 3);

			if (random == 0) {
				// Move Left
				newMoveX = X - 1;
				newMoveY = Y;
			} else if (random == 1) {
				// Move Right
				newMoveX = X + 1;
				newMoveY = Y;
			} else if (random == 2) {
				// Move up
				newMoveX = X;
				newMoveY = Y - 1;
			} else if (random == 3) {
				// Move Down
				newMoveX = X;
				newMoveY = Y + 1;

			}
		}

		// Set the new final coordinates
		X = newMoveX;
		Y = newMoveY;
	}

	/**
	 * Method to set image of particular character.
	 */
	private void setImageIcon() {
		// Set character image
		setIcon(characterIcon);
	}

	/**
	 * Method to resize image to fit square its in.
	 * 
	 * @param imageToResize
	 *            - The image to resize.
	 * @return - Returns resized image.
	 */
	private ImageIcon resizeImageToFit(ImageIcon imageToResize) {
		ImageIcon imageIcon = imageToResize;
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		return imageIcon = new ImageIcon(newimg);

	}

	/**
	 * Method used to get a random number for x and y.
	 * 
	 * @param min
	 *            - The minimum number to randomly return.
	 * @param max
	 *            - The maximum number to randomly return.
	 * @return - returns a random number based on range.
	 */
	private static int getRandomNum(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
