package exam03_insert;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Scanner;

import common.dao.ConnectionManager;
import common.dto.Board;
import common.dto.User;

public class InsertExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		Board board = new Board();
		System.out.print("btitle: "); board.setBtitle(scanner.nextLine());
		System.out.print("bcontent: "); board.setBcontent(scanner.nextLine());
		System.out.print("bwriter: "); board.setBwriter(scanner.nextLine());
		System.out.print("filepath: "); board.setBfilepaht(scanner.nextLine());
		
		
		ConnectionManager.init();
		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection2();
			String squl = "insert into boards (bno, btitle, bcontent,  bwirter , bdate, bfilename, bfileada) "
					+ "values(seq_boards_bno.nextval, ?, ?, ?, sysdate, ?, ?)";
			
			
			
			//시퀀스가 적용된 컬럼값을 가져오도록 컬럼명을 추가
			PreparedStatement pstmt = conn.prepareStatement(squl, new String[] {"bno", "btitle"} ); //배열에sql에서 가져올 값들을 선택 가능
			
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			
			if(!board.getBfilepaht().equals("")) {
				File file = new File(board.getBfilepaht());
				pstmt.setString(4, file.getName());
				pstmt.setBlob(5, new FileInputStream(board.getBfilepaht()));
				
				
			} else {
				pstmt.setString(4,  null);
				Blob blob = null;
				pstmt.setBlob(5,  blob);
			}
			
			
			//이미지 저장 파일 /Users/jbc/Desktop/osstem/temp/ReadImage.png
			
//			if(board.getBfilepaht().equals("")) {
//				pstmt.setString(4, null);
//				Blob blob = null;
//				pstmt.setBlob(0,  blob);
//			} else {
//				
//			}
			
			
			//select 가져오기
			//ResultSet rs = pstmt.executeQuery();
			
			//insert //테이블 수정
			int rows = pstmt.executeUpdate(); //insert into가 되면 1이 반환된다.
			
			ResultSet rs = pstmt.getGeneratedKeys(); //배열에서 선택된 것들의 컬럼값을 가져온다.
			rs.next();
			
			
			int bno = rs.getInt(1); //첫번째 컬럼값을 가져온다.
			System.out.println("저장된 bno: " + bno);
			rs.close();
			pstmt.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try { conn.close();} catch(Exception e) {}
		}	

	}

}
