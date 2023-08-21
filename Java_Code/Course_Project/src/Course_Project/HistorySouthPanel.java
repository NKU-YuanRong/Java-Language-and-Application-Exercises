package Course_Project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistorySouthPanel extends JPanel{
	JButton LastStep = new JButton("上一子");
	JLabel NowStep = new JLabel("棋局准备完毕");
	JButton NextStep = new JButton("下一子");
	public HistorySouthPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(LastStep);
		add(NowStep);
		add(NextStep);
		AddListener();
	}
	public void SetNowStep(int cur){
		if(cur==-1){
			NowStep.setText("棋局准备完毕");
		}
		else{
			NowStep.setText("第" + ++cur + "手");
		}
		this.repaint();
	}
	private void AddListener() {
		LastStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vars.historycontroler.TurnToLastStep();
			}
		});
		NextStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vars.historycontroler.TurnToNextStep();
			}
		});
	}
	public void setPrePared() {
		// TODO Auto-generated method stub
		NowStep.setText("棋局准备完毕");
	}
}
