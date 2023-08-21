package NoobCreate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackGroundPanel extends JPanel{
	static Color[] BackGroundColors = {Color.white, Color.yellow, Color.green, Color.black};
	static JLabel Text = new JLabel("BackGround");
	static JComboBox<Color> BColors = new JComboBox<Color>(BackGroundColors);
	public BackGroundPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		Text.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
		add(Text);
		BColors.setRenderer(new ComboBoxRenderer());
		add(BColors);
		BColors.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControlCenter.setDrawingBackGroundColor((Color) BColors.getSelectedItem());
				
				
			}
		});
		
		// TODO Auto-generated constructor stub
	}

}
