package exam04_update;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import common.dao.ConnectionManager;
import common.dao.Pager;
import common.dto.Board;

public class UpdateExample12 {

	public static void main(String[] args) {
	ConnectionManager.init();
	
	BoardService boardService = new BoardService();
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("게시물 번호");
	int bno = Integer.parseInt(scanner.nextLine());
	
	//게시물 가져오기
	System.out.println("------------------------");
	Board board = boardService.getBoard(bno);
	System.out.println("btitle: " + board.getBtitle());
	System.out.println("bcontetnt: " + board.getBcontent());
	System.out.println("bfilename: " + board.getBfilename());
	
	//게시물 수정하기
	System.out.println("---------수정---------------");
	System.out.println("btitle: ");
	String btitle = scanner.nextLine();
	if(!btitle.equals("")) board.setBtitle(btitle);
	
	System.out.println("bcontent ");
	String bcontent = scanner.nextLine();
	if(!bcontent.equals("")) board.setBcontent(bcontent);
	
	System.out.println("bfilepaht: ");
	String bfilepaht = scanner.nextLine();
	if(!bfilepaht.equals("")) board.setBfilepaht(bfilepaht);
	
	boardService.modifyBoard(board);
	
	System.out.println("------------------------");
	board = boardService.getBoard(bno);
	System.out.println("bno: " + board.getBno());
	System.out.println("bcontent: " + board.getBcontent());
	System.out.println("bfilephat: " + board.getBfilepaht());
	System.out.println("bwriter: " + board.getBwriter());
	System.out.println("bdate: " + board.getBdate());
	System.out.println("bfilename: " + board.getBfilename());
	
	Pager pager = new Pager(10, 5, boardService.getTotalBoardNum(), 1);
	List<Board> list = boardService.getList(pager);
	for(Board b : list) {
		System.out.println(b);
	}

	}

}
