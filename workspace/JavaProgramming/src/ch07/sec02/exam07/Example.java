package ch07.sec02.exam07;

public class Example {
	
	public static void method1(Animal animal) { 
		animal.sound(); //4가지의 sound가 올 수 있다. //다형성
	}
	
	public static void method2(Mammal mammal) {
		mammal.sound(); //3가지가 올 수 있따. //다형
		
		//Dog dog = (Dog) mammal; //3가지가 올 수 있기 떄문에 dog가 올 확신이 없다.
		//dog.sound();
		
		if(mammal instanceof Dog) {  //mammal이 do를 참조하는지 검
			Dog dog = (Dog) mammal;
			dog.sound();
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1(new Animal());
		method1(new Mammal());
		method1(new Dog());
		method1(new Cat());
		
		method2(new Mammal());
		method2(new Dog());
		method2(new Cat());
		
		

		
	}

	

}
