package ch14.sec03.exam02;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		
		while(true) {
			int value = scanner.nextInt();
			System.out.println(value);
		}
		
		//scanner.close();
	}

}
