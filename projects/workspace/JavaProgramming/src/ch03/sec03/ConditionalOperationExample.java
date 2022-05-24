package ch03.sec03;

public class ConditionalOperationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int score = 85;
		char gradle = (score > 90) ? 'A' : ((score > 80) ? 'B': 'C');
		System.out.printf("result: %c",gradle);

	}

}
