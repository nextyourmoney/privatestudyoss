package common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commission_pct;
	private int managerId;
	private int departmentId;
	
	private Department department;
	private Job job;
	private Location location;
	private Country country;
	private Region region;
}
