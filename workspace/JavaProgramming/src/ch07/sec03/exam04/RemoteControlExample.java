package ch07.sec03.exam04;

//실행 코드
public class RemoteControlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//인터페이스 타입의 변수 선언
		//인터페이스를 사용하겠다. - 인터페이스변수는 참조 타입이다
		RemoteControl rc = null;
		
		//실제로 실행될 내용을 가지고 있는 객체를 세팅
		rc = new Television();
		
		//인터페이스르 사용
				rc.turnOn();
				rc.setVolume(5);
				rc.turnOff();
		
		//실제로 실행될 내용을 가지고 있는 객체를 세팅
		rc = new Audio();
		
		//인터페이스르 사용
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();

	}

}
