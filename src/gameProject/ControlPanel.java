package gameProject;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * JPanel Class used to make game controls
 * 40200606
 */
public class ControlPanel extends JPanel
{
	
	/**
	 * ControlPanel default constructor
	 */
	public ControlPanel(){
	//Design the controls panel to hold buttons
	setLayout(new GridLayout(5,0,20,20));
	//Button used to create new games.
	JButton newGame = new JButton("New Game");
	add(newGame);
	newGame.addActionListener(new ControlPanelBehaviour.NewGame());	
	//Button used to do carry out a new move.
	JButton newMove = new JButton("New Move");
	add(newMove);
	newMove.addActionListener(new ControlPanelBehaviour.NewMove());		
	//Button used to undo last move
	JButton undoMove = new JButton("Undo Last Move");
	add(undoMove);
	undoMove.addActionListener(new ControlPanelBehaviour.UndoMove());	
	//Button used to change the players diet to ogre enemies.
	JButton ogreEnemiesDiet = new JButton("Change Diet to Ogre Enemies");
	add(ogreEnemiesDiet);
	ogreEnemiesDiet.addActionListener(new ControlPanelBehaviour.ChangeDietToOgreEnemies());	
	//Button used to change players diet to very big macs.
	JButton veryBigMacsDiet = new JButton("Change Diet to Very Bid Macs");
	add(veryBigMacsDiet);
	veryBigMacsDiet.addActionListener(new ControlPanelBehaviour.ChangeDietToVeryBigMacs());	
	}
}
