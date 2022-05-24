package ch07.sec01.exam03;

public class Computer extends Calculator {
	
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areacircle 실");
		return Math.PI * r * r;
	}
}
