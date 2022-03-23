package exam02_select;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;

public class SelectExample01 {

	public static void main(String[] args) {
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
			//방법#1
			/*
			//게시물 1개 가져오기
			//BoardDao 구현 객체 얻기
			BoardDao boardDao = session.getMapper(BoardDao.class);
			
			//BoardDao의 메소드 호출
			Board board = boardDao.selectBoard(1);
			
			//리턴값 출
			System.out.println(board);
			*/
			
			//방법#2
			Board board = session.selectOne("dao.BoardDao.selectBoard", 1);
			
			System.out.println(board);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
