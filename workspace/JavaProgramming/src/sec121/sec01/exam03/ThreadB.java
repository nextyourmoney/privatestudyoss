package sec121.sec01.exam03;

public class ThreadB extends Thread{
	

	@Override
	public void run() {
		System.out.println(getName());
	}

}
