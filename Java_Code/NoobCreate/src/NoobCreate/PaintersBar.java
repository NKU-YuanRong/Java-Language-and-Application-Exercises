package NoobCreate;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PaintersBar extends JPanel{
	static JButton Circle = new JButton();
	static JButton Oval = new JButton();
	static JButton Line = new JButton();
	static JButton Rect = new JButton();
	static JButton TextWriter = new JButton();
	
	static ImageIcon[] images = new ImageIcon[5];
	public PaintersBar() {
		images[0] = new ImageIcon("Circle.png");
		images[1] = new ImageIcon("Oval.png");
		images[2] = new ImageIcon("Line.png");
		images[3] = new ImageIcon("Rect.png");
		images[4] = new ImageIcon("Text.png");
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(90, 400));
		setLayout(new GridLayout(9, 1));
		Circle.setIcon(images[0]);
		add(Circle);
		Oval.setIcon(images[1]);
		add(Oval);
		Line.setIcon(images[2]);
		add(Line);
		Rect.setIcon(images[3]);
		add(Rect);
		TextWriter.setIcon(images[4]);
		add(TextWriter);
		
		Circle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControlCenter.setPainterShape(0);
				
				
			}
		});
		
		Oval.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControlCenter.setPainterShape(1);
			
			}
		});
		
		Line.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControlCenter.setPainterShape(2);
			
			}
		});
		
		Rect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControlCenter.setPainterShape(3);
			
			}
		});
		
		TextWriter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControlCenter.setPainterShape(4);
				//System.out.println(ControlCenter.PainterShape);
			}
		});
	}
}
