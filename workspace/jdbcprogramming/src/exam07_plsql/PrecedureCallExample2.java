package exam07_plsql;

import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import board_Project.common.ConnectionManager;

public class PrecedureCallExample2 {

	public static void main(String[] args) {
		ConnectionManager.init();
		
		Connection conn =  null;
		
		try {
			conn = ConnectionManager.getConnection2();
			
			String sql = "{call board_create (?,?,?,?,?,?,?)}";
			
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, "user2");
			cstmt.setString(2, "사용자2");
			cstmt.setString(3, "12345");
			
			File file = new File("/Users/jbc/Documents/스크린샷 2022-03-22 오후 2.36.00.png");
			cstmt.setString(4, file.getName());
			cstmt.setBlob(5, new FileInputStream(file));
			cstmt.registerOutParameter(6, Types.INTEGER);
			
			cstmt.execute();
			
			int rows = cstmt.getInt(6);
			System.out.println("저아된 행수: " + rows);
			
			cstmt.close();
		
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {}
			}
			try {conn.close();} catch(Exception e) {}
		}

	}

}
