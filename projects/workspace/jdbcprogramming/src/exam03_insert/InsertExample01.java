package exam03_insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import common.dao.ConnectionManager;
import common.dto.User;

public class InsertExample01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		User user = new User();
		System.out.print("userid: "); user.setUserId(scanner.nextLine());
		System.out.print("userName: "); user.setUserName(scanner.nextLine());
		System.out.print("userPassword: "); user.setUserPassword(scanner.nextLine());
		System.out.print("userAge: "); user.setUserAge(scanner.nextInt());
		System.out.print("userEmail: "); user.setUserEmail(scanner.nextLine());
		
		ConnectionManager.init();
		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection2();
			String squl = "insert into users (userid, username, userpassword, userage,  useremail) values(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(squl);
			
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setInt(4, user.getUserAge());
			pstmt.setString(5, user.getUserEmail());
			
			//select 가져오기
			//ResultSet rs = pstmt.executeQuery();
			
			//insert //테이블 수정
			int rows = pstmt.executeUpdate(); //insert into가 되면 1이 반환된다.
			
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try { conn.close();} catch(Exception e) {}
		}	

	}

}
