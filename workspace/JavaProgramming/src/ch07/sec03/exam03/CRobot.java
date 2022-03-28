package ch07.sec03.exam03;

public class CRobot extends RobotFunction{
	
	/*
		private String kind;
		private String company;
		private String owner;
		*/
		
		public CRobot(String owner) {
			this.owner = owner;
			this.kind = "안내";
			this.company = "국민전자";
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
			System.out.println("4개 바퀴로 움직인다..");
		}
		
		@Override
		public void work() {
			System.out.println("건물 내부를 안내한다");
		}
		
		public void speak() {
			System.out.println("대화를 한다.");
		}
}
