package ch09.sec01.exam01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		
		A.B b = a.new B();
		b.field1 = 3;
		b.method1();
		
		A.C c = new A.C();
		c.field1 = 3;
		c.method1();
		A.class.field2 = 3;
		A.class.method2();
		
		a.method();

	}

}
