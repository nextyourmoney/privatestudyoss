package exam02_select;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dao.UserDao;
import dto.Board;
import dto.Pager;
import dto.User;

public class SelectExample06 {

	public static void main(String[] args) {
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
			
			BoardDao boardDao = session.getMapper(BoardDao.class);
			UserDao userDao = session.getMapper(UserDao.class);
			//방법#1
			//User user = userDao.selectUserwithBoards("wind");
			
			
			//방법#2
			User user = session.selectOne("dao.UserDao.selectUserwithBoards","wind");
			System.out.println(user);
			for(Board board : user.getBoards()) {
				System.out.println(board);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
