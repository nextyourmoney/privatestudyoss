package ch09.sec02.exam02;

public class Anonymous {
	RemoteControl field = new RemoteControl() {
		@Override 
		public void turnOn() {
			System.out.println("tv를 켭니다");
		}
		
		@Override
		public void turnOff() {
			System.out.println("tv 끈다");
		}
	};
	
	void method1() {
		RemoteControl localVar = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("audio를 킨다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("audio 끈다");
			}
		};
		

		}
	void method2(RemoteControl rc) {
		rc.turnOn();
	}
}


