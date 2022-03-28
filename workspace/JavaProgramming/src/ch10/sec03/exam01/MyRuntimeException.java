package ch10.sec03.exam01;

//실행 예
public class MyRuntimeException extends RuntimeException{
	public MyRuntimeException() {}
	public MyRuntimeException(String message) {
		super(message);
	}

}
