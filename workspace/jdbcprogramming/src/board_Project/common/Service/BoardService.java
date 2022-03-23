package board_Project.common.Service;

import java.util.List;

import board_Project.common.dao.BoardDao;
import board_Project.common.dto.Board;
import board_Project.common.dto.User;
import board_Project.common.paging.Pager;
import homeWork_board.Employee;

public class BoardService {

	private BoardDao boardDao= new BoardDao();

	//Board 데이터 가져오기 //리스트 보기
	public List<Board> getBoard(int bno) { 

		//BoardExample의  boardList()에서 받은 정수를 bno로 받아 게시판의 목록들을 처리 할 수 있도록 한다.
		return boardDao.selectByList(bno);
	}
	
	//검색  //닉네임 검사, 제목 검사 2가지로 분류
	public List<Board> getSearcjList(String searchNum) {
		//searchNum이 1이라면 닉네임검사, 2라면 제목검사로 동작하도록한다.
		
		return boardDao.SearchByList(searchNum);
	}
	
	//게시물 작성  , //현재 로그인한 사용자의 아이디 비밀번호 값을 가져와야 한다. 합칠때 작업해야 할 
	public int writeBoard() {
		int rows=boardDao.write();
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
