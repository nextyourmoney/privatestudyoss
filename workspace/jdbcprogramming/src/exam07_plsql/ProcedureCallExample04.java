package exam07_plsql;

/*
 create or replace procedure get_board(
    p_bno in boards.bno%type,
    p_board out sys_refcursor
) as 
begin
    open p_board for 
    select bno, btitle, bconten, bwriter, bdate, bfilename, bfiledata
    from boards
    order by bno;
end get_board;
 */

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

import board_Project.common.ConnectionManager;
import board_Project.common.dto.Board;

public class ProcedureCallExample04 {

	public static void main(String[] args) {
		
			ConnectionManager.init();
			
			Connection conn =  null;
			
			try {
				conn = ConnectionManager.getConnection2();
				
				String sql = "{call get_board (?,?)}";
				
				CallableStatement cstmt = conn.prepareCall(sql);
				
				cstmt.setInt(1, 23);
				cstmt.registerOutParameter(2, Types.REF_CURSOR);
				
				//프로시저 실행
				cstmt.execute();
				
				
				//out 파라미터 값 얻기
				ResultSet rs = (ResultSet) cstmt.getObject(2);
				if(rs.next()) {
					Board board = new Board();
					board.setBno(rs.getInt("bno"));
					board.setBtitle(rs.getString("btitle"));
					board.setBcontent(rs.getString("bcontent"));
					board.setBwriter(rs.getString("bwriter"));
					board.setBdate(rs.getDate("bdate"));
					board.setBfilename(rs.getString("bfilename"));
					board.setBfiledata(rs.getBlob("bfiledata"));
					System.out.println(board);
				}
				
				rs.close();
				
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


