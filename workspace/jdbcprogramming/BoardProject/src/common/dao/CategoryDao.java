package common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionManager;
import common.dto.Board;
import common.paging.Pager;

public class CategoryDao {
	//카테고리 아이디로 카테고리별 리스트 가져오기
	public List<Board> selectByCategory(Pager pager, int categoryid) {
		List<Board> list = new ArrayList<>();
		
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			String sql = new StringBuilder()
					.append("select rnum, bno, bwriter, btitle, bdate ")
					.append("from ( ")
					.append("	select rownum as rnum, bno, bwriter, btitle, bdate ")
					.append("	from ( ")
					.append("		select b.bno, b.bwriter, b.btitle, b.bdate ")
					.append("		from boards b, categories c ")
					.append("		where b.bcategoryid = c.categoryid and b.bcategoryid = ? ")
					.append("		order by b.bno desc ")
					.append("	) ")
					.append("	where rownum <= ? ")
					.append(") ")
					.append("where rnum >= ? ")
					.toString();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryid);
			pstmt.setInt(2, pager.getPageNo()*pager.getRowsPerPage());
			pstmt.setInt(3, (pager.getPageNo()-1)*pager.getRowsPerPage() + 1);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBtitle(rs.getString("btitle"));
				board.setBdate(rs.getDate("bdate"));
				
				list.add(board);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("잘못된 접근 입니다 다시 입력해주세요");
		} finally {
			try { conn.close(); } catch (SQLException e) { }
		}
		return list;
	}
	
	//카테고리별 게시물 개수 가져오기
	public int count(int categoryid) {
		int result = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			String sql = "select count(*) from boards where bcategoryid = ? ";
			
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
	
	//전체 게시물 가져오기
	public List<Board> selectAll(Pager pager) {
		List<Board> list = new ArrayList<>();
		
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			String sql = new StringBuilder()
					.append("select rnum, bno, bwriter, btitle, bdate ")
					.append("from ( ")
					.append("	select rownum as rnum, bno, bwriter, btitle, bdate ")
					.append("	from ( ")
					.append("		select bno, bwriter, btitle, bdate ")
					.append("		from boards")
					.append("		order by bno desc ")
					.append("	) ")
					.append("	where rownum <= ? ")
					.append(") ")
					.append("where rnum >= ? ")
					.toString();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pager.getPageNo()*pager.getRowsPerPage());
			pstmt.setInt(2, (pager.getPageNo()-1)*pager.getRowsPerPage() + 1);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBtitle(rs.getString("btitle"));
				board.setBdate(rs.getDate("bdate"));
				
				list.add(board);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("잘못된 접근 입니다 다시 입력해주세요");
		} finally {
			try { conn.close(); } catch (SQLException e) { }
		}
		return list;
	}
	
	//전체 게시물 개수 가져오기
	public int countAll() {
		int result = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			String sql = "select count(*) from boards";
			
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
