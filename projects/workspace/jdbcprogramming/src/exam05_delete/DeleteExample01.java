package exam05_delete;

import java.util.List;
import java.util.Scanner;

import common.dao.ConnectionManager;
import common.dao.Pager;
import common.dto.Board;

public class DeleteExample01 {

	public static void main(String[] args) {
		ConnectionManager.init();
		
		Scanner scanner = new Scanner(System.in);
		BoardService boardService = new BoardService();
		
		
		//게시물 목록 가져오기
		Pager pager = new Pager(10, 5, boardService.getTotalBoardNum(), 1);
		List<Board> list = boardService.getList(pager);
		for(Board b : list) {
			System.out.println(b);
		}
		
		System.out.println("_-----------");
		System.out.println("사겢할 번호");
		
		int bno = Integer.parseInt(scanner.nextLine());
		boardService.removeBoard(bno);
		
		pager = new Pager(10, 5, boardService.getTotalBoardNum(), 1);
		list = boardService.getList(pager);
		for(Board b : list) {
			System.out.print(b);
		}
		

	}

}
