package ch07.sec03.exam03;

public abstract class RobotFunction  {
	public String kind;
	public String company;
	public String owner;
	
	public abstract void move();
	public abstract void work();
	
	public void powerOn() {
		System.out.println("전원을 넣습니다.");
		
	}
	
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	

}
