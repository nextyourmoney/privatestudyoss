package appendix.lambda.exam05;

public class Person {
	public void action(Calcuable calcuable) {
		double result = calcuable(10.0, 4.0);
		System.out.println("겨로가" + result);
	}

}
