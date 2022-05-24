package sec121.sec01.exam07;

public class User1 extends Thread{
	private Calculator calculator;
	

	public void setCalc(Calculator calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}


	@Override
	public void run() {
		calculator.setMemory(100);
		
	}

}
