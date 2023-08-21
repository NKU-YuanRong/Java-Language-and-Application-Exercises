package DataBaseWork;

import java.sql.*;

public class Test01 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//注册驱动
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marking_system", "root", "12345678");
			
			//获取操作对象
			stmt = conn.createStatement();
			
			
			//执行SQL语句（处理查询结果集）
			String sql = "delete from school_member where Mem_ID = 2012516";
			stmt.executeUpdate(sql);
			
			sql = "insert into school_member values (2012516, 'LYH', 20, 'Male')";
			stmt.executeUpdate(sql);
			
			sql = "select * from school_member";
			rs = stmt.executeQuery(sql);
			System.out.println("First: ");
			while(rs.next()){
				String m_id = rs.getString("Mem_ID");
				String m_name = rs.getString("Mem_Name");
				System.out.println("ID: " + m_id + ", NAME: " + m_name);
			}
			rs.close();
			
			
			/*
			sql = "delete from school_member where Mem_ID = 2012516";
			stmt.executeUpdate(sql);
			
			sql = "select * from school_member";
			rs = stmt.executeQuery(sql);
			System.out.println("Second: ");
			while(rs.next()){
				String m_id = rs.getString("Mem_ID");
				String m_name = rs.getString("Mem_Name");
				System.out.println("ID: " + m_id + ", NAME: " + m_name);
			}
			*/
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//释放资源
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