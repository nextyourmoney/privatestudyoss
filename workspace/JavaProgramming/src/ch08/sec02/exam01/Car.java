package ch08.sec02.exam01;


	
	public class Car{
		//field
		Tire frontLeftTire = new HankookTire();
		Tire frontRightTire = new HankookTire();
		Tire backLeftTire = new HankookTire();
		Tire backRightTire = new HankookTire();
		
		
	//Method
	void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
		
	}
	}


