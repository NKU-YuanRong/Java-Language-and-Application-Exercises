package DataBaseWork;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.prism.Image;

public class MainPanel extends JPanel{
	int sx,sy;
	JLabel Title = new JLabel("线上阅卷管理系统");
	ImageIcon SQLIcon = new ImageIcon(new ImageIcon("MySqlJpg.png").getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_DEFAULT));
	JLabel SQLLabel = new JLabel(SQLIcon);
	JLabel UserLabel = new JLabel("用户名： ");
	JLabel PasswordLabel = new JLabel(" 密码：");
	JTextField UserName = new JTextField();
	JTextField Password = new JTextField();
	JButton GetIntoSystem = new JButton("登录系统");
	JLabel Maker = new JLabel(" 制作者：NKU_y_Database大作业 ");
	//JLabel Maker = new JLabel(" 制作者：NKU_y");

	JLabel FailPrompt = new JLabel("");
	
	public MainPanel() {
		// TODO Auto-generated constructor stub
		Title.setFont(new Font("黑体", Font.BOLD, 30));
		
		SetLay();
		
		AddListener();
		
		UserName.setText("root");
		Password.setText("12345678");
		
		add(Title);
		add(SQLLabel);
		add(UserLabel);
		add(UserName);
		add(PasswordLabel);
		add(Password);
		add(GetIntoSystem);
		add(Maker);
		add(FailPrompt);
	}

	private void AddListener() {
		GetIntoSystem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String username = UserName.getText();
				String password = Password.getText();
				if(Vars.connector.TryGetConnection(username, password)) {
					//System.out.println('a');
					Vars.sysframe.BeginOperating();
				}
				else{
					FailPrompt.setForeground(Color.red);
					FailPrompt.setText("登陆失败！");
					repaint();
				}
			}
		});
	}

	private void SetLay() {
		// TODO Auto-generated method stub
		
		GridBagLayout gridBagLay = new GridBagLayout();
		setLayout(gridBagLay);
		GridBagConstraints gridBagCon = new GridBagConstraints();
		gridBagCon.fill = GridBagConstraints.BOTH;
		
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 0;
		gridBagCon.gridwidth = 6;
		gridBagCon.gridheight = 2;
		gridBagLay.setConstraints(Title, gridBagCon);
		
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 2;
		gridBagCon.gridwidth = 2;
		gridBagCon.gridheight = 3;
		gridBagLay.setConstraints(SQLLabel, gridBagCon);

		gridBagCon.gridx = 2;
		gridBagCon.gridy = 2;
		gridBagCon.gridwidth = 1;
		gridBagCon.gridheight = 1;
		gridBagLay.setConstraints(UserLabel, gridBagCon);
		
		gridBagCon.gridx = 3;
		gridBagCon.gridy = 2;
		gridBagCon.gridwidth = 4;
		gridBagCon.gridheight = 1;
		gridBagLay.setConstraints(UserName, gridBagCon);
		
		gridBagCon.gridx = 2;
		gridBagCon.gridy = 3;
		gridBagCon.gridwidth = 1;
		gridBagCon.gridheight = 1;
		gridBagLay.setConstraints(PasswordLabel, gridBagCon);
		
		gridBagCon.gridx = 3;
		gridBagCon.gridy = 3;
		gridBagCon.gridwidth = 4;
		gridBagCon.gridheight = 1;
		gridBagLay.setConstraints(Password, gridBagCon);
		
		gridBagCon.gridx = 2;
		gridBagCon.gridy = 4;
		gridBagCon.gridwidth = 4;
		gridBagCon.gridheight = 1;
		gridBagLay.setConstraints(GetIntoSystem, gridBagCon);
		
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 5;
		gridBagCon.gridwidth = 4;
		gridBagCon.gridheight = 1;
		gridBagLay.setConstraints(Maker, gridBagCon);
		
		gridBagCon.gridx = 4;
		gridBagCon.gridy = 5;
		gridBagCon.gridwidth = 2;
		gridBagCon.gridheight = 1;
		gridBagLay.setConstraints(FailPrompt, gridBagCon);
	}
}