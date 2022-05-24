apackage exam02_select;

import java.util.Date;

import lombok.Data;

@Data
public class Employee {

	private int setEmployeeId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private int salary;
	private int managerId;
	private int departmentId;
	public char[] getdepartment() {
		// TODO Auto-generated method stub
		return null;
	}

}
