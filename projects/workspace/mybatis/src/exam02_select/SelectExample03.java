package exam02_select;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;
import dto.Pager;

public class SelectExample03 {

	public static void main(String[] args) {
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
			
			BoardDao boardDao = session.getMapper(BoardDao.class);
			
			//BoardDao의 메소드 호출
			Pager pager = new Pager(10, 5, boardDao.selectTotalRowCount(), 1);
			
			
			//방법#1
			//게시물 여러개 가져오기
			//List<Board> list = boardDao.selectPage(pager);
			
			//방법#2
			List<Board> list = session.selectList("dao.BoardDao.selectPage", pager);
			
			for(Board board : list) {
				System.out.println(board);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
