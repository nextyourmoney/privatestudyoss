package teamBoard_mybatis.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import teamBoard_mybatis.common.ConnectionManager;
import teamBoard_mybatis.common.dto.Board;

public class CategoryDao {
	
	//카테고리별 게시물 개수 가져오기
	public int count(int categoryid) {
		int result = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			String sql = "select count(*) from boards_team where bcategoryid = ? ";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryid);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("잘못된 접근 입니다 다시 입력해주세요");
		} finally {
			try { conn.close(); } catch (SQLException e) { }
		}
		return result;
	}
	
	
	//전체 게시물 개수 가져오기
	public int countAll() {
		int result = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			String sql = "select count(*) from boards_team";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("잘못된 접근 입니다 다시 입력해주세요");
		} finally {
			try { conn.close(); } catch (SQLException e) { }
		}
		return result;
	}
	
}
