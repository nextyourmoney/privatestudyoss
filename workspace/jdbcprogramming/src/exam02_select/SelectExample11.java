package exam02_select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import homeWork_board.Country;
import homeWork_board.Department;
import homeWork_board.Employee;
import homeWork_board.Location;

public class SelectExample11 {
	//Field
	private Scanner scanner;
	private Pager pager;
	
	//Constructor
	public SelectExample11() {
		scanner = new Scanner(System.in);
		ConnectionManager.init();
		pager = new Pager(10, 10, getTotalRows(), 1);
	}
	
	//Method
	public void start() {
		while(true) {
			System.out.println("----------------------------");
			System.out.printf("ID \t FirstName \t LastName \t JobId \t Tel \t Email \n");
			System.out.println("----------------------------");
			
			List<Employee> list = list();
			for(Employee e : list) {
				System.out.printf(e.getEmployeeId() + "\t");
				System.out.printf(e.getFirstName() + "\t");
				System.out.printf(e.getLastName() + "\t");
				System.out.printf(e.getJobId() + "\t");
				System.out.printf(e.getPhoneNumber() + "\t");
				System.out.printf(e.getEmail() + "\t\n");
			}

			System.out.println("----------------------------");
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
			
		}
	}
	
	private int getTotalRows() { //전체 페이지(전체열 구하기)
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
	
	 private List<Employee> list() {
	      List<Employee> list = new ArrayList<>();
	      
	      Connection conn = null;
	      
	      try {
	         conn = ConnectionManager.getConnection2();
	         
	         String sql = new StringBuilder() //두번째 ?에서부터 첫번째 ?까지의 값을 가져온다. 
	        		.append( "select rownum as rnum, employee_id, first_name, last_name, job_id, phone_number, email")
	        		.append(" from(")
	        		.append( " select rownum as rnum, employee_id, first_name, last_name, job_id, phone_number, email")
	        		.append( " from (")
	        		.append(     " select employee_id, first_name, last_name, job_id, phone_number, email")
	        		.append(     " from employees")
	        		.append(     " order by employee_id desc)")
	        		.append("	where rownum <= ?)")
	        		.append(" where rnum >= ?")
	        		.toString();
	        		 
	        		        
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, pager.getPageNo() * pager.getRowsPerPage() );
	         pstmt.setInt(2, (pager.getPageNo() - 1) * pager.getRowsPerPage() + 1);
	         
	         ResultSet rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            Employee employee = new Employee();
	            employee.setEmployeeId(rs.getInt("employee_id"));
	            employee.setFirstName(rs.getString("first_name"));
	            employee.setLastName(rs.getString("last_name"));
	            employee.setJobId(rs.getString("job_id"));
	            employee.setPhoneNumber(rs.getString("phone_number"));
	            employee.setEmail(rs.getString("email"));
	           
	            list.add(employee);
	         }
	         
	         rs.close();
	         pstmt.close();
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         try { conn.close(); } catch (SQLException e) {}
	      }
	      
	      return list;
	   }

	private void getPage(int pageNo) {
		pager = new Pager(10, 5, getTotalRows(), pageNo);
		
	}
	private void getLast() {
		pager = new Pager(10, 5, getTotalRows(), pager.getTotalPageNo());
		
	}
	private void getNextGroup() {
		pager = new Pager(10, 5, getTotalRows(), pager.getEndPageNo() + 1);
		
		
	}
	private void getPrevGroup() {
		pager = new Pager(10, 5, getTotalRows(), pager.getStartPageNo() -1);
		
		
	}
	private void getFirstPage() {
		pager = new Pager(10, 5, getTotalRows(), 1);
		
		
	}
	public static void main(String[] args) {
		SelectExample11 exam = new SelectExample11();
		exam.list();
		exam.start();
		
	}

}
