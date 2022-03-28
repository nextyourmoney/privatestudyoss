package homeworkBook.LastTeam;

import java.util.LinkedList;
import java.util.Scanner;

/*
 1. 목록보기 //글번호, 글 내용, 작성자, 작성시
 2. 상세보기
 3. 수정하기
 4. 삭제하기
 5. 파일저장
 6. 종료
 추가기능 - 내림차순 정렬, 비밀번호, 문의 목별 정리하
 */

public class BoardExample {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<String[]> postList = new LinkedList<>();
		BoardFunctionInterface BoardFunction = new BoardFunction();
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t  게시판 ");
		
		while(true) {
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("| 1.글 작성 | 2.목록보기 | 3.상세보기 | 4.수정하기 | 5.삭제하기 | 6.파일저장 | 7.종료 |");
			System.out.println("---------------------------------------------------------------------------------");
			
			System.out.print("기능 선택: ");
			String choseFunction = scanner.nextLine(); //기능 입력 //문자열로 입력
			
			try {
				int choseFunctionNum = Integer.parseInt(choseFunction); //입력한 번호 문자열을 정수로 변환 //숫자가 아닌 다른 값이 입력 되었을 떄의 에러 대
			
				switch (choseFunctionNum ) {
					case 1: //글 작성 //글 번호, 내용, 작성자, 시간, 비밀번호(0000 입력시 비밀 번호 없음) - 문자 사용 불가 4자리 숫자

						BoardFunction.createPost(postList);

						break;
					
					case 2: //목록 보기 //내림차순 정렬
						BoardFunction.listPost(postList);
						break;
						
					case 3: //상세보기 //비밀번호가 있을 시 비밀번호 입력해야 볼 수 있도록
						BoardFunction.detailPost(postList);
						break;
						
					case 4: // 수정하기 //비밀번호가 있을 시 비밀번호 입력해야 수정 할 수있다.  또한 비밀번호포함여 전부 수정가능
						BoardFunction.correctionPost(postList);
						break;
						
					case 5: //삭제하기 //비밀번호가 있을 시 비밀번호 입력해야 삭제 할 수 있다.
						BoardFunction.deletePost(postList);
						break;
						
					case 6: //파일 저장 //글 목록과 비밀번호까지 전부 저장
						BoardFunction.saveFilePost(postList);
						break;

						
					case 7: //종료 //
						System.out.println("종료합니다.");
						System.exit(0);
						break;
			
					default:
						System.out.println("올바르지 않은 기능(선택)입니다. 다시 입력 부탁드립니다.");
						break;
					}
			
			} catch(NumberFormatException e) {
				System.out.println("올바르지 않은 기능(선택)입니다. 다시 입력 부탁드립니다.");
				
			}
		
		}

	}

}
