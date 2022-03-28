package Algorithm_HomeWork;

import java.util.Scanner;

public class homework0214 {

	public static void main(String[] args) {
		
		//1
		/*
		아래 그림과 같이 코드를 작성하
		*
		**
		***
		****
		*****
		*/
		System.out.println("1번");
		for(int i = 1; i <= 5; i++){
			for(int k = 0; k < i; k++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//2
		/*
		아래 그림과 같이 코드를 작성하라 
		*****
		****
		***
		**
		*
		*/
		
		System.out.println("");
		System.out.println("2번");
		for(int i = 5; i >= 1; i--){
			for(int k = 1; k <= i; k++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//3
		/*
		아래 그림과 같이 코드를 작성하라 
		*
		**
		***
		****
		*****
		****
		***
		**
		*
		*/
	
		System.out.println("");
		System.out.println("3번");
		for(int i = 1; i < 5; i++){
			for(int k = 0; k < i; k++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for(int i = 5; i >= 1; i--){
			for(int k = 1; k <= i; k++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//4번
		//첫번째 숫자와 두번째 숫자를 입력한 후 배수까지 입력 받는다. 이 후 첫번쨰 숫자와 두번째 숫자 범위내의 배수들의 합을 구하시
     	System.out.println("4번 문제");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 숫자:");
		int var1 = scanner.nextInt();
		
		System.out.print("두번째 숫자:");
		int var2 = scanner.nextInt();
		
		System.out.print("배수:");
		int var3 = scanner.nextInt(); //배수
		
		int sum = 0;
		
		for(; var1 < var2; var1++ ) {
			if(var1 % var3 == 0) {
				sum+=var1;
			}
		}
		System.out.println(sum);
		
		
		//5번
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("5번 문제");
		
		int var4 = 0;
		int var5 = 0;
		
		while(var4 <= var5) {
			System.out.print("첫번째 숫자:");
			var4 = scanner1.nextInt();
			
			System.out.print("두번째 숫자:");
			var5 = scanner1.nextInt();
			
			System.out.print("배수:");
			int var6 = scanner1.nextInt(); //배수
				
			int sum2 = 0;
			
			for(; var4 < var5; var4++ ) {
				if(var4 % var6 == 0) {
					sum2 += var4;
				}
			}
			System.out.println(sum2);		
		}
		
		//5-2번 //그냥 내가 추가로 한
		Scanner scanner11 = new Scanner(System.in);
		System.out.println("5-2번 문제");
		
		
		while(true) {
			System.out.print("첫번째 숫자:");
			int var7 = scanner11.nextInt();
			
			System.out.print("두번째 숫자:");
			int var8 = scanner11.nextInt();
			
			System.out.print("배수:");
			int var9 = scanner11.nextInt(); //배수
			
			if(var4 >= var5) {
				System.out.print("시작수가 끝수보다 큽니다");
				break;
			}
				
			int sum3 = 0;
			
			for(; var7 < var8; var7++ ) {
				if(var7 % var9 == 0) {
					sum3 += var7;
				}
			}
			System.out.println(sum3);
			
		}
		
		//6번
		//다음과 같이 메뉴를 반복해서 제곡아호 각 번호를 입력했을 때 볓번이 선택되었습니다라고 출력하시오
		Scanner scanner111 = new Scanner(System.in);
		
		
		System.out.println("6번 문제");
		int choice_num = 0;
		while(true) {
		System.out.println("****************");
		System.out.println("1.라면 2.짜장 3.짬뽕 4.종료");
		System.out.println("****************");
		System.out.print("선택:");
		choice_num = scanner111.nextInt();
		if(choice_num == 4) {
			System.out.println("종료");
			break;
			} else {
			System.out.printf("%d가 선택되었습니다.\n",choice_num);
			}
		}
	}
}
