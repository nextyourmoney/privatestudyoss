package homeWork_board;

import lombok.Data;
import java.util.*;

public @Data class Employee {
	private int EmployeeId;
	private String email;
	private String manager;
	private int c;
	private int ma;
	private int ma1;
	private int ma2;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String string) {
		this.jobId = string;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public Department getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getc() {
		return c;
	}
	
	public void setc(int i) {
		this.c = i;
	}
	
	public int getmax() {
		return ma;
	}
	
	public void setmax(int ma) {
		this.ma = ma;
	}
	
	public int getmin() {
		return ma1;
	}
	
	public void setmin(int ma1) {
		this.ma1 = ma1;
	}
	
	public int getavg() {
		return ma2;
	}
	
	public void setavg(int ma2) {
		this.ma2 = ma2;
	}

	
	
	
	
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private int salary;
	private int managerId;
	private Department departmentId;
	private Department department;
	private Location location;
	private Country country;
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	
}
