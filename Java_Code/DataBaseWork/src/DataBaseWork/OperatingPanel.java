package DataBaseWork;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.layout.Border;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OperatingPanel extends JPanel{
	OperateList operatelist = new OperateList();
	UserPanel userpanel = new UserPanel();
	
	public OperatingPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		add(operatelist, BorderLayout.WEST);
		add(userpanel, BorderLayout.CENTER);
	}

}

class OperateList extends JPanel{
	JButton TeacherManage = new JButton("教师管理");
	JButton StudentManage = new JButton("学生管理");
	JButton ExamManage = new JButton("考试管理");
	JButton GradeManage = new JButton("年级管理");
	JButton ClassManage = new JButton("班级管理");
	
	public OperateList() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(5,1));
		AddListener();
		add(TeacherManage);
		add(StudentManage);
		add(ExamManage);
		add(GradeManage);
		add(ClassManage);
	}

	private void AddListener() {
		// TODO Auto-generated method stub
		TeacherManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Vars.operatingpanel.userpanel.GetIntoTeacher();
			}
		});
		
		StudentManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ExamManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		GradeManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Vars.operatingpanel.userpanel.GetIntoGrade();
			}
		});
		
		ClassManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}

class UserPanel extends JPanel{
	Teacher_Panel teacherpanel = new Teacher_Panel();
	Grade_Panel gradepanel = new Grade_Panel();
	CardLayout card = new CardLayout();
	
	public UserPanel() {
		// TODO Auto-generated constructor stub
		setLayout(card);
		
		add(teacherpanel);
		add(gradepanel);
	}
	void GetIntoTeacher(){
		card.first(this);
	}
	void GetIntoGrade(){
		card.first(this);
		card.next(this);
	}
}
