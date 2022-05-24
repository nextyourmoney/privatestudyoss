package common.Service;

import java.util.List;

import common.dao.BoardDao;
import common.dto.Board;

public class BoardService {

	private BoardDao boardDao= new BoardDao();

	
	//검색  //닉네임 검사, 제목 검사 2가지로 분류
	public List<Board> getSearcjList(String searchNum) {
		//searchNum이 1이라면 닉네임검사, 2라면 제목검사로 동작하도록한다.
		
		return boardDao.SearchByList(searchNum);
	}
	
	//게시물 작성  , //현재 로그인한 사용자의 아이디 비밀번호 값을 가져와야 한다. 합칠때 작업해야 할 
	public int writeBoard(String nickname) {
		int rows=boardDao.write(nickname);
		return rows;
	}
	
	//수정
	public int modifyBoard(String selectUpdate) { 
		int rows = boardDao.update(selectUpdate);
		return rows;
	}

	//삭제
	public int removeBoard(int bno) {//삭제
		int rows = boardDao.deleteByBno(bno);

		return rows;
	}
	
	//상세보기
	public List<Board> detailView(int bno) {
		
		return boardDao.detailByBno(bno);
	}
	

}
