package ch03.sec03;

public class KeyCodeExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		int keyCode;
		
		//키보드로 입력된 키 하나를 읽는다.
		keyCode = System.in.read(); //read는 메소드이다.ㅏ 
		System.out.println(keyCode);
		
		keyCode = System.in.read();
		System.out.println(keyCode);
		
		keyCode = System.in.read();
		System.out.println(keyCode);
		

	}

}
