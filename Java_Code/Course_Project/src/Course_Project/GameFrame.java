package Course_Project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame {
	JFrame frame = new JFrame("Java GoBand");
	JPanel CardPanel = new JPanel();
	CardLayout card = new CardLayout();
	public GameFrame() {
		frame.setSize(800, 600);
		frame.setLocation(200, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardPanel.setLayout(card);
		CardPanel.add(Vars.mainpanel);
		CardPanel.add(Vars.connectionpanel);
		CardPanel.add(Vars.netgamepanel);
		CardPanel.add(Vars.watcherpanel);
		CardPanel.add(Vars.historypanel);
		frame.setContentPane(CardPanel);
		frame.setVisible(true);
	}
	public void SetFrameVisible(boolean b){
		frame.setVisible(b);
	}
	
	public void BeginNetMode() {
		card.first(CardPanel);
		card.next(CardPanel);
	}
	
	public void BackToMainPanel() {
		card.first(CardPanel);
	}
	public void BeginNetGame() {
		card.first(CardPanel);
		card.next(CardPanel);
		card.next(CardPanel);
	}
	
	public void BeginWatching(){
		card.first(CardPanel);
		card.next(CardPanel);
		card.next(CardPanel);
		card.next(CardPanel);
	}
	
	public void BeginHistory(){
		card.first(CardPanel);
		card.next(CardPanel);
		card.next(CardPanel);
		card.next(CardPanel);
		card.next(CardPanel);
		
	}
}
