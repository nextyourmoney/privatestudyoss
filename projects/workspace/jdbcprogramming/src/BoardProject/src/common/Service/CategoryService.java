package common.Service;

import java.util.List;
import java.util.Scanner;

import common.dao.CategoryDao;
import common.dto.Board;
import common.paging.Pager;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();
	private Pager pager;
	private Scanner scanner;
	int totalRow = 0;
	
	public CategoryService() {
		scanner = new Scanner(System.in);
	}
	

	//카테고리 아이디로 카테고리별 리스트 가져오기
	public void getCategoryList(Pager pager, int categoryid) {

		boolean run = true;
		while (run) {
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("번호\t작성자\t제목\t시간");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");

			List<Board> list = categoryDao.selectByCategory(pager, categoryid);

			for (Board b : list) {
				System.out.print(b.getBno() + "\t");
				System.out.print(b.getBwriter() + "\t");
				System.out.print(b.getBtitle() + "\t");
				System.out.print(b.getBdate() + "\t");
				System.out.println();
			}
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
	
			System.out.print("[First]");
			System.out.print((pager.getGroupNo() >= 2)?"[Prev] " : " ");
			for(int i=pager.getStartPageNo(); i<=pager.getEndPageNo(); i++) {
				if(i == pager.getPageNo()) {
					System.out.print("(" + i + ")" + ((i != pager.getEndPageNo())?", ":""));
				} else {
					System.out.print(i + ((i != pager.getEndPageNo())?", ":""));
				}
			}
			System.out.print((pager.getGroupNo() < pager.getTotalGroupNo())?" [Next]" : " ");
			System.out.println("[Last]");
			
			System.out.print("선택: ");
			String select = scanner.nextLine();
			if (select.equals("f") || select.equals("F")) {
				pager = getFirstPage(pager);
			} else if (select.equals("p") || select.equals("P")) {
				pager = getPrevGroup(pager);
			} else if (select.equals("n") || select.equals("N")) {
				pager = getNextGroup(pager);
			} else if (select.equals("l") || select.equals("L")) {
				pager = getLast(pager);
			} else if (select.equals("q") || select.equals("Q")) {
				run = false;
			} else {
				pager = getPage(Integer.parseInt(select), pager);
			}
		}
	}

	//카테고리별 게시물 개수 가져오기
	public int getTotalCategoryBoardNum(int categoryid) {
		this.totalRow = categoryDao.count(categoryid);
		return categoryDao.count(categoryid);
	}
	
	//전체 게시물 가져오기
	public void getAllList(Pager pager) {
		boolean run = true;
		while (run) {
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("번호\t작성자\t제목\t시간");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");

			List<Board> list = categoryDao.selectAll(pager);

			for (Board b : list) {
				System.out.print(b.getBno() + "\t");
				System.out.print(b.getBwriter() + "\t");
				System.out.print(b.getBtitle() + "\t");
				System.out.print(b.getBdate() + "\t");
				System.out.println();
			}
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
	
			System.out.print("[First]");
			System.out.print((pager.getGroupNo() >= 2)?"[Prev] " : " ");
			for(int i=pager.getStartPageNo(); i<=pager.getEndPageNo(); i++) {
				if(i == pager.getPageNo()) {
					System.out.print("(" + i + ")" + ((i != pager.getEndPageNo())?", ":""));
				} else {
					System.out.print(i + ((i != pager.getEndPageNo())?", ":""));
				}
			}
			System.out.print((pager.getGroupNo() < pager.getTotalGroupNo())?" [Next]" : " ");
			System.out.println("[Last]");
			
			System.out.print("선택: ");
			String select = scanner.nextLine();
			if (select.equals("f") || select.equals("F")) {
				pager = getFirstPage(pager);
			} else if (select.equals("p") || select.equals("P")) {
				pager = getPrevGroup(pager);
			} else if (select.equals("n") || select.equals("N")) {
				pager = getNextGroup(pager);
			} else if (select.equals("l") || select.equals("L")) {
				pager = getLast(pager);
			} else if (select.equals("q") || select.equals("Q")) {
				run = false;
			} else {
				pager = getPage(Integer.parseInt(select), pager);
			}
		}
	}

	//전체 게시물 개수 가져오기
	public int getTotalBoardNum() {
		this.totalRow = categoryDao.countAll();
		return categoryDao.countAll();
	}
	
	//페이징과 관련된 함수들
	private Pager getFirstPage(Pager pager) {
		return pager = new Pager(10, 5, this.totalRow, 1);
	}

	private Pager getPrevGroup(Pager pager) {
		return pager = new Pager(10, 5, this.totalRow, pager.getStartPageNo() - 1);
	}
	private Pager getPage(int pageNo, Pager pager) {
		return pager = new Pager(10, 5, this.totalRow, pageNo);
	}
	private Pager getNextGroup(Pager pager) {
		return pager = new Pager(10, 5, this.totalRow, pager.getEndPageNo() + 1);
	}
	private Pager getLast(Pager pager) {
		return pager = new Pager(10, 5, this.totalRow, pager.getTotalPageNo());
	}

}
