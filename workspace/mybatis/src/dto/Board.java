package dto;

import java.sql.*;
import java.util.Arrays;
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
	private byte[] bfiledata;	
	
	private String bfilepath;
	
	//연관 관게(Association)에 있는 객체
	private User user;
	
	@Override
	public String toString() {
		return "Board [bno=" + bno + 
				", btitle=" + btitle +
				", bcontent=" + bcontent + 
				", bwriter=" + bwriter + 
				", bdate=" + bdate + 
				", bfilename=" + bfilename + 
				", Bfiledata=" + ((bfiledata == null)?"null": "byte[" + bfiledata.length + "]") +
				", bfilepath=" + bfilepath + "]";
	}
	
	
}
