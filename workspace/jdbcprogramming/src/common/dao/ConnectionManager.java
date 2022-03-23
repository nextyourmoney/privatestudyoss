package common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

//변경사항이 발생했을 때 이 클래스만 수정하면 된다.
public class ConnectionManager {
	public static BasicDataSource basicDataSource;
	
	public static void init() {
		if(basicDataSource==null) {
			basicDataSource = new BasicDataSource();
			basicDataSource.setInitialSize(5);
			basicDataSource.setMaxTotal(10);    
			basicDataSource.setMinIdle(5);
			basicDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
			basicDataSource.setUrl("jdbc:oracle:thin:@kosa1.iptime.org:50123/orcl");
			basicDataSource.setUsername("java");
			//basicDataSource.setUsername("hr");
			basicDataSource.setPassword("kosa12345");
		}
	}
	
	//Connectionpool사용 X
	public static synchronized Connection getConnection1() throws ClassNotFoundException, SQLException {  // ConnectionManage객체 생성 없이 getConnection() 호출하려고	
		
		//연결하기
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50123/orcl", "hr", "kosa12345");  //이 부분이 속도가 매우 느림
		return conn;

	}
	
	//Connectionpool사용 o
	public static synchronized Connection getConnection2() throws ClassNotFoundException, SQLException {  // ConnectionManage객체 생성 없이 getConnection() 호출하려고	
		//대여하기
		Connection conn = basicDataSource.getConnection();
		//System.out.println(conn);
		return conn;
		
	}
}
