package BookHomeWork.ch03_Verify;

import java.util.Scanner;

public class ch03_HomeWork {

	public static void main(String[] args) {
			
		Scanner scanner = new Scanner(System.in);
		double num1 = Double.parseDouble(scanner.next());
		double num2 = Double.parseDouble(scanner.next());
		
		double result = num1 / num2;
		if(num2 == 0.0) {
			System.out.println("무한");
		} else {
		System.out.println(result);
		}
	}
}
