package exam02_select;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;

public class SelectExample02 {

	public static void main(String[] args) {
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
			/*
			//방법#1
			//게시물 여러개 가져오기
			BoardDao boardDao = session.getMapper(BoardDao.class);
			
			//BoardDao의 메소드 호출
			List<Board> list = boardDao.selectAll();
			
			//flxjs rkqt cnffur
			for(Board board : list) {
				System.out.println(board);
			}
			*/
			
			//방법#2
			List<Board> list = session.selectList("dao.BoardDao.selectAll");
			
			for(Board board : list) {
				System.out.println(board);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
