package BookHomeWork.ch04_Verify;

import java.util.Scanner;

public class Ch04_HomeWork3 {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------");
			System.out.println("1.예금 |2.출금 | 3.잔고 | 4.종료 ");
			System.out.println("--------------------");
			System.out.print("-선택-");
			
			int choice_num = scanner.nextInt();
			
				if(choice_num == 1) { //예
					System.out.println("선택> " + choice_num);
					System.out.print("예금액: ");
					balance += scanner.nextInt();
				} else if(choice_num == 2){ //출금
					System.out.println("선택> " + choice_num);
					System.out.print("출금액: ");
					balance -= scanner.nextInt();
				} else if(choice_num == 3) { //잔
					System.out.println("선택> " + choice_num);
					System.out.println("잔고: " + balance);	
				} else if(choice_num == 4) { //종료
					System.out.println();
					break;
				}
		}
		System.out.println("프로그램 종료");
	}
}
