package ch12.sec01;

public class StringSplitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String scores = "83 90 87 94";
		String[] array = scores.split(","); //array의 반환형은 배열이며 split을 ,을 통해 분리한다. 이러한 분리 기준은 토큰이라한다.

		for(String s: array) {
			System.out.println(s);
		}
		
		int[] intArray = new int[array.length];
		for(int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(array[i]);
		}
		
		int sum = 0;
		for(int n: intArray) {
			sum += n;
		}
		
		double avg = (double) sum / intArray.length;
		
	}

}
