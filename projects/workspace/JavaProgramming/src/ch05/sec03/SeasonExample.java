package ch05.sec03;

import java.util.Calendar;

public class SeasonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//열거 타입 변수 선언과 초기값 대입
		Season season = Season.WINTER;
		
		//변수의 값 변경
		season = Season.FALL;
		
		//변수의 값을 읽기
		if(season == Season.SPRING) {
			System.out.println("봄이다");
		} else if(season == Season.FALL) {
			System.out.println("가을이다");	
		} else {
			System.out.println("여름 또는 겨울이다");
		}
		
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		
		
		

	}

}
