package NoobCreate;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel extends JPanel{
	static JLabel Text = new JLabel("Text");
	static JTextField TextPlace = new JTextField();
	public TextPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		Text.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
		add(Text);
		TextPlace.setPreferredSize(new Dimension(400, 49));
		TextPlace.setFont(new Font("TimesNewRoman", Font.BOLD, 40));
		add(TextPlace);
		TextPlace.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ControlCenter.setDrawingText(TextPlace.getText());
				
			}
		});
		
		// TODO Auto-generated constructor stub
	}

}
