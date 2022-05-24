package appendix.lambda.exam07;

public class Person {

	public void ordering(Calcuable comparable) {
		String a = "홍킬동";
		String b = "rlazlfehd";
	
		int result=  comparable.compare(a, b);
		
		if(result < 0) {
			System.out.println(a + "는" +b + "보다 앞에 온다");
		} else if(result ==0 ) { 
			System.out.println(a + "는" +b + "같다");
		} else {
			System.out.println(a + "는" +b + "보다 뒤에 온");
		}
	}
}
