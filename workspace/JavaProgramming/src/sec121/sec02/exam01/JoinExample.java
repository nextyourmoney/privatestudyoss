package sec121.sec02.exam01;

public class JoinExample {
	private static int sum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//이부분은 main에 속한 부분이 아니다.
		Thread thread = new Thread(() ->{
			for(int i = 1; i <= 100; i++) {
				sum += 1;
			}
			
		});
		
		//밑의 system이 thread.start보다 빠르게 실행되었다는 소리다. threa는 여전히 실행 중이었다. 
		thread.start();
		
		
		//위의 이유로 thread가 종료 될 때까지 대기해야 한다. 이때  사용되는 것이 join
		try {
			thread.join();
		} catch(InterruptedException e) {}
	
		//스레드가 종료 할 때까지 일시 정지한다.
		System.out.println("sum: " + sum);
	}

}
