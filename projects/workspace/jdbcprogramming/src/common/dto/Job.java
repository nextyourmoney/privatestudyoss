package common.dto;

import lombok.Data;

@Data
public class Job {
	private String jobId;
	private String jobTitle;
	private double minSalary;
	private double maxSalary;
}
