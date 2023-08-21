package DataBaseWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String Username;
	String Password;
	
	public boolean TryGetConnection(String username, String password) {
		boolean ret;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/marking_system",
					username,
					password);
			ret = true;
			Username = username;
			Password = password;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			ret = false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	public void DisConnect(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
}
