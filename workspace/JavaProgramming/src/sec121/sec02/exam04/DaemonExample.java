package sec121.sec02.exam04;

public class DaemonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AUtoSaveThread autoSaveThread = new AUtoSaveThread();
		autoSaveThread.setDaemon(true); //데몬스레드로 선언
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("메인 스레드 종료");

	}

}
