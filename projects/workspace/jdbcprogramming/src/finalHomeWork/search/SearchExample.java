package finalHomeWork.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.dao.ConnectionManager;
import common.dao.Pager;
import common.dto.*;

/*
-리스트 출력-
e.employee_id  
e.first_name, e.last_name
e.department_id  = d.department_id	-> department_name
e.job_id = j.job_id -> job_title
e.salary
e.email
e.phone_number

1. 부서 정보
d.department_id, d.department_name, d.manager_id

2. 근무 지역
r.region_name, c.country_name, l.city, l.street_address, l.postal_code

3. 분석 -> group by department_id, job_id
department_id, job_id, count(salary), max(salary), min(salary), avg(salary)		
*/

public class SearchExample {

	//private static Scanner scanner;
	private static Pager pager;
	


	public static void main(String[] args) {
		ConnectionManager.init();
		pager = new Pager(10, 5, getTotalRows(), 1);
		Scanner scanner = new Scanner(System.in);
		showList();

		boolean loop = true;
		

		

		/*
		 * while(loop) { //직원 리스트 출력 //showList();
		 * 
		 * //메뉴 출력 + 메뉴 입력 받기 System.out.printf("메뉴 : %-10s| %-10s| %-10s| %-10s\n",
		 * "1. 부서정보", "2. 근무지역", "3. 분석", "4. 종료"); System.out.println(
		 * "---------------------------------------------------------------------------------------------------"
		 * ); System.out.print("선택 : ");
		 * 
		 * String selectNum = scan.nextLine().trim(); switch(selectNum) { case "1":
		 * searchDepartment(); break; case "2": searchWorkingArea(); break; case "3":
		 * analysis(); break; case "4": loop = false;
		 * System.out.println("프로그램을 종료합니다."); System.out.println(
		 * "---------------------------------------------------------------------------------------------------"
		 * ); break; default: System.out.println("잘못된 입력입니다."); System.out.println(
		 * "---------------------------------------------------------------------------------------------------\n"
		 * ); break; } }
		 */			
	}

	private static void showList() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		
			List<Employee> list = getList();
	
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.printf("%-5s%-16s%-17s%-19s%-9s%-8s%-10s\n", "사번", "이름", "부서명", "직무명", "봉급", "이메일", "전화번호");
			System.out.println("---------------------------------------------------------------------------------------------------");
	
			for(Employee e : list) {
				System.out.printf("%-5s ", e.getEmployeeId());
				System.out.printf("%-18s ", e.getFirstName() + " " + e.getLastName());
				System.out.printf("%-18s ", e.getDepartment().getDepartmentName());
	
//				if(e.getJob().getJobTitle().length() > 16) {
//					String jTitle = e.getJob().getJobTitle().substring(0, 16)+ "...";
//					System.out.printf("%-20s ", jTitle);
//				}else {
//					System.out.printf("%-20s ", e.getJob().getJobTitle());
//				}
	
				System.out.printf("%-10.1f ", e.getSalary());
				System.out.printf("%-10s ", e.getEmail());
				System.out.printf("%-12s\n", e.getPhoneNumber());
	
			}
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.print("[First]");
			System.out.print((pager.getGroupNo() >= 2)? "[Prev] " : " "); //가장 앞장에 있을 때는 prev가 나오지 않도록 설정
			
	for(int i = pager.getStartPageNo(); i <= pager.getEndPageNo(); i++) {
		if(i == pager.getPageNo()) {
			System.out.print("(" + i + ")" + ((i != pager.getEndPageNo()) ? "," : "")); //현재 페이지에 ()를 표시한다.
			
		} else {
			System.out.print(i + ((i != pager.getEndPageNo()) ? "," : "")); //페이지번호를 표시한다. 
		}
		
	}
	System.out.print((pager.getGroupNo() < pager.getTotalGroupNo())? " [Next]" : ""); //가장 마지막 페이지에는 next를 표시하지 않는다.
	System.out.println(" [Last] ");

	
	System.out.print("선택: ");
	String select = scanner.nextLine();
	if(select.equals("f") || select.equals("F")) {
		getFirstPage();
		
	} else if(select.equals("p") || select.equals("P")) {
		getPrevGroup();
		
	} else if(select.equals("n") || select.equals("N")) {
		getNextGroup();
		
	} else if(select.equals("l") || select.equals("L")) {
		getLast();
		
	} else { //원하는 페이지로 이동
		getPage(Integer.parseInt(select));
	}
			
