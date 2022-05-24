package exam06_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.dao.ConnectionManager;

public class TransactionExample01 {

	public static void main(String[] args) {
		ConnectionManager.init();
		
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection2();
			
			conn.setAutoCommit(false); //autocommmit 실행 방지
			
			//작업1 -출금
			String sql = "update acounts set balance = balance - 10000 where ano = '111-111-1111'";
			PreparedStatement pstmt1 = conn.prepareStatement(sql); //autocommit이 자동적으로 실행된다. 
			pstmt1.executeUpdate(); 
			pstmt1.close();
			
			
			//작업ㅈ --입
			String sql2 = "update acounts set balance = balance + 10000 where ano = '222-222-2222'";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.executeUpdate();
			pstmt1.close();
			
			conn.commit(); //autocommit을 막아두었기에 commit명령어를 실행해야 한다.
					
		} catch(Exception e) { 
			try{
				conn.rollback();  //commit의 실패시의 예외 처리 
				} catch(Exception e2) {
					
				}
			e.printStackTrace();
		} finally {
			try { 
				conn.setAutoCommit(true); //필수적으로 해두어야하며 코드를 원래대로 되돌리는 필요가 있다.
				conn.close(); 
				} catch (Exception e){
					
				}
		}

	}

}
