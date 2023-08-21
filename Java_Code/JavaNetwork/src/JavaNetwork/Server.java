package JavaNetwork;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Server {
	static JTextField PortTextField;//输入服务使用的端口
	static JButton ConnectButton;//连接按钮
	static JTextArea SentTextField;//要发送的信息
	static JButton SentTo;//“发送至”按钮
	static JComboBox<Socket> Users;//连接的Client们
	static JTextArea TextLog;//收发信息日志
	static JLabel ServerClick;//底部提示，“服务启动，端口为__”
	static JPanel NorthRightPanel;
	static JPanel NorthPanel;
	static JPanel CenterPanel;
	static JPanel SouthPanel;
	static JPanel CenterUpPanel;
	static JPanel CenterMidPanel;
	static JPanel CenterDownPanel;
	static JPanel SentTextPanel;
	static JPanel TextLogPanel;
	static String ServerPort;
	static ArrayList<ServerUsers> ClientList;
	
	//static PrintWriter out;
	static int NowSocket = -1;
	
	
	
	static ServerSocket ss;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Server");
		frame.setSize(800, 1000);
		frame.setLocation(250, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(getNorthPanel(),BorderLayout.NORTH);
		frame.getContentPane().add(getCenterPanel(),BorderLayout.CENTER);
		frame.getContentPane().add(getSouthPanel(),BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	
	public static JTextField getPortTextField() {
		if(PortTextField == null){
			PortTextField = new JTextField();
			PortTextField.setSize(150, 50);
			PortTextField.setHorizontalAlignment(JTextField.LEFT);
		}
		return PortTextField;
	}
	public static JButton getConnectButton() {
		if(ConnectButton == null){
			ConnectButton = new JButton("Start");
			ConnectButton.setSize(150, 50);
			ConnectButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(ss == null){
						CreateNewServerSocket();
					}
					else{
						RemoveServerSocket();
					}
				}

				private void RemoveServerSocket() {
					try {
						getUsers().removeAll();
						ss.close();
						ss = null;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					getSentTo().setEnabled(false);
					ConnectButton.setText("Start");
					ServerClick.setText("服务结束");
					TextLog.append("服务结束\n");
				}

				private void CreateNewServerSocket() {
					int temp = Integer.valueOf(PortTextField.getText());
					if(temp > 1024 && temp <= 65535){
						getSentTo().setEnabled(true);
						try {
							ss = new ServerSocket(temp);
							//final Socket s;
							ConnectButton.setText("Stop");
							ServerClick.setText("服务启动，端口为" + temp);
							TextLog.append("服务启动，端口为" + temp + "\n");
							GetClients();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						
						TextLog.append("端口输入有误，请输入1025~65535之间的端口！\n");
					}
				}
			});
		}
		return ConnectButton;
	}
	
	public static void GetClients(){
		new Thread(){
			public void run(){
				while(ss != null){
					try {
						final Socket s = ss.accept();
						NowSocket++;
						//out=new PrintWriter(s.getOutputStream(),true);
						ServerUsers su = new ServerUsers();
						su.out = new PrintWriter(s.getOutputStream(),true);
						getClientList().add(su);
						GetClients();//递归，卡在Socket，随时准备接收新用户
						Users.addItem(s);
						final int num = Users.getItemCount();
						
						TextLog.append("接收客户端Client" + num + "的请求\n");
						new Thread(){
							public void run(){
								try {
									BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
									while(ss != null){
										String line = in.readLine();
										getTextLog().append("Client" + num + ": " + line + "\n");
									}
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}.start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	public static ArrayList<ServerUsers> getClientList(){
		if(ClientList == null){
			ClientList=new ArrayList<ServerUsers>();
		}
		return ClientList;
	}
	
	public static JTextArea getSentTextField() {
		if(SentTextField == null){
			SentTextField = new JTextArea();
		}
		return SentTextField;
	}
	public static JButton getSentTo() {
		if(SentTo == null){
			SentTo = new JButton("发送至");
			SentTo.setEnabled(false);
			SentTo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(SentTextField.getText().length()!=0){
						String line=SentTextField.getText();
						//output.get(NowSocket).println(line);
						//out.println(line);
						ClientList.get(NowSocket).out.println(line);
						getTextLog().append("[Send Successfully] " + line + "\n");
						getSentTextField().setText("");
					}
				}
			});
		}
		return SentTo;
	}
	public static JComboBox<Socket> getUsers(){
		if(Users == null){
			Users = new JComboBox<Socket>();
			Users.setRenderer(new ComboBoxRenderer());
			Users.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					NowSocket = Users.getSelectedIndex();
					System.out.println(NowSocket);
				}
			});
		}
		return Users;
	}
	public static JTextArea getTextLog() {
		if(TextLog == null){
			TextLog = new JTextArea();
			TextLog.setEditable(false);
		}
		return TextLog;
	}
	public static JLabel getServerClick() {
		if(ServerClick == null){
			ServerClick = new JLabel("服务未启动");
		}
		return ServerClick;
	}
	public static JPanel getNorthRightPanel(){
		if(NorthRightPanel == null){
			NorthRightPanel = new JPanel();
			NorthRightPanel.setLayout(new GridLayout(1, 2));
			NorthRightPanel.add(getPortTextField());
			NorthRightPanel.add(getConnectButton());
		}
		return NorthRightPanel;
	}
	public static JPanel getNorthPanel() {
		if(NorthPanel == null){
			NorthPanel = new JPanel();
			NorthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
			NorthPanel.add(new JLabel("请输入服务端口号:"));
			NorthPanel.add(getNorthRightPanel());
		}
		return NorthPanel;
	}
	public static JPanel getCenterPanel() {
		if(CenterPanel == null){
			CenterPanel = new JPanel();
			CenterPanel.setLayout(new BorderLayout());
			CenterPanel.add(getCenterUpPanel(), BorderLayout.NORTH);
			CenterPanel.add(getCenterMidPanel(), BorderLayout.CENTER);
			CenterPanel.add(getCenterDownPanel(), BorderLayout.SOUTH);
		}
		return CenterPanel;
	}
	public static JPanel getSouthPanel() {
		if(SouthPanel == null){
			SouthPanel = new JPanel();
			SouthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			SouthPanel.add(getServerClick());
		}
		return SouthPanel;
	}
	public static JPanel getCenterUpPanel() {
		if(CenterUpPanel == null){
			CenterUpPanel = new JPanel();
			CenterUpPanel.setBorder(new TitledBorder(new EtchedBorder(), "需要发送的内容"));
			CenterUpPanel.add(getSentTextPanel());
		}
		return CenterUpPanel;
	}
	public static JPanel getCenterMidPanel() {
		if(CenterMidPanel == null){
			CenterMidPanel = new JPanel();
			CenterMidPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			CenterMidPanel.add(getSentTo());
			CenterMidPanel.add(getUsers());
		}
		return CenterMidPanel;
	}
	public static JPanel getCenterDownPanel() {
		if(CenterDownPanel == null){
			CenterDownPanel = new JPanel();
			CenterDownPanel.setBorder(new TitledBorder(new EtchedBorder(), "日志"));
			CenterDownPanel.add(getTextLogPanel());
		}
		return CenterDownPanel;
	}
	public static JPanel getSentTextPanel() {
		if(SentTextPanel == null){
			SentTextPanel = new JPanel();
			SentTextPanel.setPreferredSize(new Dimension(760, 330));
			SentTextPanel.setLayout(new GridLayout(1, 1));
			SentTextPanel.add(getSentTextField());
		}
		return SentTextPanel;
	}

	public static JPanel getTextLogPanel() {
		if(TextLogPanel == null){
			TextLogPanel = new JPanel();
			TextLogPanel.setPreferredSize(new Dimension(760, 440));
			TextLogPanel.setLayout(new GridLayout(1, 1));
			TextLogPanel.add(getTextLog());
		}
		return TextLogPanel;
	}
}
