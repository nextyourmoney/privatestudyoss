package exam07_plsql;

/*
create or replace procedure userss_create 
(
  p_userid in userss.userid%type ,
  p_username in userss.username%type,
  p_userpassword in userss.userpassword%type,
  p_userage in userss.userage%type,
  p_useremail in userss.useremail%type,
  p_rows out pls_integer 
) is 
begin
    insert into userss
    values(p_userid, p_username, p_userpassword, p_userage,  p_useremail);
    p_rows := sql%rowcount;
    commit;
end userss_create;
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import board_Project.common.ConnectionManager;

public class PrecedureCallExample {

	public static void main(String[] args) {
		ConnectionManager.init();
		
		Connection conn =  null;
		
		try {
			conn = ConnectionManager.getConnection2();
			
			String sql = "{call userss_create (?,?,?,?,?,?)}";
			
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, "user2");
			cstmt.setString(2, "사용자2");
			cstmt.setString(3, "12345");
			cstmt.setInt(4, 25);
			cstmt.setString(5, "naver");
			cstmt.registerOutParameter(6, Types.INTEGER);
			
			cstmt.execute();
			
			int rows = cstmt.getInt(6);
			System.out.println("저아된 행수: " + rows);
			
			cstmt.close();
		
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch(Exception e) {}
		}

	}

}
