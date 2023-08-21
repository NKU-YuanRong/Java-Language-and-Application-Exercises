package Course_Project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	int sx,sy;
	JLabel Title = new JLabel("网络五子棋");
	JLabel Maker = new JLabel(" 游戏制作者：NKU_yy_Java大作业 ");
	JButton NetMode = new JButton("开始游戏");
//	JButton LocalMode = new JButton("单机模式");
//	JButton AudienceMode = new JButton("观战模式");
	JButton ExitButton = new JButton("退出游戏");
	JButton History = new JButton("历史记录");
	
	public MainPanel() {
		SetLay();
		AddListener();
		add(Title);
		add(NetMode);
//		add(LocalMode);
//		add(AudienceMode);
		add(History);
		add(Maker);
		add(ExitButton);
	}
	private void AddListener() {
		Title.setFont(new Font("隶书", Font.BOLD, 80));
		NetMode.setFont(new Font("隶书", Font.BOLD, 30));
		NetMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vars.switcher.EnterNetMode();
			}
		});
//		LocalMode.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		AudienceMode.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
		ExitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		History.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(Vars.historypanel.lal.size());
//				System.out.println(Vars.historypanel.lal.get(1).get(0).row);
				Vars.switcher.ToHistoryWindow();
			}
		});
	}
	private void SetLay() {
		
		GridBagLayout gridBagLay = new GridBagLayout();
		setLayout(gridBagLay);
		GridBagConstraints gridBagCon = new GridBagConstraints();
		gridBagCon.fill = GridBagConstraints.BOTH;
		
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 0;
		gridBagCon.gridwidth = 8;
		gridBagCon.gridheight = 3;
		gridBagLay.setConstraints(Title, gridBagCon);
	
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 3;
		gridBagCon.gridwidth = 8;
		gridBagCon.gridheight = 4;
		gridBagLay.setConstraints(NetMode, gridBagCon);
		
//		gridBagCon.gridx = 0;
//		gridBagCon.gridy = 5;
//		gridBagCon.gridwidth = 8;
//		gridBagCon.gridheight = 2;
//		gridBagLay.setConstraints(LocalMode, gridBagCon);
		
//		gridBagCon.gridx = 0;
//		gridBagCon.gridy = 7;
//		gridBagCon.gridwidth = 8;
//		gridBagCon.gridheight = 2;
//		gridBagLay.setConstraints(AudienceMode, gridBagCon);
		
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 11;
		gridBagCon.gridwidth = 3;
		gridBagCon.gridheight = 2;
		gridBagLay.setConstraints(History, gridBagCon);
		
		gridBagCon.gridx = 3;
		gridBagCon.gridy = 11;
		gridBagCon.gridwidth = 4;
		gridBagCon.gridheight = 2;
		gridBagLay.setConstraints(Maker, gridBagCon);
		
		gridBagCon.gridx = 7;
		gridBagCon.gridy = 11;
		gridBagCon.gridwidth = 1;
		gridBagCon.gridheight = 2;
		gridBagLay.setConstraints(ExitButton, gridBagCon);
	}
}

