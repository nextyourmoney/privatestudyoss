package homeWork_board;

import lombok.Data;

public class Department {
	private int departmentId;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int i) {
		this.departmentId = i;
	}
	private String departmentName;
	private int managerId;
	private int locationId;

	public void setDepartmentName(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
