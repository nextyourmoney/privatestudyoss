package BoardProject_team.src.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.ConnectionManager;
import common.dto.Board;
import common.dto.User;

public class Userdao {

	public int signUp(User user) {
		int result = 0; 
		boolean id_check = false;  //아이디가 이미 존재하면 true
		boolean nickname_check = false;  //닉네임이 이미 존재하면 true

		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection();

			String sql_id_check = "select userid from users where userid=?"; 
			PreparedStatement pstmt_id_check = conn.prepareStatement(sql_id_check);
			System.out.println(user.getUserId());
			pstmt_id_check.setString(1, user.getUserId());
			
			ResultSet rs_id_check = pstmt_id_check.executeQuery();


			if(rs_id_check.next()) {
				id_check=true;
				result=-1;  //이미 존재하는 아이디
			}
			rs_id_check.close();
			pstmt_id_check.close();


			String sql_nickname_check = "select usernickname from users where usernickname=?"; 
			PreparedStatement pstmt_nickname_check = conn.prepareStatement(sql_nickname_check);
			System.out.println(user.getUserNickName());
			pstmt_nickname_check.setString(1, user.getUserNickName());
			ResultSet rs_nickname_check = pstmt_nickname_check.executeQuery();

			if(rs_nickname_check.next()) {
				nickname_check=true;
				result=-2;  //이미 존재하는 닉네임
			}
			
			rs_nickname_check.close();
			pstmt_nickname_check.close();

			if(id_check && nickname_check) {
				result=-3;  //이미 존재하는 아이디와 닉네임
			}
			
			if(!nickname_check && !id_check) {
				String sql = "insert into users values (?, ?, ?, ?, ?, ?, ?)"; 

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getUserpassword());
				pstmt.setString(3, user.getUserNickName());
				pstmt.setString(4, user.getUserName());
				pstmt.setInt(5, user.getUserAge());
				pstmt.setString(6, user.getUserPhoneNumber());
				pstmt.setString(7, user.getUserEmail());

				result = pstmt.executeUpdate();
				pstmt.close();
			}


		} catch (ClassNotFoundException e) {    
			e.printStackTrace();
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}

		return result;
	}

	public User login(String userId, String userPassword) {
		User user = null;
		Connection conn = null;
		boolean idCheck = false;  

		try {
			conn = ConnectionManager.getConnection();

			//아이디가 존재하는지 확인 
			String sql2 = "select userid from users where userid=?";
			
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, userId);
			ResultSet rs2 = pstmt2.executeQuery();

			if(rs2.next()) {   
				idCheck = true;  //해당하는 아이디가 존재한다면 idCheck = true
				System.out.println(idCheck);
			}else {
				user = new User();
				user.setCheck(1);
			}

			rs2.close();
			pstmt2.close();

			if(idCheck) {
				String sql = "select userid, userpassword, usernickname, username, userage, userphonenumber, useremail from users where userid=? and userpassword=?"; 

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, userPassword);

				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) {   //행을 이동하면서 데이터를 읽는다
					user = new User();
					user.setUserId(rs.getString("userid"));
					user.setUserpassword(rs.getString("userpassword"));;
					user.setUserNickName(rs.getString("usernickname"));
					user.setUserName(rs.getString("username"));
					user.setUserAge(rs.getInt("userage"));
					user.setUserPhoneNumber(rs.getString("userphonenumber"));
					user.setUserEmail(rs.getString("useremail"));

					rs.close();
					pstmt.close();
				}else {
					user = new User();
					user.setCheck(2);
				}
			}

		} catch (ClassNotFoundException e) {    
			e.printStackTrace();
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		return user;
	}

}
