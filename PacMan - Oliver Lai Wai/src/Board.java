
/**
 * 
 * @author oliver.laiwai
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

// Extends JPanel - It's like a fancy piece of paper that we're putting on the surface
// Implements KeyListener and ActionListener for responsive interactions
public class Board implements KeyListener, ActionListener {

	// JLabel
	JLabel scoreLabel = new JLabel("SCORE: 0");

	// Creates an extended JPanel
	JPanel scorePanel = new JPanel();

	// Creates sound variable for the Sound() class
	Sound sound = new Sound();

	// Colours
	Color backgroundColour = new Color(91, 15, 0);

	// Creates game timer
	private Timer gameTimer = new Timer(250, this); // 250 - speed of timer (the smaller the number, the faster)

	// Creates animated timer
	private Timer animateTimer = new Timer(50, this); // Pac Man chomping (opening and closing mouth)

	// Creates WALL constant (it says final)
	private static final ImageIcon WALL = new ImageIcon("modifiedImages/StdWallModified.png");

	// Creates FOOD constant
	private static final ImageIcon FOOD = new ImageIcon("modifiedImages/candy.png");

	// Creates BLANK constant
	private static final ImageIcon BLANK = new ImageIcon("images/Black.bmp");

	// Creates DOOR constant
	private static final ImageIcon DOOR = new ImageIcon("images/Door.bmp");

	// Creates a SKULL constants for when Pac Man dies
	private static final ImageIcon SKULL = new ImageIcon("images/Skull.bmp");

	// Creates GATE constant
	private static final ImageIcon GATE = new ImageIcon("modifiedImages/gatetohell-2.gif");

	// Creates a maze
	private char[][] maze = new char[25][27]; // [25] - Rows, [27] - Columns

	// Creates a cell
	private JLabel[][] cell = new JLabel[25][27];

	// Creates Pac Man object
	private PacMan pacMan;

	// Creates ghost object
	private Ghost[] ghost = new Ghost[3]; // [3] - the amount of ghosts

	// Creates the pellets and sets it to 0
	private int pellets = 0;

	// Creates the score and sets it to 0
	private int score = 0;

	// Creates pac man step - chomping
	private int pStep;

	// JPanels
	public static JPanel backPanel = new JPanel();
	public static JPanel topPanel = new JPanel();
	public static JPanel bottomPanel = new JPanel();

	// Constructor
	public Board() {

		// No layout for the back panel
		backPanel.setLayout(null);

		// Creates top panel and sets the bounds (for the score)
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 600, 50);
		topPanel.setForeground(Color.BLACK);
		// scoreLabel.setOpaque(false);

		// Adds the top panel to the back panel
		backPanel.add(topPanel);

		// Creates bottom panel
		bottomPanel.setBounds(0, 30, 600, 700);

		// Imports GridLayout that makes "setBounds" process much easier
		// It's like an invisible grid paper
		bottomPanel.setLayout(new GridLayout(25, 27));
		bottomPanel.setBackground(backgroundColour);
		backPanel.add(bottomPanel);

		// Sets the bounds of the score label
		scoreLabel.setBounds(0, 0, 200, 50);
		// scoreLabel.setOpaque(false);
		// scoreLabel.setForeground(Color.BLACK);
		scoreLabel.setBackground(Color.BLACK);

		scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));

		// Adds the score label onto the score panel
		scorePanel.add(scoreLabel);

		// Adds the score panel onto the top panel
		topPanel.add(scorePanel);

		// Creates pacMan variable from the PacMan class
		pacMan = new PacMan();

		// Creates ghost variables from Ghost class
		ghost[0] = new Ghost(0);
		ghost[1] = new Ghost(1);
		ghost[2] = new Ghost(2);

		// Loads the board
		loadBoard();

		// To restart the game, you may need to reset variables - score, pellets, etc.
		// and call the loadBoard() method

	}

	// This method loads the board
	private void loadBoard() {

		// Creates a variable for rows and initializes it to 0
		int r = 0;

		// Creates input variable from Scanner utility
		Scanner input;

		// Checks if the file is accessible
		try {

			// Opens up the maze file and reads it
			input = new Scanner(new File("maze.txt")); // Scanner input = new Scanner(new File("maze.txt"));

			// While there is still a character to read, it will keep running
			while (input.hasNext()) {

				//
				maze[r] = input.nextLine().toCharArray();

				// It adds a column for every row
				for (int c = 0; c < maze[r].length; c++) {

					// Create a JLabel that contains row and column
					cell[r][c] = new JLabel();

					// If there is a "W" in the row and/or column,
					if (maze[r][c] == 'W')

						// Set the cell icon to WALL
						cell[r][c].setIcon(WALL);

					// Otherwise, if there is an "F" in the row and/or column
					else if (maze[r][c] == 'F') {

						// Set the cell icon to FOOD
						cell[r][c].setIcon(FOOD);

						pellets++; // Keeps track of the amount of food
					}

					// Otherwise, if there is a "P" in the row and/or column
					else if (maze[r][c] == 'P') {

						cell[r][c].setIcon(pacMan.getIcon());
						pacMan.setRow(r);
						pacMan.setColumn(c);
						pacMan.setDirection(0); // 0 - LEFT
					}

					// Otherwise, if there is a 0 or 1 or 2 in the row and/or column
					else if (maze[r][c] == '0' || maze[r][c] == '1' || maze[r][c] == '2') {

						// ASCII Code - '0' is 48, '1' is 49, etc.
						// int gNum = Character.getNumericValue(maze[r][c]);

						// Create a variable that represents the number of ghosts
						int gNum = (int) (maze[r][c]) - 48;

						// Set the cell (rows and columns) based on the ghost's number
						cell[r][c].setIcon(ghost[gNum].getIcon());
						ghost[gNum].setRow(r);
						ghost[gNum].setColumn(c);

					}

					// Otherwise if there is a "D" in the row and/or column of the maze
					else if (maze[r][c] == 'D')

						// Set the cell of this specific row and column to a DOOR
						cell[r][c].setIcon(DOOR);

					// Otherwise if there is a "G" in the row and/or column of the maze
					else if (maze[r][c] == 'G')

						// Set the cell of this specific row and column to a GATE
						cell[r][c].setIcon(GATE);

					// Adds the picture onto the screen
					bottomPanel.add(cell[r][c]);

					// 8 pictures in total - 4 directions; Open vs Closed mouth

				} // End of for loop

				// Increases row
				r++;

			} // End of while statement

			// Closes the file
			input.close();

			// If the file is unaccessible, output an error message
		} catch (FileNotFoundException error) {

			System.out.println("File Error");

		} // End of catch

	} // End of loadBoard() method

	// Listens to the actions performed (e.g. clicking a button) and proceeds
	// accordingly
	@Override
	public void keyPressed(KeyEvent key) {

		// If the timer did not running and Pac Man is not dead
		if (gameTimer.isRunning() == false && pacMan.isDead() == false) {

			// Start the game timer
			gameTimer.start();

		}

		// Score is the pellets
		// 450 pellets
		// 450 score means Pac Man ate everything

		// If Pac Man is not dead and the score is not equal to the pellets collected
		if (pacMan.isDead() == false && score != pellets) {

			// ASCII - 37 left arrow, 38 is up arrows
			int direction = key.getKeyCode() - 37;

			// If the direction is to the left (0) and there isn't a wall and a gate
			if (direction == 0 && maze[pacMan.getRow()][pacMan.getColumn() - 1] != 'W'
					&& maze[pacMan.getRow()][pacMan.getColumn() - 1] != 'G')

				// Move left
				pacMan.setDirection(0);

			// Otherwise if the direction is up (1) and there isn't a wall and a gate
			else if (direction == 1 && maze[pacMan.getRow() - 1][pacMan.getColumn()] != 'W'
					&& maze[pacMan.getRow() - 1][pacMan.getColumn()] != 'G')

				// Move up
				pacMan.setDirection(1);

			// Otherwise if the direction is to the right (1) and there isn't a wall and a
			// gate
			else if (direction == 2 && maze[pacMan.getRow()][pacMan.getColumn() + 1] != 'W'
					&& maze[pacMan.getRow()][pacMan.getColumn() + 1] != 'G')

				// Move right
				pacMan.setDirection(2);

			// Otherwise if the direction is down (3) and there isn't a wall and a gate
			else if (direction == 3 && maze[pacMan.getRow() + 1][pacMan.getColumn()] != 'W'
					&& maze[pacMan.getRow() + 1][pacMan.getColumn()] != 'G')

				// Move down
				pacMan.setDirection(3);

		} // End of if statement

	} // End of keyPressed method

	// There's no code here on purpose
	// It's just there so that the key interactions can run properly
	@Override
	public void keyTyped(KeyEvent e) {

	}

	// There's no code here on purpose
	// It's just there so that the key interactions can run properly
	@Override
	public void keyReleased(KeyEvent e) {

	}

	// This method creates the "door" move where you teleport on the other side of
	// the maze
	private void performMove(Mover mover) {

		// If you're on one side of the door,
		if (mover.getColumn() == 1) {

			// It bumps to the other side
			mover.setColumn(24);

			// Erases your character to move Pac Man
			cell[12][1].setIcon(DOOR);

		}

		// Same thing but the opposite
		else if (mover.getColumn() == 25) {

			mover.setColumn(2);

			cell[12][25].setIcon(DOOR);

		}

		// If the mover is not going towards the wall and the gate
		if (maze[mover.getNextRow()][mover.getNextColumn()] != 'W') {

			// If the mover is Pac Man
			if (mover == pacMan) {

				// It's going to play the "chomping" animation
				animateTimer.start();

			}

			// Otherwise, if the mover is a ghost
			else {

				// If the ghost is moving on the food, the food doesn't disappear
				if (maze[mover.getRow()][mover.getColumn()] == 'F')
					cell[mover.getRow()][mover.getColumn()].setIcon(FOOD);

				else if (maze[mover.getRow()][mover.getColumn()] == 'G')
					cell[mover.getRow()][mover.getColumn()].setIcon(GATE);

				// Otherwise, make the cell blank/empty
				else
					cell[mover.getRow()][mover.getColumn()].setIcon(BLANK);

				// Make the ghosts move
				mover.move();

				// If Pac Man collided to a ghost
				if (collided())

					// Call the "death" method, which makes the Pac Man die and stops the game
					death();

				// Otherwise, it will keep going
				else
					cell[mover.getRow()][mover.getColumn()].setIcon(mover.getIcon());

			}

		}

	} // End of performMove method

	// If Pac Man and a ghost land on the same column, they collided
	private boolean collided() {

		// Selects all three ghosts
		for (int g = 0; g < 3; g++) {

			// If the ghost collided, return true
			if (ghost[g].getRow() == pacMan.getRow() && ghost[g].getColumn() == pacMan.getColumn())
				return true;

		} // End of for loop

		// Otherwise, return false
		return false;

	} // End of collided() method

	// This method is when Pac Man dies
	private void death() {

		// Pac Man is dead
		pacMan.setDead(true);

		// Stops the game
		stopGame();

		// Set the cell where Pac Man died to a skull icon
		cell[pacMan.getRow()][pacMan.getColumn()].setIcon(SKULL);

	}

	// This method stops the game
	private void stopGame() {

		// If Pac Man is dead or the score is equal to the number of pallets
		if (pacMan.isDead() || score == pellets) {

			// Stop the 'chomping' animation and the game timer
			animateTimer.stop();
			gameTimer.stop();

			// Plays the dying sound effect
			playSoundEffect(5);

		}

	}

	// Makes the ghosts move randomly (TO DO: make them smart not just move
	// randomly)
	private void moveGhosts() {

		//
		for (Ghost g : ghost) {

			int dir = 0;

			//
			do {

				dir = (int) (Math.random() * 4);

			} while (Math.abs(g.getDirection() - dir) == 2); // (1 and 3) or (3 and 1) and (0 and 2) or (2 and 0)

			g.setDirection(dir);

			performMove(g);

		}

	}

	// Adds unimplemented methods
	@Override
	public void actionPerformed(ActionEvent event) {

		// If the game timer starts, allow Pac Man to move and make the ghosts move
		if (event.getSource() == gameTimer) {

			performMove(pacMan);
			moveGhosts();

		}

		// Otherwise if animate timer starts, animate Pac Man depending on its steps
		else if (event.getSource() == animateTimer) {

			// Calls the animatePacMan method
			animatePacMan();

			// Increases Pac Man's steps
			pStep++;

			// If Pac Man is on step 3 (third frame), make it the same as step 0
			if (pStep == 3)
				pStep = 0;

		}

	} // End of action performed

	// Pac Man animation (opening and closing mouth)
	private void animatePacMan() {

		// Basically it animates Pac Man in 3 steps (or frames)

		// At step 0 (the stationary step)
		if (pStep == 0) {

			// Set the Pac Man look at the left direction
			cell[pacMan.getRow()][pacMan.getColumn()].setIcon(PacMan.IMAGE[pacMan.getDirection()][1]);

			// Sets the timer of the chomping animation
			animateTimer.setDelay(100); // When changing the delay, it affects the gate

		}

		// When Pac Man finished eating the food, make that cell blank
		else if (pStep == 1) {

			cell[pacMan.getRow()][pacMan.getColumn()].setIcon(BLANK);

		}

		// If Pac Man is on step 2 (second frame)
		else if (pStep == 2) {

			// Move the Pac Man
			pacMan.move();

			// If Pac Man is on the food cell
			if (maze[pacMan.getRow()][pacMan.getColumn()] == 'F') { // Fixes the small bug on the gate where Pac Man
																	// would eat the gate when there's food

				// Increases the score
				score++;

				// Changes the score
				scoreLabel.setText("Score: " + score);

				// Plays the chomping sound effect
				playSoundEffect(6);

				// Makes that cell empty (E for "Empty")
				maze[pacMan.getRow()][pacMan.getColumn()] = 'E';

			}

			// Stops the timer
			animateTimer.stop();

			// If Pac Man is dead, set that cell to a skull icon
			if (pacMan.isDead())
				cell[pacMan.getRow()][pacMan.getColumn()].setIcon(SKULL);

			// Otherwise, keep Pac Man on the same direction but close his mouth
			else
				cell[pacMan.getRow()][pacMan.getColumn()].setIcon(PacMan.IMAGE[pacMan.getDirection()][0]); // 0 - when mouth is closed
																											
		}

	} // End of animate Pac Man

	// Plays the music
	public void playMusic(int i) {

		// Calls the setFile from Sound class and takes the index of the array
		sound.setFile(i);
		sound.play();
		sound.loop();

		// If you want to play a music from index 0, playMusic(0), it will pass 0 to
		// (int i) --> (i)

	}

	// Stops the music
	public void stopMusic() {

		sound.stop();

	}

	// Plays the sound effect
	public void playSoundEffect(int i) {

		// Calls setFile from Sound class and takes the index of the array
		sound.setFile(i);

		// Plays the sound
		sound.play();

		// Don't loop sound effect

	}

} // End of Board class
