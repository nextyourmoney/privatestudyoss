package ch04.sec01;

public class IfDiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*	//난수
			double num1 = Math.random(); // 0.0 ~ 1.0
			System.out.println("num1"+ num1);
			
			//*10
			num1 *= 6; //0.0 ~ 6.0
			System.out.println("num1" + num1);
			
			//실수에서 정수
			int num2 = (int)num1; //0,1,2,3,4,5
			System.out.println("num2" + num2);
			
			num2 += 1; //1,2,3,4,5,6
			System.out.println("num2" + num2);*/
		
		int num = (int) (Math.random()*6) + 1;
		System.out.println("num3" + num);
		
		if(num%2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		

	}

}
