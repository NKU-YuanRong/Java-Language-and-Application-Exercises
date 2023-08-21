package Chapter14;
import javax.swing.*;
import java.awt.*;

public class JavaGUITest {
	public static void main(String[] args){
		JFrame frame = new JFrame("Top Container");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("dududududu");
		frame.setSize(800, 500);
		JLabel label = new JLabel("Hello");
		JLabel label2 = new JLabel("Hello 2");
		JPanel newPanel = new JPanel();
		newPanel.add(label, BorderLayout.CENTER);
		newPanel.add(label2, BorderLayout.NORTH);
		//frame.getContentPane().add(label, BorderLayout.CENTER);//内容面板可以替换
		//frame.getContentPane().add(label2, BorderLayout.NORTH);
		frame.setContentPane(newPanel);
		//frame.pack();
		frame.setVisible(true);
	}
}
