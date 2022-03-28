package ch07.sec01.exam06;

public class Car {
	public int speed;
	
	public void SpeedUP() {
		speed += 1;
	}

	public final void stop() { //final 메소
		System.out.println("stop");
		speed = 0;
	}
}
