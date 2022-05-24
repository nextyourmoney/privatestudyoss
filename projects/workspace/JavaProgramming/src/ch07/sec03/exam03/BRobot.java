package ch07.sec03.exam03;

public class BRobot extends RobotFunction{
	
	/*
		private String kind;
		private String company;
		private String owner;
		*/
		
		public BRobot(String owner) {
			this.owner = owner;
			this.kind = "전투";
			this.company = "국방전자";
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
			System.out.println("무한궤도로 움직인다.	.");
		}
		
		@Override
		public void work() {
			System.out.println("전투를 한다");
		}
		
		public void shoot() {
			System.out.println("미사일 발사.");
		}
		
		public void fire() {
			System.out.println("총을 쏜다");
		}

}
