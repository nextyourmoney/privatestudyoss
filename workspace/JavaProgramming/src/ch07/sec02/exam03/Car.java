package ch07.sec02.exam03;

public class Car {
	Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new Tire("앞오른쪽",2);
	Tire backLeftTire = new Tire("뒤왼쪽",3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);
	
	int run() {
		System.out.println("자동차 달린다");
		if(frontLeftTire.roll() == false) {stop(); return 1;};
		if(frontRightTire.roll() == false) {stop(); return 1;};
		if(backLeftTire.roll() == false) {stop(); return 1;};
		if(backRightTire.roll() == false) {stop(); return 1;};
		return 0;
	}
	
	void stop() {
		System.out.println("stop");
	}

}
