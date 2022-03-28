package ch06.sec04.exam03;

public class Car {
	//필드
	int gas;
	
	//생성자
	
	//메소드
	void setGas(int gas) {
		this.gas = gas;
		
	}
	
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("no gas");
			return false;
			}
		System.out.println("Yes gas");
		return true;
		
	}
	
	void run()
	{
		while(true) {
			if(gas > 0) {
				System.out.println("ggogogogo");
				gas -= 1;
			} else {
				System.out.println("stop");
				return; //메소드 실행 종
			}
		}
	}

}
