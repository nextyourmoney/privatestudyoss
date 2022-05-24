package ch08.sec02.exam01;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car = new Car();
		
		car.run();
		
		car.frontLeftTire = new KumhoTire();
		car.backLeftTire = new KumhoTire();

		car.run();
	}

}
