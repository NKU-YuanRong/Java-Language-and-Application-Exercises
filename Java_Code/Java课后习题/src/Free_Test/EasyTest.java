package Free_Test;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioSystem;

public class EasyTest {
	public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
		File file = new File("D:\\ChessingSound2.wav");
		//FileInputStream fi = new FileInputStream(file);
		AudioClip sound1 = Applet.newAudioClip(file.toURL());
		sound1.play();
	}
}
