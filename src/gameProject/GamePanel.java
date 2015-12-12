package gameProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/**
 * GamePanel contains all elements of the game interface. 40200606
 */
public class GamePanel extends JPanel {

	/**
	 * X & Y of game grid
	 */
	private int xSize;
	private int ySize;

	/**
	 * Factory pattern instance used to create characters.
	 */
	private CharacterFactory characterFactory;

	/**
	 * Character Move Receiver for command pattern used to facilitate movement
	 * and encapsulate historic movement.
	 */
	private CharacterMoveReceiver characterMoveReceiver;

	/**
	 * JPanel that contains actual game grid squares.
	 */
	private JPanel gameGrid;

	/**
	 * ArrayList to hold reference to squares in GamePanel
	 */
	public ArrayList<Square> squares;

	/**
	 * ArrayList to hold reference to all characters in current game
	 */
	public ArrayList<Character> allCharactersInGame;

	/**
	 * GamePanel default constructor
	 */
	public GamePanel(int xsize, int ysize) {
		// Set X & Y
		ySize = ysize;
		xSize = xsize;
		// Initialise character movement receiver for command pattern
		characterMoveReceiver = new CharacterMoveReceiver(xsize, ysize);
		// Initialise character factory for factory pattern.
		characterFactory = new CharacterFactory();
		// Generate the squares for GamePanel
		generateSquares(xSize, ySize, true);
		// Generate Game Grid
		generateGameGrid(xSize, ySize);
		// Create a JScrollPane to separate GamePanel from ControlsPanel
		JScrollPane scrollPane = new JScrollPane();
		// Set the view of scroll panel to a generated game grid
		scrollPane.setViewportView(gameGrid);
		// Add it to GamePanel
		add(scrollPane);
	}

	/**
	 * Method to undo the last movement of all characters.
	 */
	public void undoLastMove() {
		// Regenerate squares
		generateSquares(xSize, ySize, false);

		// Go through all characters and undo their movement using command
		// pattern
			// Create invoker
			CharacterMoveInvoker control = new CharacterMoveInvoker();
			// Initiate command with receiver and character.
			GameCommand UndoMoveCommand = new UndoMoveCommand(
					characterMoveReceiver, allCharactersInGame);
			// Set command in invoker
			control.setCommand(UndoMoveCommand);
			// Carry out command.
			control.moveCharacter();

		//Remove characters with 0,0 coordinates from game
		for(int i = 0; i< allCharactersInGame.size();i++)
		{
			if(allCharactersInGame.get(i).X == 0 && allCharactersInGame.get(i).Y == 0)
				allCharactersInGame.remove(i);
		}
		
		// Add new list of characters to their squares
		for (int ii = 0; ii < squares.size(); ii++) 
		{
			for (Character character : allCharactersInGame) {
				if (squares.get(ii).X == character.X
						&& squares.get(ii).Y == character.Y) {
					squares.get(ii).addCharacterToSquare(character);
				}
			}
		}
		
		
	}

	/**
	 * Method to move all characters randomly in any direction by one square.
	 */
	public void moveCharacters() {
		// Regenerate squares
		generateSquares(xSize, ySize, false);

		// Enemy possibilities
		String typesOfEnemy[] = { "Knight", "Parrot", "Snake", "Donkey" };

		// Hold player x and y
		int playerX = 0;
		int playerY = 0;

		// Enemy default coordinates
		int newEnemyX = 0;
		int newEnemyY = 0;

		// For all players initiate random movement using command pattern.
			// Create invoker
			CharacterMoveInvoker control = new CharacterMoveInvoker();
			// Initiate command with receiver and character.
			GameCommand MoveCommand = new MoveCommand(characterMoveReceiver, allCharactersInGame);
			// Set command in invoker
			control.setCommand(MoveCommand);
			// Carry out command.
			control.moveCharacter();
		

		// Get players X/Y
		for (Character player : allCharactersInGame) {
			if (player instanceof Player) {
				playerX = player.X;
				playerY = player.Y;
			}
		}


		// Add new character to game by 1 in 3 chance
		if (getRandomNum(1, 3) == 3) {
			allCharactersInGame.add(characterFactory.createCharacter(
					typesOfEnemy[getRandomNum(0, 3)], newEnemyX, newEnemyY));
		}
		
		// Add new list of characters to their squares
		for (int ii = 0; ii < squares.size(); ii++) {
			for (Character character : allCharactersInGame) {
				if (squares.get(ii).X == character.X
						&& squares.get(ii).Y == character.Y 
						&& character.alive == true) {
					squares.get(ii).addCharacterToSquare(character);
				}
			}
		}

		// Tell the square containing the player to check for enemies
		for (int ii = 0; ii < squares.size(); ii++) {

			if (squares.get(ii).X == playerX && squares.get(ii).Y == playerY) {
				squares.get(ii).notifyPlayer();
				break;
			}
		}

	}

	/**
	 * Method to generate squares for GamePanel
	 */
	public void generateSquares(int xSize, int ySize, boolean newGame) {
		// Initialize arraylist containing all squares
		squares = new ArrayList<Square>();
		// If the game is new reset player list
		if (newGame)
			allCharactersInGame = new ArrayList<Character>();
		// Generate swamp array
		for (int i = 0; i < xSize; i++) {
			for (int ii = 0; ii < ySize; ii++) {
				// New square
				Square square = new Square(i, ii);
				squares.add(square);

			}
		}
		// Regenerate game grid after changing squares
		generateGameGrid(xSize, ySize);

	}

	/**
	 * Method used to add characters to game
	 * 
	 * @param character
	 *            - Character to add to game.
	 */
	public void addCharacterToGame(Character character) {
		allCharactersInGame.add(character);
		for (Square square : squares) {
			if (square.X == character.X && square.Y == character.Y) {
				square.addCharacterToSquare(character);
			}
		}
	}

	/**
	 * Method used to create game grid for swamp.
	 * 
	 * @return - Returns grid in the form or a JPanel
	 */
	private void generateGameGrid(int xSize, int ySize) {
		if (gameGrid == null) {
			// Create new JPanel for game grid
			gameGrid = new JPanel();
			// Set layout
			gameGrid.setLayout(new GridLayout(ySize, xSize, 0, 0));
			// Set background colour
			gameGrid.setBackground(Color.DARK_GRAY);
		}
		// Remove everything within JPanel to refresh
		gameGrid.removeAll();
		// Populate with squares
		for (int i = 0; i < squares.size(); i++) {
			gameGrid.add(squares.get(i));
		}
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
