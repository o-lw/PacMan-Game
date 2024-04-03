// Imports
import javax.swing.ImageIcon;

// First time extending our own class called Mover!
public class PacMan extends Mover{
	
	// Creates an array for the image icon of Pac Man
	public static final ImageIcon[][] IMAGE = {
			
			// 0 - left; 0 - closed; [0][0]
			{ new ImageIcon("images/PacLeftClosed.bmp"), new ImageIcon("images/PacLeftOpen.bmp") },
			
			{ new ImageIcon("images/PacUpClosed.bmp"), new ImageIcon("images/PacUpOpen.bmp") },
			
			{ new ImageIcon("images/PacRightClosed.bmp"), new ImageIcon("images/PacRightOpen.bmp") },
			
			{ new ImageIcon("images/PacDownClosed.bmp"), new ImageIcon("images/PacDownOpen.bmp") }
			
	}; // Add semicolon because it's a DEFINITION
	
	// Applies an image to Pac Man (Pac Man Constructor)
	public PacMan() {
		
		// Sets the image of Pac Man
		this.setIcon(IMAGE[0][0]); // Shows Pac Man facing left while mouth is closed
		
	}
	
} // End of class
