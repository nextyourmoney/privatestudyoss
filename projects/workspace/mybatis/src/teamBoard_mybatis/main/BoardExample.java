package teamBoard_mybatis.main;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import teamBoard_mybatis.common.config.SqlSessionManager;
import teamBoard_mybatis.common.dao.Userdao;
import teamBoard_mybatis.common.dao.BoardDao;
import teamBoard_mybatis.common.ConnectionManager;
import teamBoard_mybatis.common.Service.InsertUser;
import teamBoard_mybatis.common.Service.UserService;
import teamBoard_mybatis.common.dto.Board;
import teamBoard_mybatis.common.dto.User;



public class BoardExample {
	static String nickName;
	static Scanner scanner =new Scanner(System.in);
	static String keyid;
	public static void main(String[] args) {
		boolean run=true;
		
		ConnectionManager.init();
		User user=new User();
		Scanner scanner=new Scanner(System.in);
	
		//자기 id, 친구 닉네임

		UserService userservice =new UserService();
		user.setUserId(null);
		user=userservice.start();//로그인
		keyid=user.getUserId(); //자기 아이디 키값
		nickName=user.getUserNickName();//자기 닉네임



		while(run) {
			try {
			
			System.out.println("1.리스트 보기   2.검색   3.게시물 작성   4.게시물 수정  5.게시물 삭제 6.로그아웃  7.종료");
			System.out.println("--------------------------------------------------------------------------------------------------");
			String choice=scanner.nextLine();
			switch(choice){

			case "1": //전체 출
				System.out.println("검색 카테고리 번호 입력 0: 전체     1:학업 게시판   2:자유 게시판   3:암튼 게시판  ");
				String num = scanner.nextLine();
				if(num.equals("0")) {
					try(SqlSession session = SqlSessionManager.getSqlSession()){
						
						BoardDao boardDao = session.getMapper(BoardDao.class);
						
						List<Board> list = session.selectList("teamBoard_mybatis.common.dao.BoardDao.selectBoardwithUser");
						
						System.out.println("글 번호     작성자        제목      시간");
						for(Board board : list) {
							System.out.print(board.getBno() + "\t");
							System.out.print(board.getBwriter() + "\t");
							System.out.print(board.getBtitle()+ "\t");
							System.out.print(board.getBdate()+ "\n");
						}
						
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				else { //카테고리 번호 별로 출
						try(SqlSession session = SqlSessionManager.getSqlSession()){
						
						BoardDao boardDao = session.getMapper(BoardDao.class);
						
						int num2 = Integer.parseInt(num);
						
						List<Board> list = session.selectList("teamBoard_mybatis.common.dao.BoardDao.selectBoardwithUser2", num2);
						
						System.out.println("글 번호     작성자        제목      시간");
						for(Board board : list) {
							System.out.print(board.getBno() + "\t");
							System.out.print(board.getBwriter() + "\t");
							System.out.print(board.getBtitle()+ "\t");
							System.out.print(board.getBdate()+ "\n");
						}
						
					} catch(Exception e) {
						e.printStackTrace();
					}
					
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
					
					//System.out.print("작성자: ");
					board.setBwriter(user.getUserNickName());

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
				deleteBoard();
				break;
			
			case "6":
				userservice.start();
				break;
			case "7":
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

	//검색 선택 시 1.닉네임 검색 2.제목 검색이 출력되고 닉네임 또는 제목 검색 시 해당 검색에 맞는 결과를 출력한다.
	 public static void searchList() {
	      System.out.println("\t\t\t검색 선택");
	      System.out.println("------------------------------------------------------");
	      System.out.println("1.닉네임 검색    2.제목 검색");
	      System.out.println("------------------------------------------------------");
	      System.out.print("검색 선택: ");

	      String selectSearch = scanner.nextLine(); //선택 기능을 문자열로 입력 받는다.


	      if(selectSearch.equals("1")) {
	      try(SqlSession session = SqlSessionManager.getSqlSession()){
				
				BoardDao boardDao = session.getMapper(BoardDao.class);
				
				String name = scanner.nextLine();
			
				List<Board> list = session.selectList("teamBoard_mybatis.common.dao.BoardDao.selectByname", name);
				
				System.out.println("작성자        제목      시간");
				for(Board board : list) {
					System.out.print(board.getBwriter() + "\t");
					System.out.print(board.getBtitle()+ "\t");
					System.out.print(board.getBdate()+ "\n");
				}
				
	      
	      } catch(Exception e) {
				e.printStackTrace();
			}
	      } else {
	    	  try(SqlSession session = SqlSessionManager.getSqlSession()){
					
					BoardDao boardDao = session.getMapper(BoardDao.class);
					
					String title = scanner.nextLine();
				
					List<Board> list = session.selectList("teamBoard_mybatis.common.dao.BoardDao.selectBytitle", title);
					
					System.out.println("작성자        제목      시간");
					for(Board board : list) {
						System.out.print(board.getBwriter() + "\t");
						System.out.print(board.getBtitle()+ "\t");
						System.out.print(board.getBdate()+ "\n");
					}
				
		      
		      } catch(Exception e) {
					e.printStackTrace();
				}
	    	  
	      }
	   }

	public static void updateBoard() throws Exception {
		System.out.println("\t\t\t수정");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.print("수정 게시물 번호: ");
		int cnt;
		String selectUpdate = scanner.nextLine(); //선택 기능을 문자열로 입력 받는다.
	
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){
			
			int bno = Integer.parseInt(selectUpdate); //수정할 번
			
			BoardDao boardDao = session.getMapper(teamBoard_mybatis.common.dao.BoardDao.class);
			Board board = boardDao.selectBoard(bno);

			System.out.print("수정 글 제목: "); 
			String uptitle = scanner.nextLine();
			board.setBtitle(uptitle);
			
			
			System.out.print("수정 내용: "); 
			String upcon = scanner.nextLine();
			board.setBcontent(upcon);
			
			System.out.println("[ 1.자유게시판.    2.질문게시판.    3.학업게시판] ");
			System.out.print("수정 게시판 카테고리: "); 
			String upid = scanner.nextLine();
			int id = Integer.parseInt(upid);
			board.setBcategoryid(id);
		    board.setBno(bno);		
			int rows = boardDao.updateBoard(board);
			System.out.print("업데이트된 행수: " + rows);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println("--------------------------------------------------------------------------------------------------");

	}
	public static void deleteBoard() throws Exception {
		System.out.println("\t\t\t삭제");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.print("삭제  게시물 번호: ");
		
		 try(SqlSession session = SqlSessionManager.getSqlSession()){
				
				BoardDao boardDao = session.getMapper(BoardDao.class);
				
				String bno_str = scanner.nextLine();
				int bno = Integer.parseInt(bno_str);
				List<Board> list = session.selectList("teamBoard_mybatis.common.dao.BoardDao.deleteBoard", bno);
				
				System.out.println("작성자 \t\t 제목 \t\t 시간");
				for(Board board : list) {
					System.out.print(board.getBwriter() + "\t");
					System.out.print(board.getBtitle()+ "\t");
					System.out.print(board.getBdate()+ "\n");
				}
			
	      
	      } catch(Exception e) {
				e.printStackTrace();
			}
		
		System.out.println("--------------------------------------------------------------------------------------------------");		
	}
}
