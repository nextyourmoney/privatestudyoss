package ch06.sec04.exam02;

public class CallByValueByRegerenceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CallByValueCallByReference obj = new CallByValueCallByReference();
		
		int value = 10;
		obj.method1(value);
		System.out.println(value);
		
		int[] array = {10};
		obj.method2(array);
		System.out.println(array[0]);

	}

}
