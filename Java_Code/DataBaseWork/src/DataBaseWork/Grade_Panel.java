package DataBaseWork;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Grade_Panel extends JPanel{
	JLabel Grade_Num_Label = new JLabel("年级号");
	JLabel Grade_Head_Label = new JLabel("年级主任");
	JTextField Grade_Num = new JTextField(15);
	JTextField Grade_Head = new JTextField(15);
	JButton Add_Grade = new JButton("添加年级");
	
	public Grade_Panel() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		Add_Grade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		add(Grade_Num_Label);
		add(Grade_Num);
		add(Grade_Head_Label);
		add(Grade_Head);
		add(Add_Grade);
	}
	
}