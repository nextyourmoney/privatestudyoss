package ch04.sec02;

public class BreakOutterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outter: for(char upper = 'A'; upper <= 'Z'; upper++) {
			for(char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + "-" + lower);
				if(lower =='g') {
					break Outter;
				}
			}
		}
		
	 System.out.println("프로그램 실행 종");
	 
	 for(int i = 1; i <= 10; i++) {
		 if(i%2 != 0) {
			 continue;
		 }
		 System.out.println(i);
	 }

	}

}
