// Imports
import javax.swing.JLabel;

// Extending JLabel can hold pictures
// 'Abstract' vs 'Concrete' 
// Abstract - concept but you cannot build objects
@SuppressWarnings("serial")
public abstract class Mover extends JLabel{
	
	// Current position of the mover
	private int row;
	private int column;
	
	// Change in row and column
	// Direction of the mover
	private int dRow; // d - delta (change)
	private int dColumn;
	
	// Allows the ghost to 'die' - goes back home again
	private boolean isDead;

	// Getters and Setters
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getdRow() {
		return dRow;
	}

	public void setdRow(int dRow) {
		this.dRow = dRow;
	}

	public int getdColumn() {
		return dColumn;
	}

	public void setdColumn(int dColumn) {
		this.dColumn = dColumn;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	// UTILITY METHODS
	
	// Move method
	// Changes the mover's current position based on their current direction
	public void move() {
		
		row += dRow;
		column += dColumn;
		
	}
	
	// Setting of the direction method (left - 0, up - 1, right - 2, down - 3)
	// Takes direction variable as a parameter
	public void setDirection(int direction) {
		
		// Set direction of the mover to 0
		dRow = 0;
		dColumn = 0;
		
		// If the direction is 0 (left), then set the column to -1, which makes you go left
		if (direction == 0) // LEFT
			dColumn = -1;
		
		// Otherwise if the direction is 1 (up), then set the row to -1, which makes you go up
		else if (direction == 1) // UP
			dRow = -1; // It's -1 when it goes upwards (opposite from normal y-axis)
		
		// Otherwise if the direction is 2 (right), then set the column to 1, which makes you go right
		else if (direction == 2) // RIGHT
			dColumn = 1;
		
		// Otherwise if the direction is 3 (down), then set the row to 1, which makes you go down
		else if (direction == 3) // DOWN
			dRow = 1; // It's +1 when it goes downwards (opposite from normal y-axis)
		
	}
	
	// Get the direction method
	public int getDirection() {
		
		// If the row is not changing (stationary at 0) and column is to the left
		if (dRow == 0 && dColumn == -1) 		// LEFT
			return 0;
		
		// Otherwise if the row is going upwards and column is not changing (stationary at 0)
		else if (dRow == -1 && dColumn == 0)	// UP
			return 1;
		
		// Otherwise if the row is not changing and column is not changing (stationary at 0)
		else if (dRow == 0 && dColumn == 1)		// RIGHT
			return 2;
		
		// Otherwise if the row is going downwards and column is not changing (stationary at 0)
		else							 		// DOWN
			return 3;
		
	}
	
	// Get the next row method
	public int getNextRow() {
		
		// Returns the mover's next row
		return row + dRow;
		
	}
	
	// Get the next column method
	public int getNextColumn() {
		
		// Returns the mover's next column
		return column + dColumn;
		
	}
	
} // End of class
