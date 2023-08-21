package Course_Project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistorySouthPanel extends JPanel{
	JButton LastStep = new JButton("��һ��");
	JLabel NowStep = new JLabel("���׼�����");
	JButton NextStep = new JButton("��һ��");
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
			NowStep.setText("���׼�����");
		}
		else{
			NowStep.setText("��" + ++cur + "��");
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
		NowStep.setText("���׼�����");
	}
}
