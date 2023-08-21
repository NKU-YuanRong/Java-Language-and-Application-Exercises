package JavaNetwork;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client {
	static JPanel NorthPanel;
	static JPanel SouthPanel;
	static ClientCenterPanel CenterPanel;
	
	static JButton ConnectButten;
	
	static JTextField ServerLocation;
	
	static JLabel ClientClick;
	static JTextField ServerPort;
	static JPanel ServerPortPanel;
	
	static Socket s;
	static BufferedReader in;
	static PrintWriter out;
	
	static boolean connected = false;
	
	public static String ServerAddress;
	public static int Port;
	
	public static JButton getConnectButten() {
		if(ConnectButten == null){
			ConnectButten = new JButton();
			ConnectButten.setText("启动连接");
			ConnectButten.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(!connected){
						try {
							ConnectServer();
							ConnectButten.setText("断开连接");
							CenterPanel.getSendButton().setEnabled(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						try {
							BreakConnect();
							ConnectButten.setText("启动连接");
							CenterPanel.getSendButton().setEnabled(false);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

				private void BreakConnect() throws IOException {
					// TODO Auto-generated method stub
					in.close();
					out.close();
					s.close();
					connected = false;
				}

				private void ConnectServer() throws IOException {
					// TODO Auto-generated method stub
					if(ServerLocation.getText().length()==0 || ServerPort.getText().length()==0){
						CenterPanel.getConnectLog().append("请输入正确的地址和端口号！\n");
						return;
					}
					connected = true;
					String Loc=ServerLocation.getText();
					int Por=Integer.valueOf(ServerPort.getText()).intValue();
					s=new Socket(Loc, Por);
					in=new BufferedReader(new InputStreamReader(s.getInputStream()));
					out=new PrintWriter(s.getOutputStream(),true);
					
					CenterPanel.getConnectLog().append("连接成功！ 服务器地址:" + Loc + ", 端口:" + Por + "\n");
					ReceiveMessage();
				}

				private void ReceiveMessage() {
					// TODO Auto-generated method stub
					new Thread(){
						public void run(){
							while(s != null){
								try {
									String line = in.readLine();
									CenterPanel.getConnectLog().append("Server: " + line + "\n");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}.start();
				}

				
			});
		}
		return ConnectButten;
	}
	public static JTextField getServerLocation() {
		if(ServerLocation == null){
			ServerLocation = new JTextField(10);
		}
		return ServerLocation;
	}
	public static JTextField getServerPort() {
		if(ServerPort == null){
			ServerPort=new JTextField(5);
		}
		return ServerPort;
	}
	public static JPanel getServerPortPanel() {
		return ServerPortPanel;
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Client");
		frame.setSize(800, 1000);
		frame.setLocation(1200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(getNorthPanel(),BorderLayout.NORTH);
		frame.getContentPane().add(getSouthPanel(),BorderLayout.SOUTH);
		frame.getContentPane().add(getCenterPanel(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
	public static JPanel getNorthPanel() {
		if(NorthPanel == null){
			NorthPanel = new JPanel();
			NorthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
			NorthPanel.add(new JLabel("请输入服务器地址:"));
			NorthPanel.add(getServerLocation());
			NorthPanel.add(new JLabel("端口号:"));
			NorthPanel.add(getServerPort());
			NorthPanel.add(getConnectButten());
		}
		return NorthPanel;
	}
	public static JPanel getSouthPanel() {
		if(SouthPanel == null){
			SouthPanel = new JPanel();
			SouthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			SouthPanel.add(getClientClick());
		}
		return SouthPanel;
	}
	public static JLabel getClientClick(){
		if(ClientClick==null){
			ClientClick=new JLabel("未连接服务器");
		}
		return ClientClick;
	}
	public static JPanel getCenterPanel() {
		if(CenterPanel==null){
			CenterPanel=new ClientCenterPanel();
		}
		return CenterPanel;
	}
	
	
}
