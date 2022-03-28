package ch06.sec04.exam01;

public class Calculator {
	
	//메소드
	void powerOn() {
		System.out.println("system On");
	}
	
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double divide(int x, int y) {
		double result = (double) x / y;
		return result;
	}
	
	void powerOff() {
		System.out.println("System Off");
	}
	

}
