package exam03_insert;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.dao.ConnectionManager;
import common.dto.Board;

public class SelectExample12 {

	public static void main(String[] args) {
		ConnectionManager.init();
		
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection2();
			
			String sql = "select bno, btitle, bcontent,  bwirter , bdate, bfilename, bfileada from boards where bno = ? ";
					
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfiledate(rs.getBlob("bfileada"));
				board.setBfilename(rs.getString("bfilename"));
				
				System.out.println(board);
				
				if(board.getBfilename() != null) {
				try {
					InputStream is = board.getBfiledate().getBinaryStream();
					OutputStream os = new FileOutputStream("/Users/jbc/Desktop/osstem/temp" + board.getBfilename());
					
					byte[] data = new byte[1000];
					while(true) {
						int num = is.read(data);
						if(num == -1) break;
						os.write(data, 0, num);
					}
					
					os.flush();
					is.close();
					os.close();
					System.out.println("cjaqn vkdlf wjwkd");
					
				} catch(Exception e) {
					e.printStackTrace();
				}
	
			} else{
				System.out.println("cjaqn vkdlf wjwkd");
			}
		}
			
		} catch(ClassNotFoundException e) {
			System.out.print("zcv");
			
		} catch(SQLException e) {
			System.out.print("zcdddv");
			
		} finally{
			try {
				conn.close();
				System.out.println("연결 끊김");
			} catch(SQLException e) {
		}
 
	}
	}

}
