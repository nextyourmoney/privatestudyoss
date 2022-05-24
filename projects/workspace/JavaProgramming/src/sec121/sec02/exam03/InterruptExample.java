package sec121.sec02.exam03;

public class InterruptExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintThread thread = new PrintThread();
		thread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//일시 정지를 방해한다. 즉 일시 정지가 불가능하다
		thread.interrupt();

	}

}
