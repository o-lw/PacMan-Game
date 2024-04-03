
// Imports
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// By extending the class with JFrame, it acts like a screen
// By implementing action listener, you set up objects to respond to events that occur (like clicking buttons)

@SuppressWarnings("serial") // Removes the warnings
public class PacManTitleScreen extends JFrame implements ActionListener {

	// Calls the Sound class through the created variable
	Sound sound = new Sound();

	// Labels

	// Makes the image as the background
	JLabel backgroundLabel = new JLabel(new ImageIcon("titleScreenImages/PacMan Title Screen.jpg"));
	JLabel usernameLabel = new JLabel("Username:");

	// Buttons
	JButton startButton = new JButton("START");
//	JButton musicOFFButton = new JButton ("Music [OFF]");
//	JButton musicONButton = new JButton ("Music [ON]");

	// Allows the user to enter their username in the textbox
//	JTextField enterUsername = new JTextField();

	// Colours
	Color backgroundColour = new Color(91, 15, 0);
	Color startButtonColour = new Color(255, 255, 0);
	Color white = new Color(255, 255, 255);
//	Color musicOFFButtonColour = new Color(0, 255, 255);
//	Color musicONButtonColour = new Color(0, 255, 255);

	// Constructor
	public PacManTitleScreen() {

		// Sets the size of the frame
		setSize(1440, 900);
		setLayout(null);

		// When you press "X" it closes the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Does not allow the user to change the size of the frame
		setResizable(false);
		backgroundLabel.setLayout(null);

		// Sets the title of the frame
		setTitle("Pac Man Title Screen");

		// Buttons
		// Set bounds of start Button
		startButton.setBounds(520, 480, 400, 120);
		
		// For some reason it's not letting me change the background colour of the button
//		startButton.setBackground(backgroundColour);
//		startButton.setOpaque(false);

		startButton.setForeground(backgroundColour);

		

		// Makes the button reactive
		startButton.addActionListener(this);

		// Sets the font of the start button
		startButton.setFont(new Font("Arial", Font.BOLD, 35));

//		musicOFFButton.setFont(new Font("Arial", Font.BOLD, 35));
//		musicONButton.setFont(new Font("Arial", Font.BOLD, 35));

		// Adds each button to the background
		backgroundLabel.add(startButton);

//		backgroundLabel.add(musicOFFButton);
//		backgroundLabel.add(musicONButton);

		// Labels
//		usernameLabel.setBounds(450, 350, 250, 50);

//		usernameLabel.setFont(new Font("Arial", Font.BOLD, 27));
//		usernameLabel.setForeground(white);

//		backgroundLabel.add(usernameLabel);

		// Set bounds of text field
//		enterUsername.setBounds(600, 350, 370, 40);
//		enterUsername.setFont(new Font("Arial", Font.PLAIN, 17));

		// Add text field to the background
//		backgroundLabel.add(enterUsername);

//		// musicOFFButton
//		musicOFFButton.setBounds(450, 600, 350, 120);
////		musicOFFButton.setBackground(backgroundColour);
//		musicOFFButton.setForeground(musicOFFButtonColour);
//
//		musicOFFButton.addActionListener(this);

//		// musicONButton
//		musicONButton.setBounds(700, 600, 350, 120);
//		musicONButton.setBackground(backgroundColour);
//		musicONButton.setForeground(musicOFFButtonColour);
//
//		musicOFFButton.addActionListener(this);

		// Adds a layer of background to add the labels and buttons
		backgroundLabel.setBounds(0, 0, 1440, 890);
		backgroundLabel.setOpaque(true);
		add(backgroundLabel);

		// Plays the intro music
		playMusic(8);

		// Makes the frame visible
		setVisible(true);

	} // End of constructor

	// Listens to the actions performed (e.g. clicking a button) and proceeds
	// accordingly
	@Override
	public void actionPerformed(ActionEvent event) {

		// If the user clicks on the startButton button,
		if (event.getSource() == startButton) {

			// Stop music here
			stopMusic();

			// Call the PacManGUI class (which is the actual game)
			new PacManGUI();

		}

	} // End of action performed

//	public boolean musicOFF() {
//		
//		if (stopMusic())
//					
//			return true;
//		
//	}

	// Plays the music
	public void playMusic(int i) {

		// Calls the setFile from Sound class and takes the index of the array
		sound.setFile(i);
		sound.play();
		sound.loop();

		// If you want to play a music from index 0, playMusic(0), it will pass 0 to
		// (int i) --> (i)

	} // End of play music

	// Stops the music
	public void stopMusic() {

		sound.stop();

	} // End of stop music

} // End of class
