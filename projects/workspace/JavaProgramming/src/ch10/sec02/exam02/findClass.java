package ch10.sec02.exam02;

public class findClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			findClass();
			
		} catch(ClassNotFoundException e) {
			System.out.print("클래스가 존재하지 않는다.");
		}
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
		
	}

}
