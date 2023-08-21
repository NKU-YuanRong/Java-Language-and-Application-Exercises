package DataBaseWork;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SysFrame {
	JFrame frame = new JFrame("Database Online Marking System");
	JPanel CardPanel = new JPanel();
	CardLayout card = new CardLayout();
	public SysFrame() {
		// TODO Auto-generated constructor stub
		frame.setSize(800, 600);
		frame.setLocation(280, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardPanel.setLayout(card);
		//添加界面代码
		CardPanel.add(Vars.mainpanel);
		CardPanel.add(Vars.operatingpanel);
		
		
		frame.setContentPane(CardPanel);
		frame.setVisible(true);
	}
	
	public void SetFrameVisible(boolean b) {
		frame.setVisible(b);
	}
	
	public void BeginMainPanel(){
		card.first(CardPanel);
	}
	
	public void BeginOperating(){
		card.first(CardPanel);
		card.next(CardPanel);
	}
}
