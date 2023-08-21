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
	JLabel Title = new JLabel("����������");
	JLabel Maker = new JLabel(" ��Ϸ�����ߣ�NKU_yy_Java����ҵ ");
	JButton NetMode = new JButton("��ʼ��Ϸ");
//	JButton LocalMode = new JButton("����ģʽ");
//	JButton AudienceMode = new JButton("��սģʽ");
	JButton ExitButton = new JButton("�˳���Ϸ");
	JButton History = new JButton("��ʷ��¼");
	
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
		Title.setFont(new Font("����", Font.BOLD, 80));
		NetMode.setFont(new Font("����", Font.BOLD, 30));
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

