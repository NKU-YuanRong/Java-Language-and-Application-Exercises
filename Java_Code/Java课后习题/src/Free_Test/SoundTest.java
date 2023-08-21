package Free_Test;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundTest {
	//File file = new File("D:/ChessingSound2.wav");
	File file = new File("D:/BackGroundSound.wav");
	AudioInputStream am;
	AudioFormat af;
	SourceDataLine sd;
	int sumByteRead = 0;
	byte [] b = new byte[320];
	public SoundTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// TODO Auto-generated constructor stub
		am = AudioSystem.getAudioInputStream(file);
		af = am.getFormat();
		DataLine.Info dl = new DataLine.Info(SourceDataLine.class, af);
		sd = AudioSystem.getSourceDataLine(af);
		sd.open();
		sd.start();
		//sd.close();
	}
	
	
	public void Sound() throws IOException{
		while (sumByteRead != -1) {
			sumByteRead = am.read(b, 0, b.length);
			if(sumByteRead >= 0 ) {
				sd.write(b, 0, b.length);
			}
		}
		
		//sd.write(b, 0, b.length);
		sd.drain();
//		sd.write(b, 0, b.length);
//		sd.drain();
		//sumByteRead = 0;
	}
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		SoundTest st = new SoundTest();
		st.Sound();
	}
}
