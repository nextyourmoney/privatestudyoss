package ch07.sec03.exam03;

public class RobotExample {
	public static void use(RobotFunction robot) {
		robot.powerOn();
		robot.move();
		robot.work();
		robot.powerOff();
	
		//뭔가 헷갈리
		if(robot instanceof ARobot) {
			ARobot r = (ARobot) robot;
			r.selectMenu();
			r.wash();
		}
		
		robot.powerOff();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		use(new ARobot("음식점")); //추상 클래스는 객체 생성이 불가능하기 떄문에 추상 클래스의 자식 클래스를 호출 하여 입력한다.
		use(new BRobot("국방부"));
		use(new CRobot("구청"));
		
		

	}

}
