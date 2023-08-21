package NoobCreate;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ToolBar extends JPanel{
	public ToolBar() throws HeadlessException {
		super();
		setLayout(new GridLayout(3, 2));
		
		add(new DoAndUndo());
		add(new JPanel());
		add(new ShapeColorPanel());
		add(new TextPanel());
		add(new BackGroundPanel());
		add(new SizePanel());
		// TODO Auto-generated constructor stub
	}
}