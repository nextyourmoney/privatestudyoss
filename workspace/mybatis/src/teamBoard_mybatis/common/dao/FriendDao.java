package teamBoard_mybatis.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import teamBoard_mybatis.common.ConnectionManager;
import teamBoard_mybatis.common.dto.Board;
import teamBoard_mybatis.common.dto.Friend;
import teamBoard_mybatis.common.dto.User;
import teamBoard_mybatis.common.paging.Pager;

public class FriendDao {


	public void add(String me,String name) {
		Board board=null;
		Connection conn=null;
		int row=0;
		try {
			//연결
			conn=ConnectionManager.getConnection();
			
			String sql="select usernickname  from users_team where usernickname=?";
			PreparedStatement pstm1=conn.prepareStatement(sql);
			pstm1.setString(1,name);
			ResultSet rs=pstm1.executeQuery();
			if(rs.next()) {
				row=1;
			}
			
			if(row==1) {
				String sql2="insert into friend_team(myrel,friendrel) "
					+ "values(?,?)";
			//sql실행 state얻기
				PreparedStatement pstm2=conn.prepareStatement(sql2);
				pstm2.setString(1,me);
				pstm2.setString(2, name);

			//실행해서 결과셋얻기
				int rows=pstm2.executeUpdate();
				
				
				System.out.println(name+"을 친구에 추가했습니다.");
				pstm2.close();
			}
			else {
					System.out.println(name+"은 없는 친구입니다.");
			}
			//연결해제

		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 접근 입니다 다시 입력해주세요");
		}catch(SQLException e) {
			System.out.println("잘못된 접근 입니다 다시 입력해주세요");
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {

			}
		}
	}
	public List<User> showList(String id,Pager pager) {
		Connection conn=null;
		List<User> list=new ArrayList<>();
		
		try {
				//연결
				conn=ConnectionManager.getConnection();
				String sql=new StringBuilder()
								.append("select rnum,friendrel,username,userage,userphonenumber,useremail")
								.append(" from ( ")
								.append(" select rownum as rnum,friendrel,username,userage,userphonenumber,useremail")
								.append("  from (")
								.append(" select f.friendrel,u.username,u.userage,u.userphonenumber,u.useremail")
								.append(" from friend_team f, users_team u")
								.append(" where f.myrel=? and u.usernickname=f.friendrel")
								.append("  ) ")
								.append(" where rownum<=?")
								.append(" ) ")
								.append("where rnum>=?").toString();
				PreparedStatement pstm=conn.prepareStatement(sql);
				pstm.setString(1, id);
				pstm.setInt(2, pager.getPageNo()*pager.getRowsPerPage());
				
				pstm.setInt(3, (pager.getPageNo()-1)*pager.getRowsPerPage()+1);
				
				//실행해서 결과셋얻기
				ResultSet rs=pstm.executeQuery();
				while(rs.next()) {
					Friend friend=new Friend();
					User user=new User();
					friend.setFriendrel(rs.getString("friendrel"));
					user.setUserNickName(friend.getFriendrel());
					user.setUserName(rs.getString("username"));
					user.setUserAge(rs.getInt("userage"));
					user.setUserPhoneNumber(rs.getString("userphonenumber"));
					user.setUserEmail(rs.getString("useremail"));
					list.add(user);
					
				}
				
				rs.close();
				pstm.close();
			}catch(ClassNotFoundException e) {
				System.out.println("잘못된 접근 입니다 다시 입력해주세요");
			}catch(SQLException e) {
				System.out.println("잘못된 접근 입니다 다시 입력해주세요");
			}finally {
				try 
				{conn.close();}catch(SQLException e) {}
			}
		return list;
	}
	public void delete(String id ,String name) {
		Board board=null;
		Connection conn=null;
		try {
			//연결
			conn=ConnectionManager.getConnection();

			String sql="delete from friend_team where myrel=? and friendrel=?";
			//sql실행 state얻기
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1,id);
			pstm.setString(2, name);

			//실행해서 결과셋얻기
			int rows=pstm.executeUpdate();
			pstm.close();
			//연결해제
			if(rows==1) {
				System.out.println(name+"을 친구에 삭제했습니다.");
			}
			else {
				System.out.println(name+"은 없는 친구입니다.");
			}

		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 접근 입니다 다시 입력해주세요");
		}catch(SQLException e) {
			System.out.println("잘못된 접근 입니다 다시 입력해주세요");
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {

			}
		}
	}

	public List<Board> showBoard(String keyid,Pager pager) {

		Connection conn=null;
		List<Board> list=new ArrayList<>();
		
		
		try {
				//연결
				conn=ConnectionManager.getConnection();
				String sql=new StringBuilder()
								.append("select rnum,bwriter,btitle,bdate")
								.append(" from ( ")
								.append(" select rownum as rnum,bwriter,btitle,bdate")
								.append("  from (")
								.append(" select b.bwriter,b.btitle,b.bdate")
								.append(" from  friend_team f,boards_team b")
								.append(" where f.myrel=? and f.friendrel=b.bwriter")
								.append("  ) ")
								.append(" where rownum<=?")
								.append(" ) ")
								.append("where rnum>=?").toString();
				PreparedStatement pstm=conn.prepareStatement(sql);
				pstm.setString(1,keyid);
				pstm.setInt(2, pager.getPageNo()*pager.getRowsPerPage());		
				pstm.setInt(3, (pager.getPageNo()-1)*pager.getRowsPerPage()+1);
				
				//실행해서 결과셋얻기
				System.out.println("친구이름\t\t제목\t\t날짜\t\t");
				//실행해서 결과셋얻기
				ResultSet rs=pstm.executeQuery();
				while(rs.next()) {
					Board b=new Board();
					b.setBwriter(rs.getString("bwriter"));
					b.setBtitle(rs.getString("btitle"));
					b.setBdate(rs.getDate("bdate"));
					list.add(b);
					
				}
				
				rs.close();
				pstm.close();
			}catch(ClassNotFoundException e) {
				System.out.println("잘못된 접근 입니다 다시 입력해주세요");
			}catch(SQLException e) {
				System.out.println("잘못된 접근 입니다 다시 입력해주세요");
			}finally {
				try 
				{conn.close();}catch(SQLException e) {}
			}
		return list;



	}
	public int countFriend(String keyid) {
		int result =0;
		Connection conn=null;
		try {
				//연결
				conn=ConnectionManager.getConnection();
				
				
				String sq2="select count(*) as totalRows from friend_team where myrel=?";
				PreparedStatement pstm=conn.prepareStatement(sq2);
				pstm.setString(1, keyid);
				//실행해서 결과셋얻기
				ResultSet rs=pstm.executeQuery();
				if(rs.next()) {
					result=rs.getInt("totalRows");
					
					
				}
				
				rs.close();
				pstm.close();
			}catch(ClassNotFoundException e) {
				System.out.println("잘못된 접근 입니다 다시 입력해주세요");
			}catch(SQLException e) {
				System.out.println("잘못된 접근 입니다 다시 입력해주세요");
			}finally {
				try 
				{conn.close();}catch(SQLException e) {}
			}
		
		return result;
	}
	public int countBoard(String keyid) {
		int result =0;
		Connection conn=null;
		try {
				//연결
				conn=ConnectionManager.getConnection();
				
				String sql="select count(*) as totalRows from friend_team f, boards_team b where f.myrel=? and f.friendrel=b.bwriter";
				PreparedStatement pstm=conn.prepareStatement(sql);
				pstm.setString(1, keyid);
				//실행해서 결과셋얻기
				ResultSet rs=pstm.executeQuery();
				if(rs.next()) {
					result=rs.getInt("totalRows");
					
					
				}
				
				rs.close();
				pstm.close();
			}catch(ClassNotFoundException e) {
				System.out.println("잘못된 접근 입니다 다시 입력해주세요");
			}catch(SQLException e) {
				System.out.println("잘못된 접근 입니다 다시 입력해주세요");
			}finally {
				try 
				{conn.close();}catch(SQLException e) {}
			}
		
		return result;
	}
	
}
