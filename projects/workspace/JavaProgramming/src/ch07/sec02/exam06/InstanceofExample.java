package ch07.sec02.exam06;

public class InstanceofExample {
	
	public static void method(Parent parent) {
		parent.parentMethod();
		//parent.childmethod() //Paret타입이기 때문에 parent에 있는 method만 사용가능
	
		Child child = (Child) parent;
		child.childMethod();
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		method(new Parent());
		method(new Child());

	}

}
