package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import dto.Board;
import dto.Pager;

@Mapper //마이바티스에서 관리하는 맵퍼라는 것을 선언한다.
public interface BoardDao {
	public Board selectBoard(int i);

	public List<Board> selectAll();

	public int insertBoard(Board board);
	
	public int selectTotalRowCount();
	
	public List<Board> selectPage(Pager pager);
	
	public Board selectBoardwithUser(int bno);
	
	public Board selectBoardwithUser2(int bno);
	
	public int updateBoard(Board board);

	public int deleteBoard(int bno);
	
	

	
	

}
