package ch08.sec02.exam03;

public class Bus implements Vehicle{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("vus run");
		
	}
	
	public void checkFare() {
		System.out.println("승차요금을 체크한다.");
	}
	

}
