package DataBaseWork;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Teacher_Panel extends JPanel{
	SelectTeacherPanel selectpanel = new SelectTeacherPanel();
	AddTeacherPanel addpanel = new AddTeacherPanel();
	DeleteTeacherPanel deletepanel = new DeleteTeacherPanel();
	
	public Teacher_Panel() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(3,1));
		add(addpanel);
		add(selectpanel);
		add(deletepanel);
	}
}

class SelectTeacherPanel extends JPanel{
	JLabel IDLabel = new JLabel("ID:");
	JLabel NewIDLabel = new JLabel("新ID");
	JLabel Search_Result = new JLabel("");
	JTextField IDField = new JTextField(15);
	JTextField NewIDField = new JTextField(15);
	JButton SearchTeacher = new JButton("搜索该教师");
	JButton UpdateTeacherID = new JButton("更新该教师ID");
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public SelectTeacherPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		SearchTeacher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				selectTeache();
			}

		});
		
		UpdateTeacherID.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UpdateTeacheID();
			}
		});
		add(IDLabel);
		add(IDField);
		add(SearchTeacher);
		add(NewIDLabel);
		add(NewIDField);
		add(UpdateTeacherID);
		add(Search_Result);
	}
	
	public void UpdateTeacheID(){
		
		Search_Result.setText("");
		repaint();
		String tid = IDField.getText();
		String newtid = NewIDField.getText();
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/marking_system",
					Vars.connector.getUsername(),
					Vars.connector.getPassword());
			stmt = conn.createStatement();
			
			String sql = "call UpdateTeacheID2(" + tid + "," + newtid + ")";
			rs = stmt.executeQuery(sql);
			
			JOptionPane.showMessageDialog(null, "更新成功");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "更新失败！请检查输入");
		}  finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void selectTeache() {
		
		String tid = IDField.getText();
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/marking_system",
					Vars.connector.getUsername(),
					Vars.connector.getPassword());
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			//String sql = "select * from teacher where Mem_ID = " + tid;
			//String sql = "DROP VIEW v_teacher_info";
			
			String sql = "DROP VIEW IF EXISTS v_teacher_info";
			stmt.executeUpdate(sql);
			
			sql =
					"CREATE VIEW v_teacher_info AS "
					+ "SELECT s.Mem_ID, s.Mem_Name, s.Mem_Age, s.Mem_Sex, t.Project "
					+ "FROM Teacher t, School_Member s "
					+ "WHERE t.Mem_ID = s.Mem_ID AND t.Mem_ID = " + tid;
			stmt.executeUpdate(sql);
			
			sql = "select * from v_teacher_info";
			rs = stmt.executeQuery(sql);
			
			boolean not_searched = true;
			while(rs.next()){
				not_searched = false;
				String m_id = rs.getString("Mem_ID");
				String m_pro = rs.getString("Project");
				String m_name = rs.getString("Mem_Name");
				String m_age = rs.getString("Mem_Age");
				String m_sex = rs.getString("Mem_Sex");
				String Teacher_Message = "ID: " + m_id + ", Name: " + m_name + ", Age: "
						+ m_age + ", Sex: " + m_sex + ", Project: " + m_pro;
				Search_Result.setText(Teacher_Message);
				repaint();
				//System.out.println("ID: " + m_id + ", Project: " + m_pro + ", Name: " + m_name);
			}
			rs.close();
			
			if(not_searched){
				Search_Result.setText("查找失败！请检查输入信息");
				repaint();
			}
			
			sql = "DROP VIEW v_teacher_info";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class AddTeacherPanel extends JPanel{
	JLabel NameLabel = new JLabel("Name:");
	JLabel AgeLabel = new JLabel("Age:");
	JLabel SexLabel = new JLabel("Sex(Male/Female):");
	JLabel IDLabel = new JLabel("ID:");
	JLabel ProjectLabel = new JLabel("Project:");
	
	JTextField NameField = new JTextField(10);
	JTextField AgeField = new JTextField(8);
	JTextField SexField = new JTextField(8);
	JTextField IDField = new JTextField(15);
	JTextField ProjectField = new JTextField(10);
	
	JButton AddTeacher = new JButton("添加教师");
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public AddTeacherPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		
		AddTeacher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//添加老师
				addTeache();
			}
		});
		add(NameLabel);
		add(NameField);
		add(AgeLabel);
		add(AgeField);
		add(SexLabel);
		add(SexField);
		add(IDLabel);
		add(IDField);
		add(ProjectLabel);
		add(ProjectField);
		add(AddTeacher);
	}
	
	void addTeache(){
		String tname = NameField.getText();
		String tage = AgeField.getText();
		String tsex = SexField.getText();
		String tid = IDField.getText();
		String tproject = ProjectField.getText();
		
		NameField.setText("");
		AgeField.setText("");
		SexField.setText("");
		IDField.setText("");
		ProjectField.setText("");
		
		String school_mem_value = '(' + tid + ",'" + tname + "'," + tage + ",'" + tsex + "')";
		String teacher_value = '(' + tid + ",'" + tproject + "')";
		
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/marking_system",
					Vars.connector.getUsername(),
					Vars.connector.getPassword());
			
			stmt = conn.createStatement();
			
			String sql = "insert into school_member values" + school_mem_value;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			
			sql = "insert into teacher values" + teacher_value;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null, "插入成功");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "插入失败，请检查输入合法性");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class DeleteTeacherPanel extends JPanel{
	JLabel IDLabel = new JLabel("ID:");
	JTextField IDField = new JTextField(15);
	JButton DeleteTeacher = new JButton("删除教师");
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public DeleteTeacherPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		DeleteTeacher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//删除教师
				deleteTeache();
			}
		});
		add(IDLabel);
		add(IDField);
		add(DeleteTeacher);
		
	}
	
	public void deleteTeache() {
		String tid = IDField.getText();
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/marking_system",
					Vars.connector.getUsername(),
					Vars.connector.getPassword());
			//关闭自动提交，待事务整个完成后再提交
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			String sql = "delete from teacher where Mem_ID = " + tid;
			stmt.executeUpdate(sql);
			
			sql = "delete from school_member where Mem_ID = " + tid;
			stmt.executeUpdate(sql);
			
			//事务完成，手动提交
			conn.commit();
			JOptionPane.showMessageDialog(null, "删除成功");
			//stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "删除失败，请检查输入是否合法");
			try {
				if(conn != null){
					//事务出现异常，不提交并回滚
					conn.rollback();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			e.printStackTrace();
		}finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				if(stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		
	}
}