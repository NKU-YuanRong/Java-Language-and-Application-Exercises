package NoobCreate;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DoAndUndo extends JPanel{
	static JButton UndoBtn = new JButton("<<");
	static JButton DoBtn = new JButton(">>");
	public DoAndUndo() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
		setPreferredSize(new Dimension(50, 5));
		add(UndoBtn);
		add(DoBtn);
		
		UndoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DrawingPanel.UndoLast();
			}
		});
		
		DoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
