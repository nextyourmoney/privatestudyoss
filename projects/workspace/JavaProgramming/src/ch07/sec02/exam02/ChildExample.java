package ch07.sec02.exam2;

public class ChildExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Child child = new Child();
		Parent parent = child;
		
		parent.method1();
		parent.method2();
		//parent.method3();

	}

}
