package Course_Project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistoryNorthPanel extends JPanel{
	JButton ExitToMain = new JButton("返回");
	JButton LastRound = new JButton("上一局");
	JLabel CurrentRound = new JLabel("");
	JButton NextRound = new JButton("下一局");
	public HistoryNorthPanel(int cur) {
		// TODO Auto-generated constructor stub
		super();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		AddListener();
		add(ExitToMain);
		add(LastRound);
		add(CurrentRound);
		add(NextRound);
		CurrentRound.setText("当前为：第 " + ++cur + " 局");
	}
	
	public void TurnToPage(int cur){
		CurrentRound.setText("当前为：第 " + ++cur + " 局");
		this.repaint();
	}
	
	private void AddListener() {
		// TODO Auto-generated method stub
		ExitToMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vars.switcher.BackToMain();
			}
		});
		LastRound.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vars.historycontroler.TurnToLastRound();
			}
		});
		NextRound.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vars.historycontroler.TurnToNextRound();
			}
		});
	}
}
