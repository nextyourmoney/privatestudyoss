package exam03_insert;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dao.UserDao;
import dto.Board;
import dto.User;


public class InsertExample02 {

	public static void main(String[] args) {
		
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
			
			User user = new User();
			user.setUserId("user1");
			user.setUserName("name");
			user.setUserPassword("pass");
			user.setUserAge(25);
			user.setUserEmail("@naver");
			
			
			//방법#1
			UserDao userDao = session.getMapper(UserDao.class);
			//int rows = userDao.insertUser(user);
			
			
			//방법#2
			int rows = session.insert("dao.UserDao.insertUser", user);
			
			System.out.println("넣은 숫자개수: " + rows);
		
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
