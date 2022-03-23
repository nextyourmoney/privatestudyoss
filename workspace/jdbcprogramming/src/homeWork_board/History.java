package homeWork_board;

import lombok.Data;
import java.util.Date;

@Data
public class History {
	private int employeeId;
	private Date StartDate;
	private Date endDate;
	private String jobId;
	private int departmentId;
	
}
