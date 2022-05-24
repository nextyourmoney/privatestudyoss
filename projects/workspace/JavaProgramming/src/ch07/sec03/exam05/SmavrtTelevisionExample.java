package ch07.sec03.exam05;

public class SmavrtTelevisionExample {
	public static void main(String[] args) {
		//인터페이스 변수 선언
		RemoteControl remoteControl = null;
		Searchable searchable = null;
		
		//구현 객체 생성
		SmarTelevision st = new SmarTelevision();
		
		//인터페이스로 사용 할 수 있도록 한다.
		remoteControl = new SmarTelevision();
		
		//인터페이스 사용
		remoteControl.turnOn();
		remoteControl.setVolume(5);
		remoteControl.turnOff();
		
		//인터페이스로 사용 할 수 있도록 한다.
		searchable = st;
	
		//인터페이스 사용
		searchable.search("http://www.mycompany.com");
		
		
		
	}
}
