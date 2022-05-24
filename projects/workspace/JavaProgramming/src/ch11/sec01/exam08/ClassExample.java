package ch11.sec01.exam08;

import ch11.sec01.exam08.*;

public class ClassExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Class clazz = Car.class;
		try {
		Class clazz = Class.forName("ch11.sec01.exam08.Car");
		
		//Car myCar = new Car();
		//Class clazz = myCar.getClass();	
		
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackage().getName());
		} catch(ClassNotFoundException e) {
			System.out.print("클래스를 찾지 못했습니다.");
		}

	}

}
