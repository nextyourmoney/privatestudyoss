package Algorithm_0315;

import java.io.*;
import java.util.Scanner;

public class silver_3273 {
	public static void main(String[] args) {
		//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader선언 
		Scanner scanner = new Scanner(System.in);
		
		
			String numCountStr = scanner.nextLine();
			int numCount = Integer.parseInt(numCountStr); //수열의 개수 입력 
			int count = 0;
			
			String sequence = scanner.nextLine(); //수열
			String[] sequenceArr = sequence.split(" "); //수열을 배열로 분열한다.
			
			String numStr = scanner.nextLine();
			int num = Integer.parseInt(numStr); //구하려는 값
		
			for(int i = 0; i < numCount - 2; i++) {
				for(int j = 1; j < numCount - 1 ; j++) {
					int a = Integer.parseInt(sequenceArr[i]);
					int b = Integer.parseInt(sequenceArr[j]);
						
					if(num == (a + b)){ 
						count += 1;
		
					}
				}
			}
			System.out.println(count);
	}
}
