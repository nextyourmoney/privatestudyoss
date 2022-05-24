package ch06.sec04.exam01;

public class CalculatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator myCal = new Calculator();
		myCal.powerOn();
		
		int result = myCal.plus(3, 5);
		System.out.println("result =" + result);
		
		byte x= 10;
		byte y =4;
		double result2 = myCal.divide(x, y);
		System.out.println("result =" + result2);
		
		myCal.powerOff();

	}

}
