/**
 * 
 * Name: Oliver Lai Wai
 * Date: May 31, 2022
 * Title: Pac Man by Oliver Lai Wai

 * Description:
 * Welcome to my Pac-Man game! This application replicates the famous game of Pac-Man.. with a little twist. In order to win, you must collect all the candies, 
 * but it won’t be that easy! Beware of the crazy farmer, zombie pig, and evil pumpkin. From the look, they may seem intimidating, but don’t worry, they are 
 * empty-headed! If you click on start, it will open up the game in no time. Good luck and have fun! Don’t get a sugar rush though…
 
 * Major Skills:
	- NEW: Audio Input Stream
		- AudioSystem.getAudioInputStream()
		- .play(), .stop(), .loop(), .LOOP_CONTINUOUSLY

	- Extends JFrame, JPanel, implements Action Listener
	- JLabel, JPanel, JButton, JTextField
	- actionPerformed (ActionEvent event)
	- If, else if statements
	- ASCII (for arrow keys)
	- try, catch
	- textArea
	- .setBounds/Background/Text/Editable/Visible/…
	- .add( )
	- GridLayout()
	- Main method
	- Constants
		- e.g. WALL, FOOD, DOOR, GATE, etc.
	- Constructors
	- Arrays
		- E.g. setting the images of the ghosts, cells (rows and columns)
		
 * Added features:
 	- Gate
		- Pac Man isn’t allowed to enter
		- Only ghosts can enter and exit
		- Cool animated gate (.gif file)!
 	- Score
		- The score increases when Pac Man eats the food
	
	- Music/Sound
		- Music plays and sound plays when necessary
	
 	- Themes
		- Changed the theme to Halloween

 */

// This class simulates the Pac Man game where you need to collect as many coins without getting caught by a ghost
public class PacManGame {

	// Allows the program to start
	public static void main(String[] args) {
		
		// Creates a new class and calls it
		new PacManTitleScreen();
	
	} // End of main method

} // End of class
