package BookHomeWork.ch05_Verify;

import java.util.Scanner;

public class ch05_HomeWork3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------");
			System.out.println("1. 학생수, 2.점수 입력 3.점수 리스트, 4. 분석, 5. 종료");
			System.out.println("---------------");
			System.out.print("선택>");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo == 1) { //학생수 입력
				
				System.out.print("학생수>");
				String studentNum_string = scanner.nextLine();
				studentNum += Integer.parseInt(studentNum_string);
				scores = new int[studentNum];
				
			} else if(selectNo ==2) { //점수 입력
				for(int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> ", i);
					String score_string = scanner.nextLine();
					scores[i] = Integer.parseInt(score_string);
				}
				
			} else if(selectNo ==3) {//점수 리스트
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]> %d\n", i, scores[i]);
				}
				
			} else if(selectNo ==4) { //분석
				int sum = 0;
				for(int score: scores) {
					sum += score;
				} 
				
				System.out.printf("최고 점수: %d\n", sum);
				
				double avg = (double) sum / studentNum;
				System.out.printf("평균 점수: %f\n", avg);
				
			} else if(selectNo ==5) {
				run = false;
				
			}
		}
		System.out.println("프로그램 종료");
	}

}
