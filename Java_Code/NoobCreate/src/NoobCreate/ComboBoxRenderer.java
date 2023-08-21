package NoobCreate;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer<Color>{
	
	public ComboBoxRenderer() {
		super();
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setPreferredSize(new Dimension(290, 40));
		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Color> list,
			Color value, int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		Color s = (Color)value;
		//System.out.println(s);
		setBackground(s);
		setForeground(s);
		
		return this;
	}
	
	
}
