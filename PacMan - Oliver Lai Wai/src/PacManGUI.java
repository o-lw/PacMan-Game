/**
 * 
 * @author oliver.laiwai
 *
 */

import javax.swing.*;

// Removes the warnings
@SuppressWarnings("serial")

public class PacManGUI extends JFrame {
	
	// Creates a private class called board - it's like a piece of paper that we're adding
	private Board board = new Board();
	
	// Constructor
	public PacManGUI() {
			
		// Sets up the frame by setting the size, title, and default close operation
		setSize(600, 750);
		setTitle("PacMan - Oliver Lai Wai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Adds a keyboard listener the board class
		addKeyListener(board);
		
		// Adds the board to the back panel (not the bottom panel)
		add(board.backPanel);
		
		// Makes the frame visible
		setVisible(true);
		
	}
	
	
	
}
