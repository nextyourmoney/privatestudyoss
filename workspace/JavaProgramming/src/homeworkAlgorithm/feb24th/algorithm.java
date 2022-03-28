package homeworkAlgorithm.feb24th;

import java.util.*;
public class algorithm {

		// main이 static이므로 필드와 re 메소드도 static으로 선언한다.
		public static int[] operator = new int[4]; //연산자 총 4종류
		public static int[] numArr;// 수열의 배열
		public static int max = Integer.MIN_VALUE; // 정수의 최대값 정의
		public static int min = Integer.MAX_VALUE; // 정수의 최솟값 정의
		public static int numCount; // 입력받을 숫자 개수
		
		
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			
			String numCountString = scanner.nextLine(); //숫자 개수 입력
			numCount = Integer.parseInt(numCountString); // 숫자 개수 문자열 정수로 변환
			numArr = new int[numCount]; //숫자들이 들어갈 배열의 크기 정의
			
			String[] numSplitArr = scanner.nextLine().split(" "); //문자열로 숫자의 배열을 입력 //띄어쓰기를 기준으로 분리한다.
			
			for(int i = 0; i < numSplitArr.length; i++) { //띄어쓰기를 기준으로 분리 된 숫자들을 배열에 저장 //{1, 2, 3, 4, 5}의 형태가 된다.
				numArr[i] = Integer.parseInt(numSplitArr[i]); //정수로 변환
			}
			
			String[] operatorArr = scanner.nextLine().split(" ");//연산자들을 입력 받는 분자열 //띄어쓰기를 기준으로 spli
			
			for(int i = 0; i < operator.length; i++) { //입력된 연산자들의 개수를 배열에 저장 //{0, 1, 0, 0}의 형식
				operator[i] = Integer.parseInt(operatorArr[i]); //정수로 변환
			}
			
			cal(numArr[0],1); // 연산을 위해 set배열의 첫 값이 들어가야 한다.
			
			System.out.println(max);
			System.out.println(min);
			
	

	}
		public static void re(int num, int index) {
			if(index == numCount) { // index가 해당 경우의 수의 마지막을 만나면 max와 min을 저장
				if(max < num) {
					max = num;
				}
				if(min > num) {
					min = num;
				}
			}
			
			for(int i = 0; i < operator.length; i++) { // 모든 경우의 수
				if(operator[i] > 0) {
					operator[i]--; //한 번 실행될 때마다 operator에 있는 값이 1씩 감소 
					
					switch(i) {
						case 0:// '+'
							re(num + numArr[index], index + 1);
							break;
						case 1:// '-'
							re(num - numArr[index], index + 1);
							break;
						case 2:// '*'
							re(num * numArr[index], index + 1);
							break;
						case 3:// '/'
							re(num / numArr[index], index + 1);
							break;
					}
					operator[i]++;//다른 경우의 수를 계산하기 위해 초기화를 위한 값 증가
				}
			}
		}

	}


