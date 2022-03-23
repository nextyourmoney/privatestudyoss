package exam02_select;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class selectExample05 {

	public static void main(String[] args) {
	      Scanner scanner = new Scanner(System.in);
	      System.out.print("시작일: ");
	      String startDate = scanner.nextLine(); //2006/01/01      
	      System.out.print("종료일: ");ad
	      String endDate = scanner.nextLine(); //2008/12/31   
	      
	      Connection conn = null;
	      
	      
	      public static List<Employee> getList(String startDate, String  endDate);
	      for(Employee e : list) {
	    	  System.out.println("");
	    	  System.out.println("");
	    	  System.out.println("employeeId: " + e.getFirstName());
	    	  System.out.println(e.getLastName());
	    	  System.out.println(e.getHireDate));
	      }
	      
	      try {
	         //연결하기
	         Class.forName("oracle.jdbc.OracleDriver");
	         conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50111/orcl", "hr", "kosa12345");
	         System.out.println("연결 성공");
	         
	         //실행해야할 SQL 작성
	         String sql = "select employee_id, first_name, length(first_name) as fnlength, last_name, hire_date from employees where hire_date between ? and ?";
	         
	         //SQL을 실행할 PreparedStatment 얻기
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, startDate);
	         pstmt.setString(2, endDate);
	         
	         //SQL을 실행해서 ResultSet 얻기
	         ResultSet rs = pstmt.executeQuery();
	         
	         //ResultSet에 있는 행의 데이터 읽기
	         while(rs.next()) {
	        	 Employee employee = new Employee();
	        	 employee.setEmployeeId(rs.getInt("employee_id"));
	        	 employee.setFirstname(rs.getString("first_name"));
	        	 int fnLength = rs.getInt("fnlength");
	        	 employee.setLastName(rs.getString("last_name"));
	        	 employee.setHireDate(rs.getDate("hire_date");)
	        	 
	            int empId = rs.getInt("employee_id");
	            String firstName = rs.getString("first_name");
	            int fnLength = rs.getInt("fnlength");
	            String lastName = rs.getString("last_name");
	            Date hireDate = rs.getDate("hire_date");
	            
	            if(fnLength > 5) {
	               firstName = firstName.substring(0, 5) + "***";
	            } 
	            
	            System.out.println(empId + ", " + firstName + ", " + lastName + ", " + hireDate);
	            //100, abcde***, abcd, 2006-01-03
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
	   }

}
