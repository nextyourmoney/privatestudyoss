package teamBoard_mybatis.common.Service;

import java.sql.Connection;
import java.sql.Date;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBoards {
	
	
	public void insert() {
		Connection conn = null;
		
		try {
			//연결하기
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50123/orcl", "java", "kosa12345");
			
						
			//실행해야할 SQL 작성
			String sql = "insert into boards_team(bno, btitle, bcontent,bwriter,bdate,bfilename,bfiledata,bcategoryid) values(?,?,?,?,sysdate,?,?,?)";
			
			//SQL을 실행할 PreparedStatment 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			for(int i=15001; i<=16000; i++) {
				//데이터 세팅
				
				
				pstmt.setInt(1, i);
				pstmt.setString(2, "title" + i);
				pstmt.setString(3, "content" + i );
				pstmt.setString(4, "BoardUser" + i );
				pstmt.setString(5, null);
				pstmt.setString(6, null);
				pstmt.setInt(7, 3);  ///카테고리 1로설정해놨어요
				
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
