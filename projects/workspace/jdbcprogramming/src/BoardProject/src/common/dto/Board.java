package common.dto;

import java.sql.*;
import java.util.Date;

import lombok.*;

@Data
public class Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate;
	private String bfilename;
	private String bfilepath;
	private Blob Bfiledata;
	private int bcategoryid;
										
}
