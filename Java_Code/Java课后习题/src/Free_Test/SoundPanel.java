package Free_Test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundPanel extends JPanel{
	JButton jb = new JButton("...");
	SoundTest st;
	public SoundPanel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// TODO Auto-generated constructor stub
		add(jb,BorderLayout.CENTER);
		st = new SoundTest();
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					st.Sound();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		JFrame frame = new JFrame();
		frame.add(new SoundPanel());
		frame.setSize(800, 600);
		frame.setLocation(200, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
