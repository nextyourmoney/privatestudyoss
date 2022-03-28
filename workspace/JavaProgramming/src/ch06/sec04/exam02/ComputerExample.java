package ch06.sec04.exam02;

public class ComputerExample {

	public static void main(String[] args) {
		Computer myCom = new Computer(); //객체 생성
		
		int[] values1 = {1,2,3};
		int result1 = myCom.sum1(values1);
		
		int result2 = myCom.sum1(new int[] {1,2,3,4,5});
		
		int result3 = myCom.sum2(1,2,3);
		
		int result4 = myCom.sum2(1,2,3,4,5);
	}
}
