package ch07.sec01.exam01;

public class CellPhone {
	
	//필드
	String model;
	String color;
	
	//생성자
	
	//메소드
	void powerOn(){ 
		System.out.println("전원을 킨다");
	}
	
	void powerOff() {
		System.out.println("전원을 끈다");
	}
	
	void bell() {
		System.out.println("ring bell");
	}
	
	void sendVoice(String message) {
		System.out.println("mine: " + message);
	}
	
	void receiveVoice(String message) {
		System.out.println("other: " + message);
	}
	
	void hangUp() {
		System.out.println("stop telling");
	}

}
