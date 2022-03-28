package ch06.sec04.exam04;

public class Calculator {
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double avg(int x, int y) {
		double sum = plus(x, y);
		double result = sum /2;
		return result;
	}
	
	void execute() {
		double result = avg(7,10);
		println ("실해생결과:" + result);
		
	}

	private void println(String string) {
		// TODO Auto-generated method stub
		
	}
	

}
