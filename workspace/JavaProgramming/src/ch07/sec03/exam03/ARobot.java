package ch07.sec03.exam03;

public class ARobot extends RobotFunction {

	public ARobot(String owner) {
		this.owner = owner;
		this.kind = "서빙";
		this.company = "우리전자";
	}
	
	/*
	public void powerOn() {
		System.out.println("전원을 넣습니다.");
	}
	
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	*/
	
	//추상 메소드 재정
	@Override
	public void move() {
		System.out.println("3rodml qkznlfh dnawlrdlqslek.");
	}
	
	@Override
	public void work() {
		System.out.println("음식을 나른다");
	}
	
	public void wash() {
		System.out.println("식기를 닦습니다.");
	}
	
	public void selectMenu() {
		System.out.println("메뉴를 선택하세요");
	}

}
