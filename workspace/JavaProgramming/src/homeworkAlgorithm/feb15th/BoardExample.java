package homework.feb15th;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//게시판을 만들기

public class BoardExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		String[][] BoardStore = new String[100][4]; //게시물 최대 개수는 100 //각각에는 번호, 제목, 글쓴이, 내용 저장
		
		int number = 0; //자동 번호위한 번
		
		while(run) {
			
			
			
			
			
			
			System.out.println("-------------------------------");
			System.out.printf("번호 \t 제목 \t \t 글쓴이\n");
			System.out.println("-------------------------------");
			
			
			for(int i = 0; i < 100; i++) {
				if(BoardStore[i][0] != null) {
					Arrays.sort(BoardStore, Comparator.comparingInt(o1 -> o1[0]));
					System.out.printf(BoardStore[i][0] + " \t " + BoardStore[i][1] + " \t " + BoardStore[i][2] + "\n");
				}
			}
			
			System.out.println("-------------------------------");
			System.out.println("메뉴: 1.생성 | 2.보기 | 3.수정 | 4.삭제 | 5.종료");
			System.out.print("선택: "); //번호 선택	
			
			
			switch(scanner.nextLine()) {
				case "1": //생성 //조건: 자동번호, 제목 입력, 글쓴이 입력, 내용 입력 //100개 이상은 안되지만 번호가 100이상은 가
					
					for(int i = 0; i < 100; i++) {
						if(BoardStore[i][0] == null) { //배열에서 비어있는 객체가 있을 때만 해당 객체를 채우기 위해 실
							number ++; //자동 번호 생성을 위한 증가 //배열은 가득찼어도 번호는 100을 넘길 수 있다.
							System.out.println("[새글쓰기]");
						
							System.out.println("번호: " + number); //번호 출력
						
							System.out.print("제목: ");
							String title = scanner.nextLine(); //제목 
						
							System.out.print("글쓴이: ");
							String author = scanner.nextLine(); //글쓴이
						
							System.out.print("내용: ");
							String contents = scanner.nextLine(); //내용
						
							String[] information = {String.valueOf(number), title, author, contents}; 
			
							for(int z = 0; z < 4; z++) { 
								
								BoardStore[i][z] = information[z]; //2차원 배열에 순서대로 정보들을 저장
								
							} break; //값 삽입 후 for문 종료 //종료하지 않으면 모든 null값에 값을 삽입하게 된다.
						} else if(i == 99 && BoardStore[i][0] != null ) { //배열 99번째까지 검색했는데도 없다는 것이므로 게시판 꽉찼다는 소리이다.
							
							System.out.println("게시판 한계입니다. 삭제하세요");
							break;
						}
					} 
					break;
							
				case "2": //보기
					System.out.println("[글 보기]");
					System.out.print("게시물번호: ");
					String bookNumberStr = scanner.nextLine(); //검색할 책 번호 입력
					int bookNumber = Integer.parseInt(bookNumberStr) - 1; //보이는 책 번호는 배열의 위치값이 아니라 배열 내부의 책 번호이기 때문에 0부터 시작하는 배열에 값에ㅔ 맞추기 위해 -1을 진행한다.
					
					for(int i = 0; i < 100; i++) { //번호가 아닌 100개의 배열 안에서 저장되어있는지 확인하기 위해 100까지 반복한다.
						if(BoardStore[i][0] != null && BoardStore[i][0].equals(bookNumberStr)) { //입력한 게시물 번호와  게시판에 저장되어있는 글번호가 일치 할 경우에만 실행
					
							System.out.println("번호: " + BoardStore[i][0]);
							System.out.println("제목: " + BoardStore[i][1]);
							System.out.println("글쓴이: " + BoardStore[i][2]);
							System.out.println("내용: " + BoardStore[i][3]);
							break; //break하지 않으면 모든 배열이 진행된다.
							
						} else {
							System.out.println("없는 번호입니다."); //일치하는 게시판 번호가 없을 경우 출력
							break;
						}
						
						
					}
				
					break;
				
				case "3": //수정
					System.out.println("[글 수정]");
					System.out.print("게시물 번호: ");
					
					String bookNumberStr1 = scanner.nextLine(); //검색할 책 번호 입력
					int bookNumber1 = Integer.parseInt(bookNumberStr1) - 1; //보이는 책 번호는 배열의 위치값이 아니라 배열 내부의 책 번호이기 때문에 0부터 시작하는 배열에 값에ㅔ 맞추기 위해 -1을 진행한다.
					
					for(int i = 0; i < 100; i++) { //번호가 아닌 100개의 배열 안에서 저장되어있는지 확인하기 위해 100까지 반복한다.
						if(BoardStore[i][0] != null && BoardStore[i][0].equals(bookNumberStr1)) { //입력한 게시물 번호와  게시판에 저장되어있는 글번호가 일치 할 경우에만 실행
					
							System.out.print("제목: ");
							String correctionTitle = scanner.nextLine();
							BoardStore[i][1] = correctionTitle;
						
							System.out.print("내용: ");
							String correctionContents = scanner.nextLine();
							BoardStore[i][3] = correctionContents;
							break; //break하지 않으면 모든 값에서 진행이 계속된다.
							
						} else if(i == 99 && BoardStore[i][0] == null) { //i가 99이고 해당 객체가 null이면 일치하는 값이 없다는 것이므
							System.out.println("없는 번호입니다."); //일치하는 게시판 번호가 없을 경우 출력
							break;
						} else if(i == 99 && !BoardStore[i][0].equals(bookNumberStr1)) { //i가 99이고 해당 객체까지 일치하는 문자열이 없다면 없는 번호이다.
							System.out.println("없는 번호입니다."); //일치하는 게시판 번호가 없을 경우 출력
							break;
						}
					}
					
					break;

				case "4": //삭제
					System.out.print("게시물 번호: ");
		               String tempBoardNumber = scanner.nextLine();
		               for(int i = 0; i < BoardStore.length; i++) {
		                  if((BoardStore[i][0] != null) && (BoardStore[i][0].equals(tempBoardNumber))) {
		                     for(int j = 0; j < BoardStore[i].length; j++) {
		                        BoardStore[i][j] = null;
		                     }
		                  } else if(i == 99 && BoardStore[i][0] == null) { //i가 99이고 해당 객체가 null이면 일치하는 값이 없다는 것이므
								System.out.println("없는 번호입니다."); //일치하는 게시판 번호가 없을 경우 출력
								break;
							} else if(i == 99 && !BoardStore[i][0].equals(tempBoardNumber)) { //i가 99이고 해당 객체까지 일치하는 문자열이 없다면 없는 번호이다.
								System.out.println("없는 번호입니다."); //일치하는 게시판 번호가 없을 경우 출력
								break;
							}
		               }
					
					break;	
				
				case "5":
					run = false; 
					break;
					
		        default: 
		        	break;

			}
			
			 System.out.println("-------------------------------------------------------------");
			 
		}
	}

}
