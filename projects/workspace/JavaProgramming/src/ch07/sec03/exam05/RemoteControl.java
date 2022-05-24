package ch07.sec03.exam05;

//인터페이스

public interface RemoteControl {
	//상수
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	//추상 메소드
	void turnOn();
	public void turnOff();
	public abstract void setVolume(int volume);

}
