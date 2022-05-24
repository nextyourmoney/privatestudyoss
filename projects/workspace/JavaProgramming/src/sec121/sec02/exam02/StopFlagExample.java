package sec121.sec02.exam02;

public class StopFlagExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintThread thread = new PrintThread();
		thread.start();
		
		try {
			Thread.sleep(3000); //메인 스레드 슬립
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//thread.stop(); //사용 말아라
		thread.setStop(true);

	}

}


