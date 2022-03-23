package homeWork_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exam02_select.ConnectionManager;

public class condto {
	
	private static String sql;
	


	public static List<Employee> connect(String function) {
		 Scanner scanner = new Scanner(System.in);
		
		switch(function) {
			case "0":
				 sql = "SELECT e.employee_id ,e.first_name, e.last_name, e.department_id, e.job_id, e.phone_number, e.salary, e.email"
	            + " FROM employees e, departments d, locations l, countries c"
	            + " WHERE e.department_id  = d.department_id"
	            + "    and d.location_id = l.location_id"
	            + "    and l.country_id = c.country_id";
				 
				 return connectFunction(sql);
				 
				
				 
			case "1":
				
				System.out.println("사번: ");
				String employeeNumStr = scanner.nextLine();
			
				//int employeeNum = Integer.parseInt(employeeNumStr); // 사번 검색
				
				sql = "SELECT e.employee_id ,l.location_id,e.first_name,  e.last_name, e.department_id, e.job_id, e.phone_number, e.salary, e.manager_id, e.email"
					+ " FROM employees e, departments d, locations l, countries c"
					+ " WHERE e.department_id  = d.department_id"
		            + "	   and  e.employee_id = ?";
				
				return connectFunction(sql,employeeNumStr);
				
			case "2":
				
				System.out.println("사번: ");
				String employeeNumStr1 = scanner.nextLine();
			
				//int employeeNum = Integer.parseInt(employeeNumStr); // 사번 검색
				
				sql = "SELECT e.employee_id ,l.location_id, e.department_id, e.job_id"
						+ " FROM employees e, departments d, locations l, countries c"
						+ " WHERE e.department_id  = d.department_id"
			            + "	   and  e.employee_id = ?";
				
				return connectFunction(sql,employeeNumStr1);
				
			case "3":
			
			
			
				//int employeeNum = Integer.parseInt(employeeNumStr); // 사번 검색
				
				sql = "select department_id, job_id, count(salary), "
						+ "max(salary), min(salary) as min, avg(salary) as avg "
						+ "from employees group by department_id, job_id order by department_id, job_id";
				
				return connectFunction2(sql);
			
			default:
				return null;
	
			
			}

	}
	
	public static List<Employee> connectFunction(String sql) {
		 List<Employee> list = new ArrayList<>();
		 
		 Connection conn = null;
		 
		 try {
			 conn = ConnectionManager.getConnection2();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt("employee_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setSalary(rs.getInt("salary"));
				employee.setEmail(rs.getString("email"));
				employee.setPhoneNumber(rs.getString("phone_number"));
				
				
				
				
				Job job = new Job();
				job.setJobId(rs.getString("job_id"));
				employee.setJobId(job);
				
				Department department = new Department();
				department.setDepartmentId(rs.getInt("department_id"));
				employee.setDepartmentId(department);
				
				list.add(employee);

			}
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 try {conn.close();} catch (SQLException e) {}
		 }
		 
		 
		 return list;

		
		
	}

	public static List<Employee> connectFunction(String sql, String employeeNum) {
		 List<Employee> list = new ArrayList<>();
		 
		 Connection conn = null;
		 		 
		 try {
			 conn = ConnectionManager.getConnection2();
			 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employeeNum);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt("employee_id"));
				employee.setSalary(rs.getInt("salary"));
				
				
				
				
				Job job = new Job();
				job.setJobId(rs.getString("job_id"));
				employee.setJobId(job);
				
				Department department = new Department();
				department.setDepartmentId(rs.getInt("department_id"));
				employee.setDepartmentId(department);
				
				list.add(employee);
			}
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 try {conn.close();} catch (SQLException e) {}
		 }
		 
		 
		 return list;

		
		
	}
	
	public static List<Employee> connectFunction2(String sql) {
		 List<Employee> list = new ArrayList<>();
		 
		 Connection conn = null;
		 		 
		 try {
			 conn = ConnectionManager.getConnection2();
			 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee employee = new Employee();
				//employee.setEmployeeId(rs.getInt("employee_id"));
				//employee.setSalary(rs.getInt("salary"));
				employee.setc(rs.getInt("count(salary)"));
				employee.setmax(rs.getInt("max(salary)"));
				employee.setmin(rs.getInt("min"));
				employee.setavg(rs.getInt("avg"));
				
				
				
				Job job = new Job();
				job.setJobId(rs.getString("job_id"));
				employee.setJobId(job);
				
				Department department = new Department();
				department.setDepartmentId(rs.getInt("department_id"));
				employee.setDepartmentId(department);
				
				list.add(employee);
			}
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 try {conn.close();} catch (SQLException e) {}
		 }
		 
		 
		 return list;

		
		
	}

}
