package Chapter17_ÍøÂç±à³Ì;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MerryChristmas {
	public static void main(String[] args) {
		JFrame f = new JFrame("Merry Christmas£¡");
//		JLabel bb = new JLabel("To My ÈüÈü:");
		JLabel bb = new JLabel("");
		bb.setFont(new Font("·ÂËÎ",Font.BOLD,40));
		f.getContentPane().add(bb,BorderLayout.NORTH);
		f.getContentPane().add(new TreePanel(),BorderLayout.CENTER);
		f.setSize(1000, 1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(200, 300);
		f.setVisible(true);
	}
}


class TreePanel extends JPanel{
	private static int unit = 30, center=0,jump=40;
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		center = (getWidth()-jump)/2;
		g.setColor(Color.green);
		for(int i = 0; i < 15; i++){
			if(i%4 == 0){
				g.setColor(Color.yellow);
			}
			for(int j = -i; j <= i; j++){
				if(i%3 == 0 && (j == -i||j == i)){
					g.setColor(Color.red);
					g.fillRect(center + j*jump/2, jump*i, unit/2, unit);
					g.setColor(Color.green);
				}
				else{
					g.fillRect(center + j*jump/2, jump*i, unit/2, unit);
				}
			}
			g.setColor(Color.green);
		}
		g.setColor(new Color(240,161,168));
		for(int i = 0; i < 5; i++){
			for(int j = -1; j <= 1;j++){
				g.fillRect(center + j*jump/2, jump*(i + 15), unit/2, unit);
			}
		}
	}
}
