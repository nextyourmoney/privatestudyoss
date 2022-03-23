package exam02_select;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;
import dto.Pager;

public class SelectExample04 {

	public static void main(String[] args) {
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
			
			BoardDao boardDao = session.getMapper(BoardDao.class);
			
			//BoardDao의 메소드 호출
			Pager pager = new Pager(10, 5, boardDao.selectTotalRowCount(), 1);
			
			
			//방법#1
			Board board = boardDao.selectBoardwithUser(40);
			
			//방법#2
			//List<Board> list = session.selectList("dao.BoardDao.selectPage", pager);
			System.out.println(board);
			System.out.println(board.getUser().getUserName());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
