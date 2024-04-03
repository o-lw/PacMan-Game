// Imports
import javax.swing.ImageIcon;

// Extends Mover class we created
public class Ghost extends Mover {
	
	// Creates an array for the image icon of the ghosts
	public static final ImageIcon[] IMAGE = {
			
			new ImageIcon("modifiedImages/zombiePig.png"), 
			new ImageIcon("modifiedImages/pumpkin.png"), 
			new ImageIcon("modifiedImages/crazyFarmer.png"), 

	};

	// Applies an image to each ghost (Ghost constructor)
	public Ghost(int gNum) { // (int gNum) represents the ghost number
		
		// Sets the image of the ghost based on the ghost's number
		this.setIcon(IMAGE[gNum]);
		
	}

} // End of class
