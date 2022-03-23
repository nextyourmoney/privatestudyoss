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

public class ListExample01 {

	public static void main(String[] args) {
	ConnectionManager.init();
	
	BoardService boardService = new BoardService();
	
	
	
	Pager pager = new Pager(10, 5, boardService.getTotalBoardNum(), 1);
	List<Board> list = boardService.getList(pager);
	for(Board b : list) {
		System.out.println(b);
	}

	}

}
