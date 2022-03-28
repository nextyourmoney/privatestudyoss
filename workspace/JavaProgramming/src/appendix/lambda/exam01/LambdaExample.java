package appendix.lambda;

public class LambdaExample {
	
	public static void action(Calculable calculable) {
		int x = 10;
		int y = 4;
		calculable.Calculate(x, y);
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//익명 구현 객체를 매개값으로 제
		action(new Calculable() {

			@Override
			public void Calculate(int x, int y) {
				// TODO Auto-generated method stub
				int result = x + y;
				System.out.println("result: " + result);
			}
			
		});
		
		//람다식을 매개값으로 제공
		action((x, y) -> {
			int result = x + y;
			
			System.out.println("redsult: "+ result);
		});
		
		
		action( ( x, y) -> System.out.println("result: " + (x - y)) );

	}
	
}
