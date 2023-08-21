package Course_Project;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class NetGamePanel extends JPanel{
	JPanel BorderPanel = new JPanel();
	public NetGamePanel() {
		super();
		BorderPanel.setLayout(new BorderLayout());
		BorderPanel.add(Vars.northpanel,BorderLayout.NORTH);
		BorderPanel.add(Vars.chesspanel,BorderLayout.CENTER);
		BorderPanel.add(Vars.southpanel,BorderLayout.SOUTH);
		setLayout(new BorderLayout());
		add(BorderPanel,BorderLayout.CENTER);
		add(Vars.chatpanel,BorderLayout.EAST);
	}
}
