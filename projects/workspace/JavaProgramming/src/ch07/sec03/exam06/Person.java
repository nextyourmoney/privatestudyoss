package ch07.sec03.exam06;

public class Person {
	//Field
	private RemoteControl rc; //rc에는 하나의 객체가 아닌 여러개의 객체를 사용 할 수 있다.
	
	//Constructor
	public Person(RemoteControl rc) {
		this.rc = rc;
	}
	//Method
	public void methodA() {
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
	}
	
	public void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
	}
}
