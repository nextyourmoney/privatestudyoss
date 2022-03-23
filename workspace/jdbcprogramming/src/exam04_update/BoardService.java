package exam04_update;

import java.util.List;

import common.dao.Pager;
import common.dto.Board;

public class BoardService {
	//Field
	private BoardDao boardDao = new BoardDao();
	
	//Method
	public Board getBoard(int bno) {
		return  boardDao.selectBybno(bno);
	}
	
	public int modifyBoard(Board board) { //여기서 int는 성공여부를 나타내는데 0은 실패 1은 성공이다. /select만 void로 하는 것이 일반적이다.
		int rows = boardDao.update(board);
		return rows;
	}
	
	public List<Board> getList(Pager pager){
		
		
		
		return boardDao.selectAll(pager);
	}

	public int getTotalBoardNum() {
		
		
		return boardDao.count();
	}
	

}
