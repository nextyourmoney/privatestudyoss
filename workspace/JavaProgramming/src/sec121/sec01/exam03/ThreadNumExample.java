package sec121.sec01.exam03;

public class ThreadNumExample {
	public static void main(String[] args) {
	Thread thread = Thread.currentThread();
	System.out.println(thread.getName());
	
	ThreadA threadA = new ThreadA();
	ThreadB threadB = new ThreadB();
	threadB.setName("Thread");
	
	threadA.start();
	threadB.start();

	}
}
