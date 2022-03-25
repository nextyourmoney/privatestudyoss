package teamBoard_mybatis.common.dto;

import java.sql.*;
import java.util.Date;

import dto.User;
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
	//private Blob Bfiledata;
	private int bcategoryid;
	private byte[]bfiledata;	
	
	
	private User user;
	private Category category;
	private Friend friend;
	
	@Override
	public String toString() {
		return "Board [bno=" + bno + 
				", btitle=" + btitle +
				", bcontent=" + bcontent + 
				", bwriter=" + bwriter + 
				", bdate=" + bdate + 
				", bcategoryid=" + bcategoryid +
				", bfilename=" + bfilename + 
				", Bfiledata=" + ((bfiledata == null)?"null": "byte[" + bfiledata.length + "]") +
				", bfilepath=" + bfilepath + "]";
										
	}
}
