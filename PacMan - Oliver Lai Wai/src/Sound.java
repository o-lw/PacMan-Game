
/* Credit Source link: 
 * https://www.youtube.com/watch?v=nUHh_J2Acy8
 */

// Imports
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// This class specializes in getting the audio file and sets the sound features (play, stop, loop) so that they are ready to be used
public class Sound {

	// Declare clip to open audio file
	Clip clip;
	
	// Create array containing 10 sound URLs
	URL soundURL[] = new URL[20];
	
	// Constructor
	public Sound() {
		
		soundURL[0] = getClass().getResource("sounds/extrapac.wav");
		soundURL[1] = getClass().getResource("sounds/fruiteat.wav");
		soundURL[2] = getClass().getResource("sounds/GAMEBEGINNING.wav");
		soundURL[3] = getClass().getResource("sounds/GHOSTEATEN.wav");
		soundURL[4] = getClass().getResource("sounds/interm.wav");
		soundURL[5] = getClass().getResource("sounds/killed.wav");
		soundURL[6] = getClass().getResource("sounds/pacchomp.wav");
		soundURL[7] = getClass().getResource("sounds/Pac-Man Fever.mp3");
		soundURL[8] = getClass().getResource("sounds/pacmanintro (better quality).wav");
		soundURL[9] = getClass().getResource("sounds/Thumbs.db");
		
	}
	
	// Gets the audio file
	public void setFile(int i) {
		
		// Checks if the file is accessible
		try {
			// ais is short for Audio Input Stream
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			
			// This is a way to open an audio file in Java
			clip = AudioSystem.getClip();
			clip.open(ais);
		
		// Otherwise, display an error message
		} catch (Exception error) {
			System.out.println("File not found.");
		}
		
	}
	
	// Method that plays the sound
	public void play() {
		
		// Starts the audio file
		clip.start();
		
	}
	
	// Method that loops the sound
	public void loop() {
		
		// Continuously loops the sound
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	
	// Method that stops the sound
	public void stop() {
		
		clip.stop();
		
	}
	
} // End of Sound class
