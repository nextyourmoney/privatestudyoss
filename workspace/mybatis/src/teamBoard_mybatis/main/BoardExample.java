package teamBoard_mybatis.main;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.UserDao;
import teamBoard_mybatis.common.dao.BoardDao;
import teamBoard_mybatis.common.ConnectionManager;
import teamBoard_mybatis.common.Service.BoardService;
import teamBoard_mybatis.common.Service.CategoryService;
import teamBoard_mybatis.common.Service.FriendService;
import teamBoard_mybatis.common.Service.InsertBoards;
import teamBoard_mybatis.common.Service.InsertUser;
import teamBoard_mybatis.common.Service.UserService;
import teamBoard_mybatis.common.dto.Board;
import teamBoard_mybatis.common.dto.User;
import teamBoard_mybatis.common.paging.Pager;


public class BoardExample {
	static String nickName;
	static Scanner scanner =new Scanner(System.in);
	static String keyid;
	public static void main(String[] args) {
		boolean run=true;
		//boardList();
		//searchList();
		//writeBoard();
		ConnectionManager.init();
		Pager pager;
		User user=new User();
		Scanner scanner=new Scanner(System.in);
	
		//자기 id, 친구 닉네임

		UserService userservice =new UserService();
		CategoryService categoryService = new CategoryService();
		user.setUserId(null);
		user=userservice.start();//로그인
		keyid=user.getUserId(); //자기 아이디 키값
		nickName=user.getUserNickName();//자기 닉네임



		while(run) {
			try {
			
			
			FriendService friendService = new FriendService(keyid); 
			Pager fpager=new Pager(10,5,friendService.getTotalFriendNum(),1); //친구 리스트 페이저
			Pager bpager=new Pager(10,5,friendService.getTotalFBoardNum(),1);//친구 게시물 페이저
			System.out.println("1.리스트 보기   2.검색   3.게시물 작성   4.게시물 수정   5.게시물 상세보기   6.게시물 삭제   7.친구관리   8.로그아웃 9.종료");
			System.out.println("--------------------------------------------------------------------------------------------------");
			String choice=scanner.nextLine();
			switch(choice){

			case "1":
				boardList();
				int categoryNum=Integer.parseInt(scanner.nextLine());
				if (categoryNum == 1) {
					Pager cpager = new Pager(10,5,categoryService.getTotalBoardNum(),1);
					categoryService.getAllList(cpager);
					break;
					
				} else if (categoryNum == 2 || categoryNum == 3 || categoryNum == 4) {
					Pager cpager = new Pager(10,5,categoryService.getTotalCategoryBoardNum(categoryNum),1);
					categoryService.getCategoryList(cpager, categoryNum);
					break;
					
				} 
				break;
			case"2":
				searchList();
				break;
			case"3":
				
				
				try(SqlSession session = SqlSessionManager.getSqlSession()){
					
					Board board = new Board();
					System.out.print("제목: ");
					board.setBtitle(scanner.nextLine());
					
					System.out.print("내용: ");
					board.setBcontent(scanner.nextLine());
					
					System.out.print("작성자: ");
					board.setBwriter(board.getBwriter());

					System.out.print("게시판 카테고리: ");
					board.setBcategoryid(scanner.nextInt());
					
					
					//방법#1
					BoardDao boardDao = session.getMapper(BoardDao.class);
					int rows = boardDao.write(board);
					
					
					//방법#2
					//int rows = session.insert("dao.BoardDao.write", board);
					
					System.out.println("넣은 숫자개수: " + rows);
				
					
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case"4":
				updateBoard();
				break;
			case"5":
				detailBoard();
				break;
			case"6":
				deleteBoard();
				break;
			case"7":
				System.out.println("1.친구 추가\t2.친구 목록 보기\t3.친구삭제\t4.친구 게시물 보기");
				System.out.println("---------------------------------------------------");
				String fnum=scanner.nextLine();
				switch(fnum) {

				case"1":
					System.out.println("추가할 친구 이름 입력 : ");
					String f1=scanner.nextLine();
					friendService.addFriend(f1);
					break;
				case"2":
					friendService.showFriendList(fpager);
					break;
				case"3":
					System.out.println("삭제할 친구 이름 입력 : ");
					String f2=scanner.nextLine();
					friendService.deleteFriend(f2);
					break;
				case"4":
					friendService.showFriendBoard(bpager);
					break;


				}
				break;
			case "8":
				userservice.start();
				break;
			case "9":
				run=false;
				break;
			default:
				System.out.println("잘못된 입력입니다");
			}




			} catch (Exception e){
				System.out.println("잘못된  입력 입니다");
				
			}
		}


	}

	//리스트보기 선택 시 1.전체보기. 2.자유게시판. 3.질문게시판. 4.학업게시판이 출력되고 게시판 선택시 해당 게시판에 맞는 목록들이 출력된다.
	public static void boardList() throws Exception {
		System.out.println("\t\t\t게시판 선택");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("1.전체보기.    2.자유게시판.    3.질문게시판.    4.학업게시판");

		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.print("게시판 선택: ");


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
	      if(list.size()!=0) {
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
	   }

	public static void writeBoard() throws Exception {

		System.out.println("\t\t\t게시판 생성");
		System.out.println("--------------------------------------------------------------------------------------------------");


		BoardService boardService = new BoardService();


		int result = boardService.writeBoard(keyid); //현재 로그인한 사용자의 아이디 비밀번호 값을 인자값으로 사용해야한다. 합칠때 작업해야 할 emt
		if(result == 1) {
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("작성 성공");
		} else {
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("작성 실패");
		}
	}

	public static void updateBoard() throws Exception {
		System.out.println("\t\t\t수정");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.print("수정 게시물 번호: ");
		int cnt;
		String selectUpdate = scanner.nextLine(); //선택 기능을 문자열로 입력 받는다.

		BoardService boardService = new BoardService(); //board 객체 생성	
		cnt=boardService.check(Integer.parseInt(selectUpdate));
		if(cnt==0)return;
		System.out.println("--------------------------------------------------------------------------------------------------");
		int result = boardService.modifyBoard(selectUpdate); //수정할 게시판 번호 입
		if(result == 1) {
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("수정 성공");
		} else {
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("수정 실패");
		}

		System.out.println("--------------------------------------------------------------------------------------------------");


	}
	public static void deleteBoard() throws Exception {
		System.out.println("\t\t\t삭제");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.print("삭제  게시물 번호: ");
		
		String selectDeleteStr = scanner.nextLine(); //선택 기능을 문자열로 입력 받는다.
		int selectDelete = Integer.parseInt(selectDeleteStr);
		
		BoardService boardService = new BoardService(); //board 객체 생성	

		System.out.println("--------------------------------------------------------------------------------------------------");
		int result = boardService.removeBoard(selectDelete); //수정할 게시판 번호 입
		if(result == 1) {
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("삭제 성공");
		} else {
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("삭제 실패");
		}
		
		System.out.println("--------------------------------------------------------------------------------------------------");
		
	}
	
	//상세보기
	public static void detailBoard() throws Exception {
		System.out.println("\t\t\t상세보기");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.print("상세보기 게시물 번호: ");
		
		String selectDetailStr = scanner.nextLine(); //선택 기능을 문자열로 입력 받는다.
		int selectDetail = Integer.parseInt(selectDetailStr);
		
		if (selectDetail > 0) {
			BoardService boardService = new BoardService(); //board 객체 생성	

			List<Board> list = boardService.detailView(selectDetail); //상세보기할 게시판 번호 입력
			
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("이름 \t\t 제목 \t\t 내용 \t\t 시간 \t\t 첨부파일 \t\t 게시판");
			System.out.println("--------------------------------------------------------------------------------------------------");
			
			for(Board b : list) {
				System.out.printf(b.getBwriter() + "\t\t");
				System.out.printf(b.getBtitle() + "\t");
				System.out.printf(b.getBcontent() + "\t");
				System.out.printf(b.getBdate() + "\t\t");
				System.out.printf(b.getBfilename() + "\t");
				System.out.printf(b.getBcategoryid() + "\n");
			}
			
			System.out.println("--------------------------------------------------------------------------------------------------");
		} else if (selectDetail < 0){
			System.out.println("잘못된 입력  입니다");
		}
		
		
		
	}
	

}
