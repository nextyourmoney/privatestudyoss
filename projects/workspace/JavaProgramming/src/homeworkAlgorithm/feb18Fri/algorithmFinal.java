package homeworkAlgorithm.feb18Fri;

import java.util.Scanner;

public class algorithmFinal {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	int testCaseNum = Integer.parseInt(scanner.nextLine()); //테스트 케이스의 개수 입력
	String[] originPassWord = new String[testCaseNum]; //원본(정답)이 저장 될 배
	
	for(int i = 0; i < testCaseNum; i++) { //반복
		int passWordLength = Integer.parseInt(scanner.nextLine()); //패스워드의 길이 입력
		char[] passWordCharArr = new char[passWordLength]; //암호가 한글자씩 복호화 되어 들어 갈 배열
		String passWord = scanner.nextLine(); //패스워드 입력
		
		for(int x = 0; x < passWordLength; x++) {
			int passWordCode = passWord.charAt(x); //복호화 작업 //charAt을 통해 x위치의 string을 char로 변환 후 아스 값에 4를 더한다. 
			
			if(119 <= passWordCode && passWordCode <= 122){ //복호화 해야 할 값이 w이상 z이하 일 때 a,b,c,d로 주기 위한 조건
				passWordCharArr[x] = (char)(passWordCode - 22); //w의 아스키코드 119 - 22 = 97로 a의 코드이다. //조건에 소문자로 입력 된다는 조건이 있으므로 대문자는 고려하지 않는다.
			} else {
				passWordCharArr[x] = (char)(passWordCode + 4); //외의 값들은 배열에 문자로 변환 후 삽
			}
		}
		
		originPassWord[i] = String.valueOf(passWordCharArr); //원본값이 들어갈 배열에 char 배열의 값들을 string변환 후 삽입
	}
	
	for(int i = 0; i < testCaseNum; i++) { 
		System.out.println("Case #" + (i+1)); //출력 /i는 0부터 이므로 1을 더해준다.
		System.out.println(originPassWord[i]);
	}
	}
}
