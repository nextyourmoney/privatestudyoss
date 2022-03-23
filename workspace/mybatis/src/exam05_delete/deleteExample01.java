package exam05_delete;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;

public class deleteExample01 {

	public static void main(String[] args) {
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
		
			int bno = 620;
			
			//방법1
//			BoardDao boardDao = session.getMapper(BoardDao.class);
//			int rows = boardDao.deleteBoard(bno);
			
			
			//방법2
			int rows = session.delete("dao.BoardDao.deleteBoard", bno);	
			
			System.out.print("삭제된 행수: " + rows);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
