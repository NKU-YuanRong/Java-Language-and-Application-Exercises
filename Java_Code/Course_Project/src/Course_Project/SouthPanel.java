package Course_Project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SouthPanel extends JPanel{
	private JButton DrawRoundButton = new JButton("∫Õ∆Â");
	private JButton RetractButton = new JButton("ª⁄∆Â");
	private JButton AdmitDefeatButton = new JButton("»œ ‰");
	public SouthPanel() {
		//setLayout(new GridLayout(3, 1));
		super();
		add(DrawRoundButton);
		add(RetractButton);
		add(AdmitDefeatButton);
		DrawRoundButton.setEnabled(false);
		RetractButton.setEnabled(false);
		AdmitDefeatButton.setEnabled(false);
		addListener();
	}
	public void changeButtonAvailable(){
		DrawRoundButton.setEnabled(true);
		RetractButton.setEnabled(true);
		AdmitDefeatButton.setEnabled(true);
	}
	private void addListener() {
		DrawRoundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vars.control.DrawRoundRequest();
			}
		});
		RetractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vars.control.RetractRequest();
			}
		});
		AdmitDefeatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vars.control.AdmitDefeatRequest();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}