			System.out.println("\n---------------------------------------------------------------------------------------------------");
	}
}

	private static void getPage(int pageNo) {
		pager = new Pager(10, 5, getTotalRows(), pageNo);
		
	}
	private static void getLast() {
		pager = new Pager(10, 5, getTotalRows(), pager.getTotalPageNo());
		
	}
	private static void getNextGroup() {
		pager = new Pager(10, 5, getTotalRows(), pager.getEndPageNo() + 1);
		
		
	}
	private static void getPrevGroup() {
		pager = new Pager(10, 5, getTotalRows(), pager.getStartPageNo() -1);
		
		
	}
	private static void getFirstPage() {
		pager = new Pager(10, 5, getTotalRows(), 1);
		
		
	}
	
	private static int getTotalRows() {
		int result = 0;
		
		 Connection conn = null;
	      
	      try {
	         conn = ConnectionManager.getConnection2();
	         
	         String sql = "select count(*) from employees"; //전체 개수 
	        		 
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	 result = rs.getInt(1);
	         }
	         
	         rs.close();
	         pstmt.close();
	         
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         try { 
	        	 conn.close(); 
	        } catch (SQLException e) {}
	      }
		return result;
	}

	//1. 부서 정보 : d.department_id, d.department_name, d.manager_id
	private static void searchDepartment() {
		boolean check = false;
		Scanner scan = new Scanner(System.in);

		System.out.print("사번 : ");
		int empId = Integer.parseInt(scan.nextLine());

		List<Employee> list = getList();
		for(Employee e : list) {
			if(empId == e.getEmployeeId()) {
				System.out.println("---------------------------------------------------------------------------------------------------");
				System.out.printf("%-7s%-17s%-15s\n", "부서번호", "부서이름", "관리자명");
				System.out.println("---------------------------------------------------------------------------------------------------");
				System.out.printf(" %-10d", e.getDepartment().getDepartmentId());
				System.out.printf("%-20s", e.getDepartment().getDepartmentName());

				int managerNum = e.getManagerId();
				String managerName = getManager(managerNum);
				System.out.printf("%-15s\n", managerName);

				check = true;
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------\n");

		if(!check) {
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println(empId+"번에 해당하는 사원은 존재하지 않습니다.");
		}
	}

	private static String getManager(int managerNum) {
		String managerName = null;

		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection2();
			String sql = "select first_name, last_name from employees where employee_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, managerNum);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				managerName = rs.getString("first_name") + " " + rs.getString("last_name");
			}		
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException | SQLException e) {

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
		return managerName;
	}

	//2. 근무 지역  : r.region_name, c.country_name, l.city, l.street_address, l.postal_code
	private static void searchWorkingArea() {
		boolean check = false;
		Scanner scan = new Scanner(System.in);

		System.out.print("사번 : ");
		int empId = Integer.parseInt(scan.nextLine());

		List<Employee> list = getList();
		for(Employee e : list) {
			if(empId == e.getEmployeeId()) {
				System.out.println("---------------------------------------------------------------------------------------------------");
				System.out.printf("%-10s%-27s%-18s%-27s%-10s\n", "대륙", "나라", "도시", "도로명주소", "우편번호");
				System.out.println("---------------------------------------------------------------------------------------------------");

				System.out.printf("%-12s", e.getRegion().getRegionName());					
				System.out.printf("%-28s", e.getCountry().getCountryName());
				System.out.printf("%-20s", e.getLocation().getCity());
				System.out.printf("%-32s", e.getLocation().getStreetAddress());
				System.out.printf("%-10s\n", e.getLocation().getPostalCode());
				check = true;
			}
		}

		System.out.println("---------------------------------------------------------------------------------------------------\n");

		if(!check) {
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println(empId+"번에 해당하는 사원은 존재하지 않습니다.");
		}
	}

	//3. 분석 : department_id, job_id, count(salary), max(salary), min(salary), avg(salary)
	private static void analysis() {
		Connection conn = null;
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.printf("%-6s%-10s%-6s%-7s%-7s%-7s\n", "부서명", "직무명", "직원수", "최대봉급", "최소봉급", "평균봉급");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		try {
			conn = ConnectionManager.getConnection2();
			String sql = "select department_id, job_id, count(salary), max(salary), min(salary), avg(salary) from employees group by department_id, job_id order by department_id, job_id";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				System.out.printf(" %-8d", rs.getInt("department_id"));
				System.out.printf("%-13s", rs.getString("job_id"));
				System.out.printf("%-8d", rs.getInt(3));
				System.out.printf("%-10d", rs.getInt(4));
				System.out.printf("%-11d", rs.getInt(5));
				System.out.printf("%-11d\n", rs.getInt(6));
			}	
			System.out.println("---------------------------------------------------------------------------------------------------\n");

			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException | SQLException e) {

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
	}

	private static List<Employee> getList() {
		List<Employee> list = new ArrayList<>();
		
		
		Connection conn = null;

		try {
			
			conn = ConnectionManager.getConnection2();
			String sql = new StringBuilder() //두번째 ?에서부터 첫번째 ?까지의 값을 가져온다. 
	        		.append( "select rownum as rnum, employee_id, first_name, last_name, job_id, phone_number, email, salary, department_name")
	        		.append(" from(")
	        		.append( " select rownum as rnum, employee_id, first_name, last_name, job_id, phone_number, email, salary, department_name")
	        		.append( " from (")
	        		.append(     " select employee_id, first_name, last_name, job_id, phone_number, email, salary, d.department_name  ")
	        		.append(     " from employees e, departments d where e.department_id  = d.department_id ")
	        		.append(     " order by employee_id desc)")
	        		.append("	where rownum <= ?)")
	        		.append(" where rnum >= ?")
	        		.toString();
			
//			sql = "SELECT e.employee_id ,e.first_name, e.last_name, e.department_id, e.job_id, e.phone_number, e.salary, e.email"
//		            + " FROM employees e, departments d, locations l, countries c"
//		            + " WHERE e.department_id  = d.department_id"
//		            + "    and d.location_id = l.location_id"
//		            + "    and l.country_id = c.country_id";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pager.getPageNo() * pager.getRowsPerPage() );
	        pstmt.setInt(2, (pager.getPageNo() - 1) * pager.getRowsPerPage() + 1);
	         
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
//				Employee emp = new Employee();
//				emp.setEmployeeId(rs.getInt("employee_id"));
//				emp.setFirstName(rs.getString("first_name"));
//				emp.setLastName(rs.getString("last_name"));
//				emp.setSalary(rs.getDouble("salary"));
//				//emp.setEmail(rs.getString("email"));
//				emp.setPhoneNumber(rs.getString("phone_number"));
				//emp.setManagerId(rs.getInt("manager_id"));
				
				Employee employee = new Employee();
				employee.setSalary(rs.getDouble("salary"));
	            employee.setEmployeeId(rs.getInt("employee_id"));
	            //employee.setSalary(rs.getInt("salary"));
	           // employee.setDepartmentId(rs.getInt("department_id"));
	            employee.setFirstName(rs.getString("first_name"));
	            employee.setLastName(rs.getString("last_name"));
	            employee.setJobId(rs.getString("job_id"));
	            employee.setPhoneNumber(rs.getString("phone_number"));
	            employee.setEmail(rs.getString("email"));
	            employee.setDepartment(new Department());
	            
				Department d = employee.getDepartment();
				d.setDepartmentName(rs.getString("department_name"));
				
	            list.add(employee);

				
//				d.setDepartmentId(rs.getInt("department_id"));
//				d.setManagerId(rs.getInt("manager_id"));
//				d.setLocationId(rs.getInt("location_id"));

//				emp.setJob(new Job());
//				Job j = emp.getJob();
//				j.setJobTitle(rs.getString("job_title"));
//
//				emp.setLocation(new Location());
//				Location l = emp.getLocation();
//				l.setCity(rs.getString("city"));
//				l.setStreetAddress(rs.getString("street_address"));
//				l.setPostalCode(rs.getString("postal_code"));
//
//				emp.setCountry(new Country());
//				Country c = emp.getCountry();
//				c.setCountryName(rs.getString("country_name"));
//
//				emp.setRegion(new Region());
//				Region r = emp.getRegion();
//				r.setRegionName(rs.getString("region_name"));

				list.add(employee);
			}		
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException | SQLException e) {
			

		} finally {
			try {
				
				conn.close();
			} catch (SQLException e) {
				

			}
		}	

		return list;
	}
	
	
}
