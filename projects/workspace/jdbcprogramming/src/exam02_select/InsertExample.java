package exam02_select;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			//연결하기
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50123/orcl", "hr", "kosa12345");
			System.out.println("연결 성공");
			
			//실행해야할 SQL 작성
			String sql = "INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) ";
			sql += "VALUES(?,?,?,?,?,sysdate,?,?,?,100,30)";
			
			//SQL을 실행할 PreparedStatment 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			for(int i=301; i<=10000; i++) {
				//데이터 세팅
				pstmt.setInt(1, i);
				pstmt.setString(2, "Java" + i);
				pstmt.setString(3, "Program" + i);
				pstmt.setString(4, "java" + i + "@mycompany.com");
				pstmt.setString(5, "010-123-1234");
				pstmt.setString(6, "IT_PROG");
				pstmt.setDouble(7, 5000);
				pstmt.setDouble(8, 0.3);
				
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