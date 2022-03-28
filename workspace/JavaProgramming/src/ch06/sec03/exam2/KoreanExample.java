package ch06.sec03.exam2;

public class KoreanExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//각 객체마다 새로운 값을주기 위하여 생성자 사
		Korean k1 = new Korean("JBC","010");
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		
		Korean k2 = new Korean("JBC2","2010");
		System.out.println(k2.name);
		System.out.println(k2.ssn);

	}

}
