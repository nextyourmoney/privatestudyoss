package homeWork_board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import homeWork_board.*;
import exam02_select.ConnectionManager;


public class SelectExample10 {
	static List<Employee> list;

	public static void main(String[] args) {
		boolean onOff = true;
		
		ConnectionManager.init();
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		
		while(onOff) {
			System.out.print("기능: "); //검색 키워드
			
			String choseFunction = scanner.nextLine(); //기능 선택
			
			switch(choseFunction) {
			case "0":
				list = condto.connect(choseFunction);
				basicBoard.bascirBord(list); //기본 게시판 화면
				break;
				
			case "1": //부서 정보
				list = condto.connect(choseFunction);
				basicBoard.detailBoard(list); //기본 게시판 화면
				break;
				
			case "2": //부서 정보
				list = condto.connect(choseFunction);
				basicBoard.detaillocation(list); //기본 게시판 화면
				break;
				
			case "3": //부서 정보
				list = condto.connect(choseFunction);
				basicBoard.detailsalary(list); //기본 게시판 화면
				break;
			}
					
			
		}
	}

	
}
