package common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionManager;
import common.dto.Board;
import common.dto.Friend;
import common.dto.User;
import common.paging.Pager;

public class FriendDao {


	public void add(String me,String name) {
		Board board=null;
		Connection conn=null;
		try {
			//연결
			conn=ConnectionManager.getConnection();

			String sql="insert into friend(myrel,friendrel) "
					+ "values(?,?)";
			//sql실행 state얻기
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1,me);
			pstm.setString(2, name);

			//실행해서 결과셋얻기
			pstm.executeUpdate();
			pstm.close();
			//연결해제

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
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
								.append(" from friend f, users u")
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
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
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

			String sql="delete from friend where myrel=? and friendrel=?";
			//sql실행 state얻기
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1,id);
			pstm.setString(2, name);

			//실행해서 결과셋얻기
			pstm.executeUpdate();
			pstm.close();
			//연결해제

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
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
								.append(" from  friend f,boards b")
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
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
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
				
				String sq2="select count(*) as totalRows from friend where myrel=?";
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
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
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
				
				String sql="select count(*) as totalRows from friend f, boards b where f.myrel=? and f.friendrel=b.bwriter";
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
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try 
				{conn.close();}catch(SQLException e) {}
			}
		
		return result;
	}
	
}
