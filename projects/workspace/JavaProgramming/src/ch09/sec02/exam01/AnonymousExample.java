package ch09.sec02.exam01;

public class AnonymousExample {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.wake();
		anony.method1();
		anony.method2(
			new Person() {
				void study() {
					System.out.println("rhdqn");
				}
				@Override
				void wake() {
					System.out.println("8tl");
					study();
				}
			}
		);
	}
}
