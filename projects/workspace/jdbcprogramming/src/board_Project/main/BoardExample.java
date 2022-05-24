package board_Project.main;

import java.util.List;
import java.util.Scanner;

import board_Project.common.Service.BoardService;
import board_Project.common.dto.Board;
import board_Project.common.dto.User;


public class BoardExample {

	static Scanner scanner =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run=true;
		User user = new User();
		user.setUserId(null);

		//boardList();
		//searchList();
		//writeBoard();
		updateBoard();
		//deleteBoard();
		//detailBoard();


	}

	//리스트보기 선택 시 1.전체보기. 2.자유게시판. 3.질문게시판. 4.학업게시판이 출력되고 게시판 선택시 해당 게시판에 맞는 목록들이 출력된다.
	public static void boardList() {
		System.out.println("\t\t\t게시판 선택");
		System.out.println("------------------------------------------------------");
		System.out.println("1.전체보기.    2.자유게시판.    3.질문게시판.    4.학업게시판");
		System.out.println("------------------------------------------------------");
		System.out.print("게시판 선택: ");

		String selectBoard = scanner.nextLine(); //선택 게시판을 문자열로 입력 받는다.
		int selectBno = Integer.parseInt(selectBoard); //입력 받은 번호를 정수로 변환 //BoardService의 Board getBoard(int bno)이므로

		System.out.println("------------------------------------------------------");
		System.out.println("작성자 \t\t 제목 \t\t 작성시간");
		System.out.println("------------------------------------------------------");

		BoardService boardService = new BoardService(); //board 객체 생성		
		List<Board> list = boardService.getBoard(selectBno);  //출력할 보드 리스트 가져온다.

		for(Board b : list) {
			System.out.printf(b.getBwriter() + "\t\t");
			System.out.printf(b.getBtitle() + "\t");
			System.out.printf(b.getBdate() + "\n");
		}
		System.out.println("------------------------------------------------------");
	}

	//검색 선택 시 1.닉네임 검색 2.제목 검색이 출력되고 닉네임 또는 제목 검색 시 해당 검색에 맞는 결과를 출력한다.
	public static void searchList() {
		System.out.println("\t\t\t검색 선택");
		System.out.println("------------------------------------------------------");
		System.out.println("1.닉네임 검색    2.제목 검색");
		System.out.println("------------------------------------------------------");
		System.out.print("검색 선택: ");

		String selectSearch = scanner.nextLine(); //선택 기능을 문자열로 입력 받는다.


		BoardService boardService = new BoardService(); //board 객체 생성	
		List<Board> list = boardService.getSearcjList(selectSearch); //검색된 리스트를 가져온다.

		System.out.println("------------------------------------------------------");
		System.out.println("작성자 \t\t 제목 \t\t 작성시간");
		System.out.println("------------------------------------------------------");

		for(Board b : list) {
			System.out.printf(b.getBwriter() + "\t\t");
			System.out.printf(b.getBtitle() + "\t");
			System.out.printf(b.getBdate() + "\n");
		}
		System.out.println("------------------------------------------------------");

	}

	public static void writeBoard() {

		System.out.println("\t\t\t게시판 생성");
		System.out.println("------------------------------------------------------");


		BoardService boardService = new BoardService();


		int result = boardService.writeBoard(); //현재 로그인한 사용자의 아이디 비밀번호 값을 인자값으로 사용해야한다. 합칠때 작업해야 할 emt
		if(result == 1) {
			System.out.println("------------------------------------------------------");
			System.out.println("작성 성공");
		} else {
			System.out.println("------------------------------------------------------");
			System.out.println("작성 실패");
		}
	}

	public static void updateBoard() {
		System.out.println("\t\t\t수정");
		System.out.println("------------------------------------------------------");
		System.out.print("수정 게시물 번호: ");

		String selectUpdate = scanner.nextLine(); //선택 기능을 문자열로 입력 받는다.

		BoardService boardService = new BoardService(); //board 객체 생성	

		System.out.println("------------------------------------------------------");
		int result = boardService.modifyBoard(selectUpdate); //수정할 게시판 번호 입
		if(result == 1) {
			System.out.println("------------------------------------------------------");
			System.out.println("수정 성공");
		} else {
			System.out.println("------------------------------------------------------");
			System.out.println("수정 실패");
		}

		System.out.println("------------------------------------------------------");


	}

	public static void deleteBoard() {
		System.out.println("\t\t\t삭제");
		System.out.println("------------------------------------------------------");
		System.out.print("삭제  게시물 번호: ");

		String selectDeleteStr = scanner.nextLine(); //선택 기능을 문자열로 입력 받는다.
		int selectDelete = Integer.parseInt(selectDeleteStr);

		BoardService boardService = new BoardService(); //board 객체 생성	

		System.out.println("------------------------------------------------------");
		int result = boardService.removeBoard(selectDelete); //수정할 게시판 번호 입
		if(result == 1) {
			System.out.println("------------------------------------------------------");
			System.out.println("삭제 성공");
		} else {
			System.out.println("------------------------------------------------------");
			System.out.println("삭제 실패");
		}

		System.out.println("------------------------------------------------------");

	}

	//상세보기
	public static void detailBoard() {
		System.out.println("\t\t\t상세보기");
		System.out.println("------------------------------------------------------");
		System.out.print("상세보기 게시물 번호: ");

		String selectDetailStr = scanner.nextLine(); //선택 기능을 문자열로 입력 받는다.
		int selectDetail = Integer.parseInt(selectDetailStr);

		BoardService boardService = new BoardService(); //board 객체 생성	

		List<Board> list = boardService.detailView(selectDetail); //상세보기할 게시판 번호 입

		System.out.println("------------------------------------------------------");
		System.out.println("이름 \t\t 제목 \t\t 내용 \t\t 시간 \t\t 첨부파일 \t\t 게시판");
		System.out.println("------------------------------------------------------");

		for(Board b : list) {
			System.out.printf(b.getBwriter() + "\t\t");
			System.out.printf(b.getBtitle() + "\t");
			System.out.printf(b.getBcontent() + "\t");
			System.out.printf(b.getBdate() + "\t\t");
			System.out.printf(b.getBfilename() + "\t");
			System.out.printf(b.getBcategoryid() + "\n");
		}

		System.out.println("------------------------------------------------------");

	}

}
