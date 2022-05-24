package common.dto;

import lombok.Data;

@Data
public class Department {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
