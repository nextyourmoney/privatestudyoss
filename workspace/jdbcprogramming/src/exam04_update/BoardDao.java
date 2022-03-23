package exam04_update;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.dao.ConnectionManager;
import common.dao.Pager;
import common.dto.Board;

public class BoardDao {
	
	
	
	public Board selectBybno(int bno) {
		ConnectionManager.init();	
		
		Connection conn = null;
		Board board = null;
		
		try {
			
			conn = ConnectionManager.getConnection2();
			
			String sql = "select bno, btitle, bcontent,  bwirter , bdate, bfilename, bfileada from boards where bno = ?";
					
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBfiledate(rs.getBlob("bdate"));
				board.setBfilepaht(rs.getString("bfileada"));
				board.setBfilename(rs.getString("bfilename"));
			}
				
			rs.close();
			pstmt.close();
			
			} catch(ClassNotFoundException e) {
			
		} catch(Exception e) {
			
		} finally{
			try {
				conn.close();
				//System.out.println("연결 끊김");
				} catch(SQLException e) {
			}
		}
		
		return board;
	}
	
	public int update (Board board) {
		int rows = 0;
		ConnectionManager.init();	
		
		Connection conn = null;
		
		
		try {
			conn = ConnectionManager.getConnection2();
			
			//sql 작성
			String sql = "update boards set btitle = ?,  bcontent = ? ";
			sql += (board.getBfilepaht() != null) ? ",bfilename = ?, bfiledata = ? " : " ";
			sql += " where bno = ? ";
					
			//sql 얻
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2,  board.getBcontent());
			
			if(board.getBfilepaht() != null) {
				File file = new File(board.getBfilepaht());
				pstmt.setString(3, file.getName() );
				pstmt.setBlob(4, new FileInputStream(file));
				pstmt.setInt(5,  board.getBno());
			} else {
				pstmt.setInt(3,  board.getBno());
			}
			
			//sql실
			rows = pstmt.executeUpdate();
			pstmt.close();
			
			} catch(Exception e) {
			
		} finally{
			try {
				conn.close();
				System.out.println("연결 끊김");
				} catch(Exception e) {
			}
		}
		
		return rows;
	}

	public List<Board> selectAll(Pager pager) {
		List<Board> list = new ArrayList<>();
		
		Connection conn = null;
				
//		try {
//			conn = ConnectionManager.getConnection2();
//			
//			
//			
//		}
		
		
		
		
		
		return list;
	}

	public int count() {
		int result = 0;
ConnectionManager.init();	
		
		Connection conn = null;
		
		
		try {
			conn = ConnectionManager.getConnection2();
			
			//sql 작성
			String sql = "select count(*) from boards";
					
			//sql 얻
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
			
			
			pstmt.close();
			
			} catch(Exception e) {
			
		} finally{
			try {
				conn.close();
				System.out.println("연결 끊김");
				} catch(Exception e) {
			}
		}
		
		return result;
	}

}
