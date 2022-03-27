package teamBoard_mybatis.common.Service;

import java.util.List;
import java.util.Scanner;

import teamBoard_mybatis.common.dao.CategoryDao;
import teamBoard_mybatis.common.dao.BoardDao;
import teamBoard_mybatis.common.dto.Board;


public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();

	private Scanner scanner;
	int totalRow = 0;
	
	public CategoryService() {
		scanner = new Scanner(System.in);
	}
	

	//카테고리별 게시물 개수 가져오기
	public int getTotalCategoryBoardNum(int categoryid) throws Exception {
		this.totalRow = categoryDao.count(categoryid);
		return categoryDao.count(categoryid);
	}
	

	//전체 게시물 개수 가져오기
	public int getTotalBoardNum() throws Exception {
		this.totalRow = categoryDao.countAll();
		return categoryDao.countAll();
	}
	

}
