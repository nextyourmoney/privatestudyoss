package exam02_select;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class selectExample06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("사번: ");
		int empId = Integer.parseInt(scanner.nextLine());
		
		List<Employee> list = getEmployee(startDate, endDate);
		
		Employee employee = getEmployee.nextLine(empId);
		if(Employee != null) {
			for(Employee e : list) {
				/*System.out.println("employeeId: " + employee.getEmployeeId());
				System.out.println("firstname: " + employee.getFirstName());
				System.out.println("lastName: " + employee.getLastName());
				System.out.println("hireDate: " + employee.gethireDate());*/
				
				System.out.println(employee);
				
				
				
				
			}
		} else {
			System.out.println("사번이 존재하지 ㅇ낳습니다.");
		}
		                                                 
	}
	
	public static List<Employee> getEmployee(int employeeId){
		List<Employee> list = new ArrayList<>();
		
		Connection conn = null;
		
		 try {
	         //연결하기
	         Class.forName("oracle.jdbc.OracleDriver");
	         conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50111/orcl", "hr", "kosa12345");
	         System.out.println("연결 성공");
	         
	         //실행해야할 SQL 작성
	         String sql = "select * from employees where employee_id = ?";
	         
	         //SQL을 실행할 PreparedStatment 얻기
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, employeeId);
	         
	         
	         //SQL을 실행해서 ResultSet 얻기
	         ResultSet rs = pstmt.executeQuery();
	         
	         //ResultSet에 있는 행의 데이터 읽기
	         while(rs.next()) {
	        	employee = new Employee();
	            employee.setFirstName(rs.getString("first_name"));
	            employee.setLastName(rs.getString("last_name"));
	            employee.setPhoneNumber(rs.getString("phone_number"));
	            employee.setJobId(rs.getString("job_id"));
	            employee.setSalary(rs.getDouble("salary"))
	            
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

}
