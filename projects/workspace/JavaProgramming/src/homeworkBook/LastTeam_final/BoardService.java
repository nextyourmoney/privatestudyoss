package homeworkBook.LastTeam_final;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BoardService implements Serializable{
	static FileInputStream fis;
	static ObjectInputStream ois;
	static FileOutputStream fos;
	static ObjectOutputStream oos;
	static BufferedInputStream bis;
	static BufferedOutputStream bos;
	static Reader reader;
	static BufferedReader br;
//	final static String PARENT_DIR_PATH = "/Users/choisukhee/Documents/2022/오스템 임플란트/BoardCRUD";
	final static File PARENT_DIR_PATH = new File("./BoardCRUD");
	static File memberFile = new File(PARENT_DIR_PATH + "/member.db");
	static File boardFile = new File(PARENT_DIR_PATH + "/board.db");
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
	
	static Map<String, String> memberMap = new HashMap<>();//memberMap은 1개만 생성. 인스턴스별로 생성X.
	static List<Board> boardList = new ArrayList<>();//중간 위치의 수정 삭제가 많을 것이지만, 빠른 탐색과 정렬을 위해 ArrayList사용.
	
	static Scanner sc = new Scanner(System.in);
	static String line = "-------------------------------------------------------------------------------------------------";
	static String line2 = "*-----------------------*-----------------------*-----------------------*-----------------------*";
	static String line3 = "=================================================================================================";
	static String menu = "\t| 1. 목록 보기 | 2. 게시글 작성 | 3. 상세보기 | 4. 게시글 수정 | 5. 게시글 삭제 | 6. 종료 |";
	
	static int postNum;//게시물 번호.
	
	private static Member currentLoggedInUser;//현재 로그인한 유저의 id,password.
//	"5": 게시글 삭제
	static void deletePost() {//"5"선택시에, 게시글 삭제(첨부파일 담긴 게시글 번호가 이름인 폴더 포함.)
		System.out.print(">>> 삭제할 게시물 번호: ");
		String strDeletePostNum = sc.nextLine().trim();
		if(strDeletePostNum == null) {
			System.out.println("* * * * * 잘못된 게시물 번호입니다. * * * * *");
			System.out.println("* * * * * 메뉴로 돌아갑니다. * * * * *");
			return;
		}
		int intDeletePostNum = 0;
		try {//정수로 변환할 수 없는 입력을 처리.(메뉴로 돌아가기)
			intDeletePostNum = Integer.parseInt(strDeletePostNum);			
		} catch(Exception e) {
			System.out.println("* * * * * 잘못된 게시물 번호입니다. * * * * *");
			System.out.println("* * * * * 메뉴로 돌아갑니다. * * * * *");
			return;			
		}
		//작성자와 로그인 유저id가 일치하는지 확인.
		for(int i=0; i<boardList.size(); i++) {//동등비교.(메소드 재정의말고,String객체임을 이용.
			System.out.println(boardList.size());//게시글 없을 때, 리스트 길이.
			//입력받은 삭제할 게시글의 번호(intDeletePostNum)가, 게시글 목록에 없는 번호일 경우.
			if( i == (boardList.size()-1)
					&& ( (int) boardList.get(i).getBno() != intDeletePostNum) ) {
				System.out.println("* * * * * " + intDeletePostNum + "번 게시물을 찾을 수 없습니다. * * * * *");
				return;
			}
			
			if(boardList.get(i).getWriter().toString().equals(currentLoggedInUser.getUserId().toString())) {
				//게시글의 번호가 일치하는 게시물의 작성자가 로그인한 유저라면, 패스원드 점검하고, 수정 진행.
				System.out.print("비밀번호: ");
				String inputPassword = sc.nextLine().trim();
				if(currentLoggedInUser.getPassword().equals(inputPassword)) {
					//boardList에서 원소 삭제하기.
					boardList.remove(i);
					//유저id/게시글 번호 폴더 포함 하위 모두 삭제.
					File postDir = new File(PARENT_DIR_PATH + "/" + currentLoggedInUser.getUserId() + "/"
									+ intDeletePostNum);//유저id/게시글번호 폴더 객체.
					if(postDir.exists()) {//파일 존재여부 확인.
						File[] files = postDir.listFiles();
						for(int j=0; j<files.length; j++) {
							if(files[j].delete()) {//하위 파일 모두 삭제.
								System.out.println("* * * * *" + intDeletePostNum + "번 게시물 삭제 성공! * * * * *");
							} else {
								System.out.println("* * * * * 파일 삭제 실패로 인해 게시글이 삭제되지 않음. * * * * *");
								return;//메소드 종료
							}
						}
						postDir.delete();
					}
					//read/write boardList()로 boardList업뎃.
					writeBoardList(); readBoardList();
					break;
				}
				System.out.println("* * * * * 비밀번호가 일치하지 않습니다. * * * * *");
				return;//메소드 종료. 메뉴보기.
			} else {//다른 유저의 게시글을 수정하려 했다면, 불가 안내문구 출력하고, 메소드 종료.
				System.out.println("* * * * * 자신이 작성한 게시글만 삭제할 수 있습니다. * * * * *");
				return;//메소드 종료. 메뉴보기.
			}
		}
		
	}
//	"4": 게시글 수정
	//시간되면 while()문 안에 두는 걸로 바꾸기/////////////////////// 
	static void updatePost() {//"4"선택시에, 게시글 수정.(제목/내용 수정 | 첨부파일 삭제/추가).
		//본인 글만 수정 가능. 비밀번호 입력받아서 점검.
		System.out.print(">>> 수정할 게시글 번호: ");
		String strBno = sc.nextLine().trim();
		if(strBno == null) {//입력값이 null일 때.
			System.out.println("* * * * * 잘못된 게시물 번호입니다. * * * * *");
			System.out.println("* * * * * 메뉴로 돌아갑니다. * * * * *");
			return;
		}
		int intBno = 0;
		try {//정수로 변환할 수 없는 입력을 처리.(메뉴로 돌아가기) ex.문자.
			intBno = Integer.parseInt(strBno);
		} catch(Exception e) {
			System.out.println("* * * * * 잘못된 게시물 번호입니다. * * * * *");
			System.out.println("* * * * * 메뉴로 돌아갑니다. * * * * *");
			return;			
		}
		for(int i=0; i<boardList.size(); i++) {//동등비교.(메소드 재정의말고,String 객체임을 이용.
			//입력받은 수정할 게시글의 번호(intBno)가, 게시글 목록에 없는 번호일 경우.
			if( i == (boardList.size()-1)
					&& ( (int) boardList.get(i).getBno() != intBno ) ) {
				System.out.println("* * * * * " + intBno + "번 게시물을 찾을 수 없습니다. * * * * *");
				return;
			}
			if((int)boardList.get(i).getBno() ==  (int)intBno ) {
				//현재 id가 작성자와 일치하지 않는지 여부 확
				if(boardList.get(i).getWriter().equals(currentLoggedInUser.getUserId())) {
					//게시글의 번호가 일치하는 게시물의 작성자가 로그인한 유저라면, 패스워드 점검하고, 수정 진행.
					System.out.print("비밀번호: ");
					String inputPassword = sc.nextLine().trim();
					if(currentLoggedInUser.getPassword().equals(inputPassword)) {
						break;
					} else {
						System.out.println("* * * * * 비밀번호가 일치하지 않습니다. * * * * *");
						return;//메소드 종료. 메뉴보기.											
					}
				} else {//다른 유저의 게시글을 수정하려 했다면, 불가 안내문구 출력하고, 메소드 종료.
					System.out.println("* * * * * 자신이 작성한 게시글만 수정할 수 있습니다. * * * * *");
					return;//메소드 종료. 메뉴보기.					
				}
			}
		}
		
		//수정기능.
		Date now = new Date();
		System.out.println("1. 제목 수정 | 2. 내용 수정 | 3. 첨부파일 추가 | 4. 첨부파일 삭제");
		System.out.print(">>> 기능 선택: ");
		String selection = sc.nextLine().trim();
		if(selection.equals("1")) {//제목 수정.
			System.out.print(">>> 새로운 제목: ");
			String newTitle = sc.nextLine();
			for(Board board : boardList) {
				if(board.getBno() == intBno) {
					board.setTitle(newTitle);//제목 변경.
					now = new Date();
					board.setPostingDate(sdf.format(now));//수정일 없뎃.
					writeBoardList(); readBoardList();//수정사항 업뎃.
					break;
				}
			}
		} else if(selection.equals("2")) {//내용 수정.
			System.out.print(">>> 새로운 내용: ");
			String newContent = sc.nextLine();
			for(Board board : boardList) {
				if(board.getBno() == intBno) {
					board.setContent(newContent);//내용 변경.
					now = new Date();
					board.setPostingDate(sdf.format(now));//수정일 없뎃.
					writeBoardList(); readBoardList();//수정사항 업뎃.
					break;
				}
			}
			
		} else if(selection.equals("3")) {//첨부파일 추가.
			//첨부파일 개수 확인.
			File currentPostDir = new File( PARENT_DIR_PATH + "/" + currentLoggedInUser.getUserId() + "/" + intBno );
//			String[] currentBoardAttachment = currentUserDir.list();
			int currentPostAttachmentNum = 0;
			if(currentPostDir.exists()) {//기존에 첨부파일 있는 게시글에 첨부파일 추가.
				File[] currentPostAttachment = currentPostDir.listFiles();/////null처리!!
				currentPostAttachmentNum = currentPostAttachment.length;
			} else {//기존에 첨부파일이 없던 게시글에 첨부파일 추가하기.
				
			}
			if(currentPostAttachmentNum < 3) {//추가 가능.
				System.out.print(">>> 첨부할 파일 경로: ");
				String srcFilePath = sc.nextLine().trim();
				File srcFile = new File(srcFilePath);
				//첨부파일 없던 게시글에 추가하는 경우 대비.
				new File(PARENT_DIR_PATH + "/" + currentLoggedInUser.getUserId() + "/" + intBno).mkdirs();
				String targetPath = PARENT_DIR_PATH + "/" + currentLoggedInUser.getUserId()
									+ "/" + intBno + "/" + srcFile.getName();
				if(srcFile.exists()) {
					boolean successedAttach = attachFile(srcFile, targetPath);	
					if(successedAttach) {
						for(Board board : boardList) {
							if(board.getBno() == intBno) {
								now = new Date();
								board.setPostingDate(sdf.format(now));//수정일 없뎃.								
							}
						}
						System.out.println("* * * * * 파일 첨부 성공! * * * * *");
					} else {
						System.out.println("* * * * * 파일 첨부 실패... * * * * *");						
					}
				} else {
					System.out.println("* * * * * 해당 파일을 찾을 수 없습니다. * * * * *");
				}
			} else {//추가 불가능.
				System.out.println("* * * * * 더이상 파일을 첨부할 수 없습니다. * * * * *");
				return;//메뉴로 돌아가기.
			}
		} else if(selection.equals("4")) {
			System.out.print(">>> 삭제할 첨부파일명(확장자 포함): ");
			String deleteFileName = sc.nextLine().trim();
			File deleteFile = new File(PARENT_DIR_PATH + "/" + currentLoggedInUser.getUserId()
						+"/" + intBno + "/" + deleteFileName);
			File[] currentPostAttachment = new File(PARENT_DIR_PATH + "/" + currentLoggedInUser.getUserId() +"/" + intBno).listFiles();
			int currentPostAttachmentNum = currentPostAttachment.length;
			
			boolean result = deleteFile.delete();
			boolean result2 = true;
			if(currentPostAttachmentNum == 0) {
				result2 = new File(PARENT_DIR_PATH + "/" + currentLoggedInUser.getUserId() +"/" + intBno).delete();//게시글 번호 폴더 삭제.				
			}
			//첨부파일 개수세기.
			if(result == true && result2 == true) {
				//마지막 수정일 업뎃.
				for(Board board : boardList) {
					if(board.getBno() == intBno) {
						now = new Date();
						board.setPostingDate(sdf.format(now));//수정일 없뎃.								
					}
				}
				System.out.println("* * * * * 첨부파일 삭제 성공! * * * * *");

			} else {
				System.out.println("* * * * * 첨부파일 삭제 실패... * * * * *");				
			}
		} else {
			System.out.println("* * * * * 올바르지 않은 입력입니다. * * * * *");
			//메뉴로 이동.
		}
		
	}
	
//	"3": 상세 보기
	static void showDetail() {//"3"선택시에, 게시글 상세정보 출력.
		System.out.print(">>> 게시글 번호: ");
		String strBno = sc.nextLine().trim();
		
		if(strBno == null) { //공백 입력
			System.out.println("* * * * * 잘못된 게시물 번호입니다. * * * * *");
			System.out.println("* * * * * 메뉴로 돌아갑니다. * * * * *");
			return;
		}
		int intBno = 0;
		try {//정수로 변환할 수 없는 입력을 처리.(메뉴로 돌아가기)
			intBno = Integer.parseInt(strBno);			
		} catch(Exception e) { //에러 발생시 
			System.out.println("* * * * * 잘못된 게시물 번호입니다. * * * * *");
			System.out.println("* * * * * 메뉴로 돌아갑니다. * * * * *");
			return;			
		}
		System.out.println("번호\t\t제 목\t\t작성자\t\t\t마지막 수정일\t\t첨부파일 유무");
		System.out.println(line2); //UI
		
		for(int i=0; i<boardList.size(); i++) {
			//입력받은 수정할 게시글의 번호(intBno)가, 게시글 목록에 없는 번호일 경우.
			//끝까지 탐색했음에도 입력한 정수가 없는 경우 찾을 수 없음을 나타낸다.
			if( i == (boardList.size()-1)
					&& ( (int) boardList.get(i).getBno() != intBno) ) {
				System.out.println("* * * * * " + intBno + "번 게시물을 찾을 수 없습니다. * * * * *");
				return;
			}
			
			if(boardList.get(i).getBno() == intBno) { //게시물의 번호가 존재할 경우
				File boardDir = new File(PARENT_DIR_PATH + "/" + boardList.get(i).getWriter() + "/" + boardList.get(i).getBno()); //게시물의 번호로 이루어진 폴더 check
				
				if(boardDir.exists()) {//첨부파일 있는 경우(유저 폴더/게시글 폴더 있음) //첨부파일 존재 여부 확
					System.out.println(boardList.get(i).getBno() + "\t\t" + boardList.get(i).getTitle() + "\t\t"
//							+ boardList.get(i).getWriter() + "\t\t" + sdf.format(new Date(boardDir.lastModified())) + "\t\t"
							+ boardList.get(i).getWriter() + "\t\t" + boardList.get(i).getPostingDate() + "\t\t"
							+ "O"); //게시글 번호와 제목, 작성자, 수정일, 첨부파일 등 여부 확
					System.out.println("[내 용]");
					System.out.println(boardList.get(i).getContent()); //getContent로 저장된 게시글의 내용 출력
					System.out.println(line2);//줄 출력 ui
					
					String[] attachedFileList = boardDir.list();//하위 파일(폴더는 없음)들 이름들을 담은 문자열 배열. //즉 첨부파일의 이름들을 리스트로 받아와 배열에 삽입한다.
					System.out.println("[첨부파일]");
					
					for(int j = attachedFileList.length-1; j>=0; j--) { //첨부파일들이 들어있는 배열의 전체를 출력한다.
						System.out.println((j+1) + ". " + attachedFileList[j]);						
					}
				} else {//첨부파일 없는 경우(유저 폴더/게시글 폴더 없음)
					System.out.println(boardList.get(i).getBno() + "\t\t" + boardList.get(i).getTitle() + "\t\t"
							+ boardList.get(i).getWriter() + "\t\t" + boardList.get(i).getPostingDate() + "\t\t"
							+ "X"); //게시물 번호와 제목, 작성자, 수정일, 첨부파일 여부 출력 단 첨부파일 여부는 
					System.out.println("[내 용]");
					System.out.println(boardList.get(i).getContent()); //게시물 정보가 포함되어있는 boardList의 getContetn에서 내용을 출력한다.
					System.out.println(line2);
				}
				break;
			}
		}
	}
	
//	파일 첨부
	static boolean attachFile(File srcFile, String targetFilePath) {//PARENT_DIR_PATH + "/" + 
		try {//문자파일, 바이너리 파일, 기ㅏ 파일(저장불가) 구분하기.
			//게시글 번호의 폴더가 존재하는 것 확인하고, 파일 복사 진행.
			//문자파일도 바이트 기반 스트림으로 입출력 가능하네..?
			fis = new FileInputStream(srcFile);
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream(targetFilePath);
			bos = new BufferedOutputStream(fos);
			while(true) {
				int data = bis.read();
				if(data == -1) break;
				bos.write(data);
			}
			bos.flush(); bos.close();
			return true;
		} catch (Exception e) {}
		return false;
	}
	
//	2 : 게시글 작성
	static void writeAPost() {//"2"
		try {
			System.out.print(">>> 제 목: ");	
			String title = sc.nextLine();
			System.out.print(">>> 내 용: ");	
			String content = sc.nextLine();
			
			int fileNums = 0;//게시글에 첨부된 파일의 개수. //기본 0개 시작
			while(true) {//게시글당 3개까지 첨부가능.
				System.out.println("@ @ @ @ @ 파일을 첨부하시겠습니까?(3개까지 가능) @ @ @ @ @");
				System.out.print(">>> 첨부(y): ");
				String whetherAttach = sc.nextLine();
				
				if(whetherAttach.equalsIgnoreCase("y")) {//파일 첨부 진행.
					if(fileNums>2) {//파일 첨부 가능 개수 초과.
						System.out.println("* * * * * 파일은 3개까지만 첨부 가능합니다. * * * * *");
						System.out.println("* * * * * 3개의 파일과 함께 게시글을 작성합니다. * * * * *");
						break;
					} else {//파일첨부 진행. //최대 개수인 3개보다 적을 때
						System.out.print(">>> 첨부할 파일 경로: ");
						String srcFilePath = sc.nextLine().trim(); //파일 경로 변수명
						File srcFile = new File(srcFilePath); //파일
						
						if(srcFile.exists()) {//로컬상에서 실험할것이므로 로컬에 해당 파일 존재하는지 확인.
							String fileExtension = srcFile.getName().substring( srcFile.getName().lastIndexOf(".")+1 );//파일의 확장자명 얻기.
							String targetFilePath = PARENT_DIR_PATH + "/" + currentLoggedInUser.getUserId()
							+ "/" + (postNum+1) + "/" + srcFile.getName();//파일이 저장될 경로.다수의 첨부파일을 추가한다면, 이미 폴더가 만들어져 있을 것.
							
							if( new File(PARENT_DIR_PATH + "/" + currentLoggedInUser.getUserId()
								+ "/" + (postNum+1)).exists() ) {
								//게시글 번호의 폴더가 존재하면, 바로 파일 복사하기. //원본 파일에서 복사하여 폴더에 삽입한다.
							} else {//폴더 없으면 만들고, 파일 복사.
								new File(PARENT_DIR_PATH + "/" + currentLoggedInUser.getUserId()
								+ "/" + (postNum+1)).mkdirs();//게시글 번호의 폴더 생성.
							}
							
							//파일 확장자 점검.
							if( fileExtension.equalsIgnoreCase("txt") || fileExtension.equalsIgnoreCase("docx")
									|| fileExtension.equalsIgnoreCase("hwp") || fileExtension.equalsIgnoreCase("rtf")
									|| fileExtension.equalsIgnoreCase("png") || fileExtension.equalsIgnoreCase("jpg")
									|| fileExtension.equalsIgnoreCase("jpeg") || fileExtension.equalsIgnoreCase("ppt")
									|| fileExtension.equalsIgnoreCase("pptx")) {
								boolean result = attachFile(srcFile, targetFilePath); //true, false를 통해 성공여부 출
								if(result) {
									fileNums++;//파일 첨부 성공하면, 첨부파일 개수 증가시키기.
									System.out.println("* * * * * 첨부파일 저장 성공! * * * * *");
								} else {
									System.out.println("* * * * * 첨부파일 저장 실패... * * * * *");
								}
							} else {
								//위의 확장자가 아닌 파일들은 다음 문구를 출력한다.
								System.out.println("* * * * * " + fileExtension + " 파일은 첨부할 수 없습니다. * * * * *");
								//하단의 else문으로 가서, 게시글 작성 취소할지 여부 물어야함.
							}
						} else {//첨부할 파일이 없는 경우. 혹은 저장할 수 없는 확장자를 가진 경우.
							System.out.println("* * * * * 해당 파일을 찾을 수 없습니다. * * * * *");
							System.out.println("파일 미첨부 글작성(n) | 글작성 취소(아무거나 입력.)");
							System.out.print(">>> 입력: ");
							String attachOrNot = sc.nextLine().trim();
							
							if(attachOrNot.equalsIgnoreCase("n")) { //n이 아닌 다른 것들이라면 반
							} else {//글 작성을 취소하고, 메뉴로 돌아가기.
								System.out.println("* * * * * 글작성이 취소되었습니다. * * * * *");
							}
						}	
					}
				} else {//파일 첨부X 혹은 파일 첨부 멈추기.
					Date now = new Date();
					String postingDate = sdf.format(now);
					
					//위의 입력한 내용들을 add로 추가한다.
					boardList.add(new Board(++postNum, title, currentLoggedInUser.getUserId(), content, postingDate));//bno, title, writer, content, postingDate
					System.out.println("* * * * * 게시글 작성 성공! * * * * *");
					writeBoardList(); readBoardList();//추가한 게시글 내용을 board.db에 반영.
					return;//하단으로 내려가지 말고! 게시물 작성일 따로 적고, boardList에 게시물추가하고,board.db 업뎃.
				}
			}
			
		//입력을 무사히 받았으므로, boardList에 추가.
		//게시글 번호 1칸씩 올려가며, bno로 저장.
		//글작성이 취소 되었을 때 저장되는 항목이다. 
		Date now = new Date();
		String postingDate = sdf.format(now);
//		boardList.add(new Board(++postNum, title, currentLoggedInUser.getUserId(), content));//bno, title, writer, content
		
		boardList.add(new Board(++postNum, title, currentLoggedInUser.getUserId(), content, postingDate));//bno, title, writer, content
		writeBoardList(); readBoardList();//추가한 게시글 내용을 board.db에 반영.
		System.out.println("* * * * * 게시글 작성 성공! * * * * *");
		} catch(Exception e) {}
	}

//********************시간되면, readFile(), writeFile() 로 메소드 개수 줄이기!(제네릭 타입으로 만들기!!!)
// board.db 파일에서 불러온 객체를 boardList에 대입.(게시판 상황 업뎃)
	static void readBoardList() {//boardList를 파일에서 불러오기.
			try {
				if(boardFile.exists()) {//게시판 내용인 boardList를 담은 파일이 존재하면, 읽어온다.
				fis = new FileInputStream(boardFile);
				ois = new ObjectInputStream(fis);
				boardList = (List<Board>) ois.readObject();
					if(boardList.size()>0) {//1개라도 저장된 board객체가 있으면, 마지막으로 작성된 글번호를 글번호에 대입.
						postNum = boardList.get(boardList.size()-1).getBno();//마지막으로 작성된 글번호를 가져오기.
					} else {//저장된 Board객체가 없다면, postNum=0인 상태 그대로 두기.
						
					}
				} else {//없는 파일은,게시글이 생기면 writeBoardList()에서 생성.
//					System.out.println("* * * * * 작성된 게시글이 없습니다. * * * * *");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
//	board.db 파일에 boardList 입력.(게시글 정보 모음)
	static void writeBoardList() {//boardList를 파일에 저장.
		try {
			if(boardFile.exists()) {//boardList담은 파일 존재여부 확인.
				//if문 밖으로 가서 파일에 boardList 적기.
			} else {//경로상 필요한 폴더/파일들 만들고, if문 밖으로 가서 파일에 boardList 적기.
				PARENT_DIR_PATH.mkdirs();
				memberFile.createNewFile();
			}
			fos = new FileOutputStream(boardFile);//getPath()???
			oos = new ObjectOutputStream(fos);
			oos.writeObject(boardList);//boardList를 객체로 저장.
			oos.flush(); oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	member.db 파일에서 출력한 객체를 memberList에 대입.(회원정보 불러오기)
	static void readMemberFile() {
		try {
			if(memberFile.exists()) {//파일이 있으면,member보관용 파일에서 데이터를 읽어서 memberMap으로 강제타입변환.
				fis = new FileInputStream(memberFile); //멤버 읽어오기 
				ois = new ObjectInputStream(fis); //
				memberMap = (Map<String, String>) ois.readObject();
			} else {//파일이 없으면 등록된 회원이 없다는 뜻이므로, 회원가입 하라는 안내문구 출력.
				System.out.println("* * * * * 첫 회원이 되어보세요. * * * * *");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
// member.db 파일에 memberList 입력.(회원정보 업뎃)
	static void writeMemberFile() {//member정보가 적힌 파일 불러오기.
		try {
			if(memberFile.exists()) {//member정보 담은 파일 존재여부 확인.
				//바로 if문 밖으로 가서 파일에 member정보 저장.
			} else {//프로그램 최초 실행 혹은 파일 삭제시, 파일부터 다시 만들고, member정보 저장.
				PARENT_DIR_PATH.mkdirs();
				memberFile.createNewFile();//경로상에서 필요한 파일들 먼저 생성.
			}
			fos = new FileOutputStream(memberFile);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(memberMap);//memberMap을 객체로 저장.
			oos.flush(); oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	"1": 목록 보기
	static void showList() {//"1"선택시에, 게시글 목록을 보여줌.
		readBoardList();//게시글 정보가 담긴 파일 읽어오기.
		if(boardList.size() == 0) {//아직 board.db가 비어있는 경우.
			return;
		}
		//게시글 역순으로 정렬.
		System.out.println("번호\t\t제 목\t\t\t작성자\t\t마지막 수정일\t\t첨부파일 유무");//0 1 2 =>3개.
		for(int i=(boardList.size()-1); i>=0; i--) {
			Board tempBoard = boardList.get(i);
			File boardDir = new File(PARENT_DIR_PATH + "/" + tempBoard.getWriter() + "/" + tempBoard.getBno());
			if(boardDir.exists()) {//첨부파일 있는 경우(유저 폴더/게시글 폴더 있음)
				System.out.println(tempBoard.getBno() + "\t\t" + tempBoard.getTitle() + "\t\t"
//						+ tempBoard.getWriter() + "\t\t" + sdf.format(new Date(boardDir.lastModified())) + "\t\t"
						+ tempBoard.getWriter() + "\t\t" + tempBoard.getPostingDate() + "\t\t"
						+ "O");		
			} else {//첨부파일 없는 경우(유저 폴더/게시글 폴더 없음)
				System.out.println(tempBoard.getBno() + "\t\t" + tempBoard.getTitle() + "\t\t"
						+ tempBoard.getWriter() + "\t\t" + tempBoard.getPostingDate() + "\t\t"
						+ "X");
			}
		}
	}
	
//	메뉴 보기
	static String showMenu() {//메뉴란 출력.
		System.out.println(line3);
		System.out.println(menu);
		System.out.println(line);
		System.out.print(">>> 기능 선택: ");
		String selection = sc.nextLine().trim();
		System.out.println(line);
		System.out.println(line);
		
		return selection;//선택한 메뉴 리턴.
	}
	
//	로그인
	static void logIn() {//프로그램 시작하자마자 로그인 기능 수행.
		readMemberFile();//로그인 전에, member정보 파일 읽어서 memberMap 업뎃해두기.
		System.out.println("* * * * * 회원가입 : Enter * * * * *");
		System.out.print(">>> 아이디: ");
		String idForLogin = sc.nextLine().trim();
		
		if(idForLogin.equals("")) {//회원가입 진행.
			while(true) {
				System.out.println("[회원 가입]");
				System.out.print(">>> 아이디(공백불가): ");//아이디는 고유해야함.
				String newId = sc.nextLine().trim();
				
				if(memberMap.get(newId) != null) {//중복 아이디 있으므로 새로운 아이디 입력받기.
					System.out.println("* * * * * 해당 아이디는 이미 존재합니다. * * * * *");	
				} else {//비번 설정하고 탈출.
					System.out.print(">>> 비밀번호(공백불가): ");
					String newPassword = sc.nextLine().trim();
					memberMap.put(newId, newPassword);//memberMap에 아이디와 비번 저장.
					writeMemberFile();//로그인용 회원정보 파일 새로쓰기.
					currentLoggedInUser = new Member(newId, newPassword);//앞으로 작성자, 파일저장경로 등에 사용 위해 member객체에 로그인 정보 저장.
					break;
				}
			}
		} else {//회원이므로, 로그인 절차 계속 수행.
			while(true) {
				System.out.print(">>> 비밀번호: ");
				String passwordForLogin = sc.nextLine().trim();
				if(memberMap.get(idForLogin) == null) {
					System.out.println("* * * * * 회원이 아닙니다. 회원가입을 진행해주세요. * * * * *");
					logIn();
					break;
				}
				
				if(memberMap.get(idForLogin).equals(passwordForLogin)) {//패스워트 일치여부 확인.
					System.out.println("* * * * * 로그인 성공! * * * * *");
					currentLoggedInUser = new Member(idForLogin, passwordForLogin);//앞으로 작성자, 파일저장경로 등에 사용 위해 member객체에 로그인 정보 저장.
					break;
				} else {//패스워드 불일치.
					System.out.println("* * * * * 비밀번호가 일치하지 않습니다. * * * * *");
					System.out.println("@ @ @ @ @ 로그인 계속 시도(y) | 종료(아무거나 입력) @ @ @ @ @");
					System.out.print(">>> 입력: ");
					String loginOrShowMenu = sc.nextLine();
					
					if( loginOrShowMenu.equalsIgnoreCase("y") ) {
						continue;//로그인 계속 시도.
					} else {//메뉴란으로 돌아가기.여기서 프로그램 종료 혹은 새로운 아이디로 로그인도 가능.
						System.out.println("* * * * * 프로그램을 종료 합니다. * * * * *");
						System.exit(0);
						break;
					}
				}
			}
		}			
	}

}
