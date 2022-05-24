package sec121.sec02.exam02;

public class PrintThread extends Thread {
	
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while(!stop){
			System.out.println("실행 중");
		}
		
		System.out.println("자원 정링");
		System.out.println("실행 종료");
	}

}
