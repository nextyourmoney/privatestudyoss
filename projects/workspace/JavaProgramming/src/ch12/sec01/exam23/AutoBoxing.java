package ch12.sec01.exam23;

public class AutoBoxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer obj = 100;
		System.out.print(obj.intValue());
		
		int value = obj;
		System.out.println(value);
		
		int result = obj + 100;
		System.out.print(result);
	}

}
