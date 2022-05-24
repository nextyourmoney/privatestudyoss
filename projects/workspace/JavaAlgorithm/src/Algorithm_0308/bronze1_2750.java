//https://www.acmicpc.net/problem/2750

package Algorithm_0308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bronze1_2750 {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//개수 입력
		String numCountStr = scanner.nextLine();
		int numCount = Integer.parseInt(numCountStr);
		
		//들어갈 배열 생성
		int[] numArr = new int[numCount];
		
		//정렬할 숫자들 입력
		for(int i = 0; i < numCount; i++) {
			String numStr = scanner.nextLine();
			int num = Integer.parseInt(numStr);
			
			numArr[i] = num;
		}
		
		//배열의 모든 값들을 서로 비교하여 다음 값이 클 경우 위치를 서로 바꾸어 작은 수가 앞으로 가도
		int minNum = numArr[0];
		for(int i = 0; i < numCount - 1; i++) {
			for(int j = i+1; j < numCount; j++) {
				if(numArr[i] > numArr[j]) {
					int temp = numArr[i];
					numArr[i] = numArr[j];
					numArr[j] = temp;
				}
			}
		}
		
		//출력
		for(int numSorted:numArr ) {
			System.out.println(numSorted);
		}
		
	}
	
	//sort 메소드 사용
	static void sortNum() {
		Scanner scanner = new Scanner(System.in);
		
		
		String numCountStr = scanner.nextLine();
		int numCount = Integer.parseInt(numCountStr);
		
		int[] numArr = new int[numCount];
		

		for(int i = 0; i < numCount; i++) {
			String numStr = scanner.nextLine();
			int num = Integer.parseInt(numStr);
			
			numArr[i] = num;
		}
		
		Arrays.sort(numArr);
		
		for(int numSorted:numArr ) {
			System.out.println(numSorted);
		}
		
		
		
		
	}

}
