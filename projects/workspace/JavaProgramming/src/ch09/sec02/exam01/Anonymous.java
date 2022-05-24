package ch09.sec02.exam01;

public class Anonymous {
	Person field = new Person() {
	void work() {
		System.out.println("출근한");
	}
	
	@Override
	void wake() {
		System.out.println("6tl");
		work();
	}
	};
	
	void method1() {
		Person localVar = new Person() {
		void walk() {
			System.out.println("tjsxor");
		}
		@Override
		void wake() {
			System.out.print("'7tl");
			walk();
		}
		
	};
	
	localVar.wake();
}

	void method2(Person person) {
		person.wake();
	}
}