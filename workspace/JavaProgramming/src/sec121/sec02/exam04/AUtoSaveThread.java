package sec121.sec02.exam04;

public class AUtoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용을 저장");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				break;
			}
			
			save();
		}
	}

}
