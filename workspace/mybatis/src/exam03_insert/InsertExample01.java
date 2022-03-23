package exam03_insert;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;

public class InsertExample01 {

	public static void main(String[] args) {
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
			
			Board board = new Board();
			
				
			//board메소드 호출 //dto.board에 저장할 값 삽
			board.setBtitle("오늘의: " );
			board.setBcontent("shdm ");
			board.setBwriter("sprintg");
			
			
			/*
			//방법#1
			//게시물 여러개 가져오기
			BoardDao boardDao = session.getMapper(BoardDao.class);
			
			//BoardDao의 메소드 호출
			int rows = boardDao.insertBoard(board);
			
			System.out.println("저장된 행수: " + rows);
			*/
		
			
			//방법#2
			int rows = session.insert("dao.BoardDao.insertBoard", board);
			System.out.println("저장된 행수: " + rows);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
