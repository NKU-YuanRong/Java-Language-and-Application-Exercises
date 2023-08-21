package Chapter14;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyRenderer extends JLabel implements ListCellRenderer<Color>{
	//private static final String Value = null;
	//private ImageIcon[] images = new ImageIcon[10];
	
	
	public MyRenderer() {
		super();
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setPreferredSize(new Dimension(100, 50));
//		images[0] = new ImageIcon("1.png");
//		images[1] = new ImageIcon("2.png");
//		images[2] = new ImageIcon("3.png");
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
		
//		if("tom".equals(s)){
//			setIcon(images[0]);
//		}else if("Jerry".equals(s)){
//			setIcon(images[1]);
//		}else{
//			setIcon(images[2]);
//		}
		
	}
	
	
}
