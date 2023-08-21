package NoobCreate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShapeColorPanel extends JPanel{
	static Color[] PainterColors = {new Color(240,161,168), Color.black, Color.red, Color.orange, Color.yellow, Color.green, Color.magenta, Color.blue, Color.pink};
	static JLabel Text = new JLabel("Shape Color");
	static JComboBox<Color> Colors = new JComboBox<Color>(PainterColors);
	public ShapeColorPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		Text.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
		add(Text);
		
		Colors.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//ControlCenter.ShapeColor = (Color)Colors.getSelectedItem();
				ControlCenter.setShapeColor((Color)Colors.getSelectedItem());
			}
		});
		Colors.setRenderer(new ComboBoxRenderer());
		add(Colors);
		// TODO Auto-generated constructor stub
	}
}
