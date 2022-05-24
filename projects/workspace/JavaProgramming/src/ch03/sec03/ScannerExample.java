package ch03.sec03;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(System.in);
		String inputData;
		
		while(true) {
			System.out.print("입력:");
			inputData = scanner.nextLine();
			System.out.println("입력된 데이터:\"" +inputData + "\"");
			if(inputData.equals("q")){
					break;
			}
		}
		System.out.println("종료");
	}
}
