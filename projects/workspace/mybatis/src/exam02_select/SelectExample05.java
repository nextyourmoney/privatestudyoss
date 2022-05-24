package exam02_select;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;
import dto.Pager;

public class SelectExample05 {

	public static void main(String[] args) {
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
			
			BoardDao boardDao = session.getMapper(BoardDao.class);
			
			//BoardDao의 메소드 호출
			Pager pager = new Pager(10, 5, boardDao.selectTotalRowCount(), 1);
			
			
			//방법#1
			Board board = boardDao.selectBoardwithUser2(40);
			
			//방법#2
			//Board board = session.selectOne("dao.BoardDao.selectBoardwithUser",40);
			System.out.println(board);
			System.out.println(board.getUser().getUserName());
			System.out.println(board.getUser().getUserEmail());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
