package Course_Project;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChatPanel extends JPanel{
	JTextArea MessageBox = new JTextArea();
	{
		MessageBox.setOpaque(false);
	}
	JTextField InputMessage = new JTextField(30);
	JButton sendButton = new JButton("·¢ËÍÏûÏ¢");
	
	public void addChatMessage(final String msg){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MessageBox.append(msg + "\n");
			}
		});
	}
	public void changeInputAndSendAvailable(){
		InputMessage.setEditable(true);
		sendButton.setEnabled(true);
	}
	
	public ChatPanel(){
		super();
		setLayout(new BorderLayout());
		add(InputMessage, BorderLayout.NORTH);
		add(new JScrollPane(MessageBox),BorderLayout.CENTER);
		add(sendButton, BorderLayout.SOUTH);
		InputMessage.setEditable(false);
		MessageBox.setEditable(false);
		sendButton.setEnabled(false);
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vars.control.sendChatMessage(InputMessage.getText());
				InputMessage.setText("");
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	public void Clear() {
		// TODO Auto-generated method stub
		MessageBox.setText("");
	}
}
