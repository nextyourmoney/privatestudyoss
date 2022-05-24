package homeworkAlgorithm.feb16we;

import java.util.Scanner;

public class algorithmHomework2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		
		String var1 = scanner.nextLine();
		String var2 = scanner.nextLine();
		
		String[] var3 = var1.split(" ");
		int rememberCount = Integer.parseInt(var3[0]); //외울 수 있는 단어 개수
		int wordCount = Integer.parseInt(var3[1]); //단어의 개수
		String[] words = var2.split(" "); //기억해야 할 단어 목록
		
		String[] rememberWords = new String[rememberCount]; //기억한 단어 목록	
	
		for(int i = 0; i < wordCount; i++) { //기억해야 할 단어를 가져온다.
			for(int z = 0; z < rememberCount; z++) { //기억한 단어 배열 사용을 위해
				System.out.println("one: " + words[i]);
				System.out.println("two: " + rememberWords[z]);
				if(rememberWords[z] != null && rememberWords[z].equals(words[i])) { //기억한 목록 중에 같은 값이 있을 때 처리 할 조
					String[] temp = new String[rememberCount]; //배열을 정렬하기 위한 임시 배열
					sum += 1; //1초 더한다
					System.out.println("case1");
					rememberWords[z] = null; //같은 값 삭제
					
					int c =0;
					int case1 = 0; //c를 1, 2,3 씩 시작 위치를 지정해 주기 위하여// 개쓰래기 코
					for(int k = 0; k < rememberCount; k++) {
						if(rememberWords[k] != null) {
							c = case1;
							for(; c < rememberCount ; c++) { //0에서 시작하고 반복후 1에서 시작식으로 된다.
								temp[c] = rememberWords[k]; //null을 제외한 기존의 값들이 당겨져서 임의의 배열에 들어간다. ex)00000x
							}
							case1 += 1;
							
							temp[rememberCount-1] = words[i]; //임의의 배열 가장 마지막에 기억해야 할 단어를 삽입한다.
						}
						
					}
					break;
				} 
				else if(rememberWords[z] == null) { //기억한 단어 중에 빈값이 있을 때
					
					rememberWords[z] = words[i]; //단어를 외운 기억에 삽입	
					sum += 3; //3초를 더한다
					break;
					
				} 
				else if(rememberWords[z] != null && z == rememberCount - 1) { //끝까지 탐색했음에도 빈곳이 없을 때 가장 오래 된 목록을 삭제해야 한다.
					
					sum += 3;
					String[] temp = new String[rememberCount]; //배열을 정렬하기 위한 임시 배열
					int wordSum = 0;
					int remainWord = 0;
					for(int x = i; x < wordCount; x++) {
						wordSum += words[x].length();
						remainWord++;
					}
	
					double wordAvg = (double)wordSum / remainWord; //남은 단어들의 평균 길이
					
					
					for(int y = 0; y < rememberCount; y++) { //오래된 기억에서 길이를 비교해서 삭제하고 삽입하기 위해
						if(rememberWords[y].length() <  wordAvg ) { //잊어버려야 하는 단어가 외우고 있는 단어들의 평균 길이보다 길다면이라는 조건을 else로 주어 정상 진행하게 한다.
																	//외우고 있는 단어들의 평균 길이가 더 기므로 가장 단어를 삭제하고 가장 최근의 위치에 저장한다.
							rememberWords[y] = null;
							System.out.println("case3-1");
							int c =0;
							int case1 = 0; //c를 1, 2,3 씩 시작 위치를 지정해 주기 위하여// 개쓰래기 코
							for(int k = 0; k < rememberCount; k++) {
								if(rememberWords[k] != null) {
									c = case1;
									for(; c < rememberCount; c++) { //0에서 시작하고 반복후 1에서 시작식으로 된다.
										temp[c] = rememberWords[k]; //null을 제외한 기존의 값들이 당겨져서 임의의 배열에 들어간다. ex)00000x
									}
									case1 += 1;
									
									temp[rememberCount-1] = words[i]; //임의의 배열 가장 마지막에 기억해야 할 단어를 삽입한다.
									
									
								}
								
							}
						
							
							for(int test = 0; test < rememberCount; test++) {
								System.out.println("case3-2");
								rememberWords[test] = temp[test]; //원 배열에 적
							}
							break;
							
						}
						
							
					}
					
					for(int zs = 0; zs < rememberCount; zs++) {
						System.out.println("adflkajsfdl: ---> "+ temp[zs]) ;
					}
					
				}
				
			}		
		}
		
		System.out.println(sum);
	}
}
