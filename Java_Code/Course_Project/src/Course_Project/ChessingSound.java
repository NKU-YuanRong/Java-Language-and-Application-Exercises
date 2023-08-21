package Course_Project;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ChessingSound {
//	File file = new File("D:/BackGroundSound.wav");
	File file = new File("D:/个人文件/作业/Java/Course_Project/BackGroundSound.wav");
	AudioInputStream am;
	AudioFormat af;
	SourceDataLine sd;
	int sumByteRead = 0;
	byte [] b = new byte[320];
	public ChessingSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		am = AudioSystem.getAudioInputStream(file);
		af = am.getFormat();
		DataLine.Info dl = new DataLine.Info(SourceDataLine.class, af);
		sd = AudioSystem.getSourceDataLine(af);
		sd.open();
		sd.start();
	}
	public void Sound() throws IOException{
		while (sumByteRead != -1) {
			sumByteRead = am.read(b, 0, b.length);
			if(sumByteRead >= 0 ) {
				sd.write(b, 0, b.length);
			}
		}
		sd.drain();
		Sound();
	}
}
