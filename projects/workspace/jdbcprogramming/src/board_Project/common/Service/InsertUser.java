package board_Project.common.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUser {
	
	
	public void insert() {
		Connection conn = null;
		
		try {
			//연결하기
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50118/orcl", "java", "kosa12345");
			System.out.println("연결 성공");
			
			//실행해야할 SQL 작성
			String sql = "insert into users(userid,userpassword,usernickname,username,userage,userphonenumber,useremail) ";
					sql+= "values(?,?,?,?,?,?,?)";
			
			//SQL을 실행할 PreparedStatment 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			for(int i=301; i<=10000; i++) {
				//데이터 세팅

				pstmt.setString(1, "User" + i);
				pstmt.setString(2, "password" + i);
				pstmt.setString(3, "BoardUser" + i );
				pstmt.setString(4, "Korean" + i );
				pstmt.setInt(5, i);
				pstmt.setString(6, "010-"+i);
				pstmt.setString(7, "java@java"+i);
				
				//SQL을 실행
				pstmt.executeUpdate();
			}
			
			//PreparedStatement가 사용한 메모리를 해제
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//연결끊기
				conn.close();
				System.out.println("연결 끊김");
			} catch (SQLException e) {
			}
		}
		
	}
}
