package ch06.sec03.exam3;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car1 = new Car();
		System.out.println(car1.company);
		System.out.println();
		
		Car car2 = new Car("자가");
		System.out.println(car2.company);
		System.out.println(car2.model);
		System.out.println();
		
		
		Car car3 = new Car("wkrkdyd", "red");
		System.out.println(car3.company);
		System.out.println(car3.red);
		System.out.println();
		
		
		Car car4 = new Car("taxi", "black", 200);
		System.out.println(car4.company);
		System.out.println();
		

	}

}
