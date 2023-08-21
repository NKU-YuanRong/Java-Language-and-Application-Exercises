package Course_Project;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WatcherPanel extends JPanel{
	public WatcherPanel() {
		super();
		setLayout(new BorderLayout());
		add(new JLabel("π€’Ω÷–"),BorderLayout.NORTH);
//		add(Vars.watcherchesspanel,BorderLayout.CENTER);
//		add(Vars.watcherchatpanel,BorderLayout.EAST);
	}
}
