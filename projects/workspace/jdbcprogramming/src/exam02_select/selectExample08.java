package exam02_select;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class selectExample08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("검: ");
		String keyword = scanner.nextLine();
		
		
		List<Employee> list = search(keyword);
		for(Employee employee : list) {
			System.out.println(employee);
		}
		
	}
	
	public static List<Employee> search(String keyword) {
		
		List<Employee> list = new ArrayList<>();
		Connection conn = null;
		
		 try {
	         //연결하기
	         conn = ConnectionManager.getConnection();
	         
	         //실행해야할 SQL 작성
	         String sql = "select first_name from employees where lower(replace(first_name, '자바', ?)) like ?";
	         
	         //SQL을 실행할 PreparedStatment 얻기
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, "%" + keyword + "%");
	         pstmt.setString(2,  "%" + keyword + "%");
	         
	         //SQL을 실행해서 ResultSet 얻기
	         ResultSet rs = pstmt.executeQuery();
	         while(rs.next()) {
	        	 Employee employee = new Employee();
	        	 
	        	 list.add(employee);
	        	 
	        	 
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
