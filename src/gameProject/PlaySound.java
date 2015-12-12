package gameProject;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * Class to play fight sound for game implementing threads 40200606
 */
public class PlaySound implements Runnable {

	@Override
	public void run() {
		// Play Ogre Fight Sound
		try {
			// Audio Stream object
			AudioInputStream stream;
			// AudioFormat object
			AudioFormat format;
			// DataLine object
			DataLine.Info info;
			// Clip object
			Clip clip;
			// Get stream from wav sound file
			stream = AudioSystem.getAudioInputStream(new File(
					"Resources/ogrefight.wav"));
			// Find format
			format = stream.getFormat();
			// Get info
			info = new DataLine.Info(Clip.class, format);
			// Cast to clip
			clip = (Clip) AudioSystem.getLine(info);
			// Open stream
			clip.open(stream);
			// Start Stream (Play Sound)
			clip.start();
		} catch (Exception exc) {
			// Catch Exceptions
			exc.printStackTrace(System.out);
		}
	}

}
