package ch10.sec01.exam05;

public class ClassCastExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
	
	}
	
	public static void changeDog(Animal animal) {
		Dog dog = (Dog) animal; //에러발생
	}

}

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}
