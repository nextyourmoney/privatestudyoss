package exam04_update;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;

public class UpdateExample01 {

	public static void main(String[] args) {
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
		
			int bno = 620;
			
			//방법1
//			BoardDao boardDao = session.getMapper(BoardDao.class);
//			Board board = boardDao.selectBoard(7);
//			
//			board.setBtitle("제목");
//			board.setBcontent("rhd");
//			
//			int rows = boardDao.updateBoard(board);
			
			//방법2
			Board board = session.selectOne("dao.BoardDao.selectBoard", bno);
			board.setBtitle("title2");
			//board.setBcontent("dflkjslf");
			int rows = session.update("dao.BoardDao.updateBoard", board);
			
			System.out.print("저장된 행수: " + rows);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
