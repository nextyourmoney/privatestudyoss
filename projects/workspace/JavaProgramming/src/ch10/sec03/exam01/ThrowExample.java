package ch10.sec03.exam01;

public class ThrowExample {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		method1(0);
	} catch(MyException e) {
		//System.out.print(e.getMessage());
		//System.out.println(e.toString());
		e.printStackTrace(); //e의모든 히스토리정보까지 종류, 이유, 위치까지 추적한다.
		
	} 
	
	try {
		method2(-2);
	} catch(MyRuntimeException e) {
		System.out.print(e.getMessage());
	}
}
	
		public static void method1(int value) throws MyException {
			if(value < 0) {
				throw new MyException("다음 연유로 예외 발생");
			}
			
		}
		
		public static void method2(int value) throws MyRuntimeException{
			//예외 발생 코드
			if(value < 0) {
				
			}
			throw new MyRuntimeException("저런 이유 때문에 예외가 발행했다");
		}
	}



