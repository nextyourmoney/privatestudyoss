package exam02_select;

import java.sql.*;
import java.util.Scanner;

public class selectExample07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이메일: ");
		String email = scanner.nextLine();
		System.out.println("비밀번호: ");
		String password = scanner.nextLine();
		
		String result = login(email, password);
		if(result.equals("success")) {
			System.out.println("로그인 틀립니다");
		} else if(result.equals("wrongEmail")) {
			System.out.println("이메일 틀립니다");
		} else if(result.equals("wrongPassword")) {
			System.out.println("비밀번호가 틀립니다");
		}
		
	}
	
	public static String login(String email, String password) {
		String result = "seuccess";
		
		
		Connection conn = null;
		
		 try {
	         //연결하기
	         Class.forName("oracle.jdbc.OracleDriver");
	         conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50111/orcl", "hr", "kosa12345");
	         System.out.println("연결 성공");
	         
	         //실행해야할 SQL 작성
	         String sql = "select email, first_name from employees where email = ?";
	         
	         //SQL을 실행할 PreparedStatment 얻기
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, email);
	         
	         //SQL을 실행해서 ResultSet 얻기
	         ResultSet rs = pstmt.executeQuery();
	         
	         //ResultSet에 있는 행의 데이터 읽기
	         if(rs.next()) {
	        	String dbPassword = rs.getString("first_name");
	        	if(dbPassword.equals(dbPassword)) {
	        		
	        	} else {
	        		result = "wrongPassword";
	        	}
	         } else {
	        	 result = "wrongEmail";
	        	 
	         }
	         
	         //ResultSet과 PreparedStatement가 사용한 메모리를 해제
	         rs.close();
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
		return result;
	}
	
	

}
