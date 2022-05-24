package sec121.sec02.exam03;

public class PrintThread extends Thread {
	

	
	@Override
	public void run() {
		/*
	}
		try {
			while(true){
				System.out.println("실행 중");
				Thread.sleep(1); 
			}
		} catch(Exception e){
			
		}
		System.out.println("자원 정링");
		System.out.println("실행 종료");
		*/
	
	while(true) {
		System.out.println("실행 중");
		if(isInterrupted()) { //interrupted 감지
			break;
		}
	}
		System.out.println("자원 정링");
		System.out.println("실행 종료");
	}
}
