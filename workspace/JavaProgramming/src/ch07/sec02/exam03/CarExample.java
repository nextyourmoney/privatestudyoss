package ch07.sec02.exam03;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i = 1; i <= 5; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
				case 1:
					System.out.println("leftfront");
					car.frontLeftTire = new HankookTire("frontleft", 15);
					break;
				case 2:
					
					
				case 3:
					
				case 4:
				
			}
		
		
		}

	}

}
