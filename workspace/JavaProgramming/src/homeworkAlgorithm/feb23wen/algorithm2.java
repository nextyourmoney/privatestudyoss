package homeworkAlgorithm.feb23wen;

import java.util.*;

public class algorithm2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] stringCountFirstLine = scanner.nextLine().split(" "); //문자열로 나누어 입력 받는다.
		int checkStringCount = Integer.parseInt(stringCountFirstLine[0]); //개수를 확인할 문자열 값들
		int needCheckStringCount = Integer.parseInt(stringCountFirstLine[1]); //검색할 문자열
		String[] checkStringArr = new String[checkStringCount]; //비굥해야 할 문자열과 비교당할 문자열들을 저장한다.
		String[] checkStringArr2 = new String[needCheckStringCount]; //비굥해야 할 문자열과 비교당할 문자열들을 저장한다.
		int count = 0;
		
		for(int i = 0; i < checkStringCount; i++) { //첫 비교 원본이 될 문자열들 입력
			checkStringArr[i] = scanner.nextLine(); //문자열 입력
		}
		
		for(int i = 0; i < needCheckStringCount; i++) {
			checkStringArr2[i] = scanner.nextLine(); //문자열 입력
		}
		
		for(int i = 0; i < checkStringCount; i++) {
			for(int j = 0; j < needCheckStringCount; j++) {
				if(checkStringArr[i].equals(checkStringArr2[j])) {
					count++;
				}		
			}
		}
		System.out.println(count);	
	}
}
