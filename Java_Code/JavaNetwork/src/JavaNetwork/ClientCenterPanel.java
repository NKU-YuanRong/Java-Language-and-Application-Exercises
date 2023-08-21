package JavaNetwork;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ClientCenterPanel extends JPanel{
	JPanel NorthPanel;
	JPanel CenterPanel;
	JPanel SouthPanel;
	
	JTextArea SendMessage;
	JTextArea ConnectLog;
	
	JButton SendButton;
	
	ClientCenterPanel(){
		setLayout(new BorderLayout());
		add(getNorthPanel(),BorderLayout.NORTH);
		add(getCenterPanel(),BorderLayout.CENTER);
		add(getSouthPanel(),BorderLayout.SOUTH);
	}

	public JPanel getNorthPanel() {
		if(NorthPanel==null){
			NorthPanel=new JPanel();
			//NorthPanel.setSize(new Dimension(760, 330));
			NorthPanel.setPreferredSize(new Dimension(760, 350));
			NorthPanel.setLayout(new GridLayout(1, 1));
			NorthPanel.setBorder(new TitledBorder(new EtchedBorder(), "需要发送的信息"));
			NorthPanel.add(getSendMessage());
		}
		return NorthPanel;
	}

	public JPanel getCenterPanel() {
		if(CenterPanel==null){
			CenterPanel=new JPanel();
			CenterPanel.add(getSendButton());
		}
		return CenterPanel;
	}

	public JPanel getSouthPanel() {
		if(SouthPanel==null){
			SouthPanel=new JPanel();
			SouthPanel.setPreferredSize(new Dimension(760, 480));
			SouthPanel.setLayout(new GridLayout(1, 1));
			SouthPanel.setBorder(new TitledBorder(new EtchedBorder(), "日志"));
			SouthPanel.add(getConnectLog());
		}
		return SouthPanel;
	}

	public JTextArea getSendMessage() {
		if(SendMessage==null){
			SendMessage=new JTextArea();
		}
		return SendMessage;
	}

	public JTextArea getConnectLog() {
		if(ConnectLog==null){
			ConnectLog=new JTextArea();
			ConnectLog.setEditable(false);
		}
		return ConnectLog;
	}

	public JButton getSendButton() {
		if(SendButton==null){
			SendButton=new JButton("发送");
			SendButton.setEnabled(false);
			SendButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(getSendMessage().getText().length()==0){
						return;
					}
					SendMessage();
					//getSendMessage().removeAll();
					getSendMessage().setText("");
				}

				private void SendMessage() {
					// TODO Auto-generated method stub
					String line = getSendMessage().getText();
					Client.out.println(line);
					getConnectLog().append("Me: " + line + "\n");
				}
			});
		}
		return SendButton;
	}
	
	
}
