package ch04.sec02;

public class ForPrintFromExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*int sum = 0;
		
		//더욱 효율
		for(int i = 0; i<=100; i+=3) {
			sum+=i;
			System.out.println(i);
		}
		
		//2
		for(int i = 1; i<=100; i++) {
			if(i%3 == 0) {
				sum+=i;
			}
		}
		
		//3
		for ( int i = 2; i<=10; i++) {
			System.out.println(i+"단");
		
			for (int n=1; n<=9; n++) {
				System.out.println(i+"*"+ n + "=" + (i*n));
			}
		}*/
		
		//1
		System.out.println("1번");
		//문제 - 과
		for(int i = 1; i <= 5; i++){
			for(int k = 0; k < i; k++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//2
		
		System.out.println("");
		System.out.println("2번");
		for(int i = 5; i >= 1; i--){
			for(int k = 1; k <= i; k++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//3
		System.out.println("");
		System.out.println("3번");
		for(int i = 1; i < 5; i++){
			for(int k = 0; k < i; k++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for(int i = 5; i >= 1; i--){
			for(int k = 1; k <= i; k++){
				System.out.print("*");
			}
			System.out.println("");
		}
		

		
	}

}
