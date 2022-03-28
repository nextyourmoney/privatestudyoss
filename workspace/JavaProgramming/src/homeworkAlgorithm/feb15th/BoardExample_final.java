package homework.feb15th;
import java.util.Scanner;
public class BoardExample_final {

	public static void main(String[] args) {
		String[][] boardStore = new String[100][4];
		int num = 0;
		boolean run = true;
		int tmp = 0;
		
		while(run) {
			System.out.println("--------------------------------------------");
			System.out.println("번호\t\t제목\t\t글쓴이\t\t");
			System.out.println("--------------------------------------------");
			int[] sortArray = new int[100]; //정렬을 위한 배열 별도 생
			int idx = 0; //sortArray의 인덱스는 차례대로 진행되어야 하기 때문.
			
			for(int i=0; i<boardStore.length; i++) {
				if(boardStore[i][0] != null) {
					sortArray[idx] = Integer.parseInt(boardStore[i][0]); //이차원 배월의 첫번째 값에 속하는 0번째 
					idx++; //sortArray의 순서 지정
				}
			}

			for(int i=0; i<(sortArray.length-1); i++) { // 내림차순 정렬
				for(int j=i+1; j<sortArray.length; j++) { 
					if( (sortArray[i] != 0) && (sortArray[i] < sortArray[j]) ) {  //순서 정렬
						tmp = sortArray[i];
						sortArray[i] = sortArray[j];
						sortArray[j] = tmp;
					} else if(sortArray[i] == 0) { //마지막(0이면 없다는 것이다)
						break;
					}
				}
			}
			
			for(int s : sortArray) { //출력
				if(s == 0) {
					break;
				} else {
					for(int i=0; i<boardStore.length; i++) {
						if( (boardStore[i][0] != null) && (boardStore[i][0].equals(Integer.toString(s))) ) {
							System.out.println(boardStore[i][0]+"\t\t"+boardStore[i][1]
									+"\t\t"+boardStore[i][2]+"\t\t");
							System.out.println();
							break;
						}
					}
					
				}
				
			}

			System.out.println("--------------------------------------------");
			System.out.println("메뉴: 1.생성 | 2.보기 | 3.수정 | 4.삭제 | 5.종료");
			System.out.print("선택: ");
			Scanner input = new Scanner(System.in);
			
			switch(input.nextLine()) {
			
				case "1": //생성
					System.out.println("[새글쓰기]");
					System.out.print("제목: ");
					Scanner title = new Scanner(System.in);
					String titleStr = title.nextLine();
					
					System.out.print("글쓴이: ");				
					Scanner author = new Scanner(System.in);
					String authorStr = author.nextLine();
					
					System.out.print("내용: ");
					Scanner contents = new Scanner(System.in);
					String contentsStr = contents.nextLine();
					num++;
					String[] temp = {Integer.toString(num), titleStr, authorStr, contentsStr}; //temp에는 담김.
					
					for(int i=0; i<boardStore.length; i++) {
						if(boardStore[i][0]==null) {
							boardStore[i] = temp;
							break;
						}
					}
					break;
					
				case "2": //보기
					System.out.print("게시물 번호: ");
					Scanner sc1 = new Scanner(System.in);
					String viewNum = sc1.nextLine().trim();
					
					System.out.println("[글 보기]");
					for(int i=0; i<boardStore.length; i++) {
						if( (boardStore[i][0]!=null) && (boardStore[i][0].equals(viewNum)) ) {
							System.out.println("번호: " + boardStore[i][0]);
							System.out.println("제목: " + boardStore[i][1]);
							System.out.println("글쓴이: " + boardStore[i][2]);
							System.out.println("내용: " + boardStore[i][3]);
							break;
							
						} else if( (i==(boardStore.length-1)) && (boardStore[i][0]==null) ) { //null값을 별도로 주지 않으면 오류가 발생한다. 
							System.out.println(viewNum + "번 게시물이 존재하지 않습니다.");
							break;
							
						} else if( (i==(boardStore.length-1)) && !(boardStore[i][0].equals(viewNum)) ) { //배열의 마지막값이라는 조건을 주지 않으면, 순회하는 모든 배열 객체 값에서 게시물이 존재하지 않는다는 메세지가 출력된다.
							System.out.println(viewNum + "번 게시물이 존재하지 않습니다.");			
							break;
						}
					}
					break;
					
				case "3": //수정
					System.out.print("게시물번호: ");
					Scanner s1 = new Scanner(System.in);
					String findNum = s1.nextLine().trim();
					System.out.println();
					System.out.println("[글 수정]");
					for(int i=0; i<boardStore.length; i++) {
						if( (boardStore[i][0]!=null) && (boardStore[i][0].equals(findNum)) ) {
							System.out.print("제목: ");
							Scanner newTittle = new Scanner(System.in);
							boardStore[i][1] = newTittle.nextLine();
							System.out.print("내용: ");
							Scanner newContents = new Scanner(System.in);
							boardStore[i][3] = newContents.nextLine();
							break;
						} else if( (i==(boardStore.length-1)) && (boardStore[i][0]==null) ) {
							System.out.println(findNum + "번 게시물이 존재하지 않습니다.");
							break;
						} else if( (i==(boardStore.length-1)) && !(boardStore[i][0].equals(findNum)) ) {
							System.out.println(findNum + "번 게시물이 존재하지 않습니다.");			
							break;
						}
					}
					break;
					
				case "4": //삭제
					System.out.print("게시물번호: ");
					Scanner deleteScanner = new Scanner(System.in);
					String deleteNum = deleteScanner.nextLine().trim();
					for(int i=0; i<boardStore.length; i++) {
						if( (boardStore[i][0] != null) && (boardStore[i][0].equals(deleteNum)) ) {
							System.out.print(deleteNum + "번 게시물을 삭제하시겠습니까?(삭제>Y): ");
							Scanner confirm = new Scanner(System.in);
							if(confirm.nextLine().equalsIgnoreCase("Y")) {
								for(int j=0; j<boardStore[i].length; j++) {
									boardStore[i][j] = null;								
								}
								System.out.println(deleteNum + "번 게시물이 삭제되었습니다.");
								break;
							} else {
								break;
							}
						} else if( (i==(boardStore.length-1)) && (boardStore[i][0]==null) ) {
							System.out.println(deleteNum + "번 게시물이 존재하지 않습니다.");
							break;
						} else if( (i==(boardStore.length-1)) && !(boardStore[i][0].equals(deleteNum)) ) {
							System.out.println(deleteNum + "번 게시물이 존재하지 않습니다.");			
							break;
						}
					}
					break;
					
				case "5": //종료
					run = false;
					break;
					
				default:
					System.out.println("메뉴를 다시 입력해 주세요.");
					break;
					
			}
			
			System.out.println("===== 프로그램을 종료합니다. =====");
		}

	}

}