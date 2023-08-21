package Course_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NetConnectionPanel extends JPanel{
	
	JTextField LocalPort = new JTextField(8);
	JTextField NetPort = new JTextField(8);
	JTextField NetLocation = new JTextField(15);
	
	JPanel UpPanel = new JPanel();
	JPanel HostPanel = new JPanel();
	JPanel DownPanel = new JPanel();
	JPanel PlayerPanel = new JPanel();
	JPanel UpAndDownPanel = new JPanel();
	JPanel BackPanel = new JPanel();
	JButton ListenButton = new JButton("开启房间");
	JButton ConnectButton = new JButton("进入房间");
	JButton BackToMain = new JButton("返回主界面");
	JLabel ImHost = new JLabel("我是房主");
	JLabel ImPlayer = new JLabel("我是房客");
	
	public NetConnectionPanel() {
		LocalPort.setText("8088");
		NetPort.setText("8088");
		NetLocation.setText("localhost");
		
		SetLay();
		AddListener();
		SetEditable();
	}
	
	
	
	private void AddListener() {
		ListenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(LocalPort.getText().length()!=0){
					int i = Integer.valueOf(LocalPort.getText()).intValue();
					Vars.control.BeginListen(i);
					SetUneditable();
				}
			}
			
		});
		ConnectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(NetPort.getText().length()!=0 && NetLocation.getText().length()!=0){
					int p = Integer.valueOf(NetPort.getText()).intValue();
					Vars.control.BeginConnect(NetLocation.getText(), p);
					SetUneditable();
				}
			}
		});
//		WatcherButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(NetPortToWatcher.getText().length()!=0 && NetLocationToWatcher.getText().length()!=0){
//					int p = Integer.valueOf(NetPortToWatcher.getText()).intValue();
//					//Vars.control.BeginWatching(NetLocationToWatcher.getText(), p);
//					SetUneditable();
//				}
//			}
//		});
		BackToMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vars.switcher.BackToMain();
			}
		});
	}
	
	public void SetEditable(){
		ListenButton.setEnabled(true);
		ConnectButton.setEnabled(true);
		BackToMain.setEnabled(true);
		LocalPort.setEditable(true);
		NetPort.setEditable(true);
		NetLocation.setEditable(true);
//		NetPortToWatcher.setEditable(true);
//		NetLocationToWatcher.setEditable(true);
//		WatcherButton.setEnabled(true);
	}
	
	public void SetUneditable() {
				// TODO Auto-generated method stub
				ListenButton.setEnabled(false);
				ConnectButton.setEnabled(false);
				BackToMain.setEnabled(false);
				LocalPort.setEditable(false);
				NetPort.setEditable(false);
				NetLocation.setEditable(false);
//				NetPortToWatcher.setEditable(false);
//				NetLocationToWatcher.setEditable(false);
//				WatcherButton.setEnabled(false);
	}
	
	private void SetLay() {
		HostPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		HostPanel.add(new JLabel("请输入服务端口号："));
		HostPanel.add(LocalPort);
		HostPanel.add(ListenButton);
		
		UpPanel.setLayout(new GridLayout(2, 1));
		ImHost.setFont(new Font("隶书", Font.BOLD, 50));
		UpPanel.add(ImHost);
		UpPanel.add(HostPanel);
		//UpPanel.add(ListenButton);
		
		PlayerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		PlayerPanel.add(new JLabel("请输入服务器地址："));
		PlayerPanel.add(NetLocation);
		PlayerPanel.add(new JLabel("请输入服务器端口号："));
		PlayerPanel.add(NetPort);
		PlayerPanel.add(ConnectButton);
		
		DownPanel.setLayout(new GridLayout(2, 1));
		ImPlayer.setFont(new Font("隶书", Font.BOLD, 50));
		DownPanel.add(ImPlayer);
		DownPanel.add(PlayerPanel);
		
//		WatcherPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		WatcherPanel.add(new JLabel("请输入服务器地址："));
//		WatcherPanel.add(NetLocationToWatcher);
//		WatcherPanel.add(new JLabel("请输入服务器端口号："));
//		WatcherPanel.add(NetPortToWatcher);
//		WatcherPanel.add(WatcherButton);
//		
//		DownDownPanel.setLayout(new GridLayout(2, 1));
//		ImWatcher.setFont(new Font("隶书", Font.BOLD, 50));
//		DownDownPanel.add(ImWatcher);
//		DownDownPanel.add(WatcherPanel);
		
		UpAndDownPanel.setLayout(new GridLayout(2, 1));
		UpAndDownPanel.add(UpPanel);
		UpAndDownPanel.add(DownPanel);
//		UpAndDownPanel.add(DownDownPanel);
		
		BackPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		BackPanel.add(BackToMain);
		
		setLayout(new BorderLayout());
		add(UpAndDownPanel,BorderLayout.CENTER);
		add(BackPanel,BorderLayout.SOUTH);
	}



	public void Clear() {
		LocalPort.setText("8088");
		NetPort.setText("8088");
		NetLocation.setText("localhost");
	}
	
}
