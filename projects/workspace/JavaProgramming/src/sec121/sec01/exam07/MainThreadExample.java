package sec121.sec01.exam07;

public class MainThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();
		
		//user1 스레드 실행
		User1 user1 = new User1();
		user1.setCalc(calc);
		user1.start();
		
		//User2 스레드 실
		User2 user2 = new User2();
		user2.setCalculator(calc);
		user2.start();

	}

}
