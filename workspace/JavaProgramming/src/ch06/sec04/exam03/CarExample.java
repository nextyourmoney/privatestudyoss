package ch06.sec04.exam03;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car myCar = new Car();
		
		myCar.setGas(5);
		
		boolean gasState = myCar.isLeftGas();
		if(gasState) {
			System.out.println("출발");
			myCar.run()
;
			}
		
		if(myCar.isLeftGas()) {
			System.out.println("가스 주입 필요 없음");
			
		} else {
			System.out.println("gas를 주입하세요");
		}

	}

}
