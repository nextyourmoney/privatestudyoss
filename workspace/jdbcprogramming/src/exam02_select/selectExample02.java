package exam02_select;

import java.sql.*;
import java.util.Date;

public class selectExample02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver"); //뭐가 문제여
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50123/orcl", "hr", "kosa12345");
			System.out.println("연결 성공");
			
			//SQL을 실행할 Preparedstatement 생성 //where은 조건 검색
			String sql = "SELECT employee_id, salary, commission_pct, salary*12+salary*nvl(commission_pct, 0) as yearsal from employees"; //sql명령
			PreparedStatement pstmt = conn.prepareStatement(sql); //인터페이스
			
			//SQL을 실행해서 resultset얻기
			ResultSet rs = pstmt.executeQuery(); //인터페이스
			
			//ResultSet에 있는 행의 데이터 읽기 //검색 데이터가 여러개일 때.
			int count = 0;
			while(rs.next()) {
				int empId = rs.getInt("employee_id");
				//String email = rs.getString("email");
				int salary = rs.getInt("salary");
				double commission_pct = rs.getDouble("commission_pct");
			//Date hire_date = rs.getDate("hire_date");
				double yearsal = rs.getDouble(4);
				System.out.println(empId + "," + salary + ","  + commission_pct + "," + yearsal);
			}
			
			//조건 검색이 한개일때. 조건이 true일 때 출력 되도록 한다. 
			if(rs.next()) {
				int empId = rs.getInt("employee_id");
				//String email = rs.getString("email");
				int salary = rs.getInt("salary");
				double commission_pct = rs.getDouble("commission_pct");
				//Date hire_date = rs.getDate("hire_date");
				double yearsal = rs.getDouble(4);
				
				System.out.println(empId + "," + salary + ","  + commission_pct + "," + yearsal);
			}
			
			//ResultSet과 PreparedStatement가 사용한 메모리를 해제
			rs.close();
			pstmt.close();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //중간에 예외가 발생하더라도 반드시 종료가 실행될 수 있도록 finally를 활용한다.
			
			try {
				//연결해제
				conn.close();
				System.out.println("연결 끊김");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
