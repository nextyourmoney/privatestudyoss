package homeWork_board;

import java.util.List;


public class basicBoard {
	
	public static <E> void bascirBord(List<Employee> list) {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("사번       이름            부서이름          직무명           봉급     이메일    전화번호");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		for(Employee e : list) {
			System.out.println(e.getEmployeeId() + "\t" + e.getFirstName() 
			+ " " + e.getLastName() + "\t" + e.getDepartmentId().getDepartmentId() + "\t" 
			+ e.getJobId().getJobId() + "\t\t" + e.getSalary() 
			+ "\t\t" + e.getEmail() + "\t" + e.getPhoneNumber());
			
		}
		
		System.out.println("1. 부서 정보 |  2. 근무 지역 | 3. 분석 | 4. 종료");
	}
	
	public static <E> void detailBoard(List<Employee> list) {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("부서번호         부서이름           관리자명  ");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		for(Employee e : list) {
			System.out.println(e.getDepartmentId().getDepartmentId() + "\t" 
			+ e.getJobId().getJobId() + "\t\t" + e.getManagerId());
			
		}
		
		System.out.println("1. 부서 정보 |  2. 근무 지역 | 3. 분석 | 4. 종료");
	}
	
	public static <E> void detaillocation(List<Employee> list) {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("대륙         나라           도시          도로명주소          우편번호   ");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		for(Employee e : list) {
			System.out.printf(" %-8d", e.getDepartmentId().getDepartmentId());
			System.out.printf("%-13s", e.getJobId().getJobId());
			System.out.printf("%-8d", e.getc());
			System.out.printf("%-8d", e.getmax());
//			System.out.printf("%-10d", rs.getInt(4));
//			System.out.printf("%-11d", rs.getInt(5));
//			System.out.printf("%-11d\n", rs.getInt(6));
			
		}
		
		System.out.println("1. 부서 정보 |  2. 근무 지역 | 3. 분석 | 4. 종료");
	}
	
	public static <E> void detailsalary(List<Employee> list) {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("부서명    직무명            직원수      최대봉급    최소봉급     평균봉급");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		for(Employee e : list) {
			System.out.printf(" %-8d", e.getDepartmentId().getDepartmentId());
			System.out.printf("%-13s", e.getJobId().getJobId());
			System.out.printf("%-8d", e.getc());
			System.out.printf("%-8d", e.getmax());
			
			System.out.printf("%-10d", e.getmin());
			System.out.printf("%-11d", e.getavg());
//			System.out.printf("%-11d\n", rs.getInt(6));
			System.out.println(" ");
		}
		
		System.out.println("1. 부서 정보 |  2. 근무 지역 | 3. 분석 | 4. 종료");
	}

}
