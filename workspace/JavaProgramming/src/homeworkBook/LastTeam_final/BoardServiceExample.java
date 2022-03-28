package homeworkBook.LastTeam_final;


public class BoardServiceExample {

	public static void main(String[] args) {//메인 메소드!
		BoardService.logIn();//프로그램 시작시에 로그인 기능 수행.
		
		while(true) {
			String selection = BoardService.showMenu();
			BoardService.readBoardList();//게시판 정보 업뎃.
			
			switch(selection) {
				case "1"://게시글 목록 보기.
					BoardService.showList();
					break;
					
				case "2"://게시글 작성.
					BoardService.writeAPost();
					break;
					
				case "3"://게시글 상세보기.
					BoardService.showDetail();
					break;
					
				case "4"://게시글 수정하기.
					BoardService.updatePost();
					BoardService.writeBoardList();//수정 후에, 게시판 정보 업뎃.
					break;
				case "5"://게시글 삭제하기.
					BoardService.deletePost();
					break;
				case "6"://프로그램 종료.
					System.exit(0);
					break;
				default:
					System.out.println("* * * * * 잘못된 메뉴선택입니다. * * * * *");
					break;
			}
		}	
		
	}

}
