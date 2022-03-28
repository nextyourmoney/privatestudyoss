package ch12.sec01;

public class StringIndexOfExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String subject = "자바 프로그램밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf(location) != -1) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 과련 안된 ");
		}
		
		if(subject.contains("자바")) { //true or false로 반환된다.
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 과련 안된 ");
		}

	}

}
