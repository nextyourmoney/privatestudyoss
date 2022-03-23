package board_Project.common.Service;

import java.util.List;

import board_Project.common.dao.CategoryDao;
import board_Project.common.dto.Board;
import board_Project.common.paging.Pager;

public class CategoryService {
	private CategoryDao categoryDao= new CategoryDao();
	
	//리스트 페이징  코드 짜면서 생각해보기
		public List<Board> getList(Pager pager,int i) {

			return categoryDao.selectByList(pager);
		}
		//페이징 할때 쓰는 메소드
		public int getTotalBoardNum() {
			
			return categoryDao.count();
		}

}
