package sec121.sec01.exam03;

public class ThreadA extends Thread {
	public ThreadA() {
		setName("ThreadA");
	}
	@Override
	public void run() {
		for(int i = 0; i<1000; i++) {
			Thread thread = Thread.currentThread();
			System.out.println(getName() + "내용");
		}
		
	}

}
