package ch06.sec03.exam3;

public class Car {
	
	//필
	String company = "현대";
	String model;
	String color;
	int maxSpeed;
	
	//생성
	Car()
	{
		
	}
	
	Car(String model){
		this.model = model;
		
	}
	
	Car(String model, String color){
		this.model = model;
		this.color = color;
		
	}
	
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
