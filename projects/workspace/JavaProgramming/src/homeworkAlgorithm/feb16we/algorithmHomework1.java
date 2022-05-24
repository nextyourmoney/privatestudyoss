package homeworkAlgorithm.feb16we;

import java.util.Scanner;

public class algorithmHomework1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
		
			int[] oddNumber = new int[7]; //홀수의 정렬을 위한 array선
			int sum = 0; //홀수의 총합을 위한 sum 변수
			int count = 0;
			int temp = 0;	
		
			System.out.print("7개의 자연수 입력> ");
			String numbers = scanner.nextLine(); //첫째줄에 자연수 7개를 입력 받는다.
			numbers = numbers.replaceAll(" ", "");
			
			String[] numbersSplit = numbers.split(","); // ','를 기준으로 split 진행(분리)
		
			for(String numberStr: numbersSplit) {
				int number = Integer.parseInt(numberStr.trim()); //문자열로 입력되어있는 숫자를 공백이 있을 경우 공백 제거 후 정수형으로 변환
			
				if(number % 2 == 1) { //홀수 확인 조건
					oddNumber[count] = number; //array에 홀수 선언 //count를 통해서 위치를 정의한다.
					count ++;
				
					sum += number; //홀수의 합
				}
			}
		
			if(count == 0) { //홀수가 없을 떄의 처리	
				System.out.println(-1);
				break;
			} 
			else { //홀수가 존재 할 떄의 처리
					for(int i = 0; i < oddNumber.length - 1; i++) { //정렬
						for(int z = i + 1; z < oddNumber.length; z++) {
							if(oddNumber[i] >= oddNumber[z] && oddNumber[z] > 0 ) { //비교 숫자 중 앞의 숫자가 더 클시 뒤로 가도록 조건을 주었다.
																					//앞의 숫자와 비교하는 뒤의 숫자가 배열의 빈공간(0)을 만나면 더 이상 순서를 바꾸지 않도록 하였다.
																					//정렬이 완료되면 다음과 같은 형태가 된다.  1 2 3 4 0 0 0
																					//다음 조건을 주지 않을 시 0 0 0 1 2 3 4의 형태가 되기 떄문에 oddNumber[z] > 0이 필요하다. 
								temp = oddNumber[i];
								oddNumber[i] = oddNumber[z];
								oddNumber[z] = temp;
							} 
						}
					}

					System.out.println(sum);
					System.out.println(oddNumber[0]);
				}
		}
	}
}
