package ch11.sec01.exam07;

public class SystemTimeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		for(int i = 0; i < 100; i++) {
			sum += 1;
		}
		
		System.out.println("합" + sum + "ns");
		System.out.println("합" + sum/1E9 + ""); //지수 나누
		System.out.println("합" + sum/1000000 + ""); //지수 나누
		
		//long end = System.nanoTime();
		//long start = System.nanoTime();
		long start = System.currentTimeMillis();
		long end = System.currentTimeMillis();
		
		System.out.println("" +sum);
		System.out.print("걸린시간" + (end-start) / 1000000000.0 + "s");

	}

}
