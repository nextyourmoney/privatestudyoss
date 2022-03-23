package BoardProject_team.src.common;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.*;

public class ConnectionManager {
	public static BasicDataSource basicDataSource;
	
	public static void init() {
		if(basicDataSource==null) {
			basicDataSource=new BasicDataSource();
			basicDataSource.setInitialSize(5);
			basicDataSource.setMaxTotal(10);
			basicDataSource.setMaxIdle(5);
			basicDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
			basicDataSource.setUrl("jdbc:oracle:thin:@kosa1.iptime.org:50118/orcl");
			basicDataSource.setUsername("java");
			basicDataSource.setPassword("kosa12345");
			
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException,SQLException{
	
			
			Connection conn=basicDataSource.getConnection();
			return conn;
		
	}
	public static Connection getConnection2() throws ClassNotFoundException,SQLException{
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50118/orcl","java","kosa12345");
		System.out.println("연결성공");
		return conn;
		
	}
}

