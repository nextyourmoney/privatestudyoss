package ch10.sec02.exam02;

public class TryCatchFinally {
	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		try {
			data1 = args[0];
			data2 = args[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족하다");
			return;
//		} finally {
//			//System.out.println("return 테스트");
//		}
			
	}
		
		System.out.println("return 테스트");
	}
}
