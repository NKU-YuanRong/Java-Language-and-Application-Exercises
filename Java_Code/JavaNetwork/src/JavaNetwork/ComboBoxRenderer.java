package JavaNetwork;

import java.awt.Component;
import java.awt.Dimension;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer<Socket>{
	
	public ComboBoxRenderer() {
		super();
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setPreferredSize(new Dimension(100, 22));
		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Socket> list,
			Socket value, int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		String s = "Client" + index;
		setText(s);
		return this;
	}
	
	
}
