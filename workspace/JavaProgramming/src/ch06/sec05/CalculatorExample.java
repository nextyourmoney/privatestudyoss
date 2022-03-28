package ch06.sec05;

public class CalculatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//객체 생성
		Calculator cal1 = new Calculator();
		Calculator cal2 = new Calculator();
		
		//각각 객체의 memmory의 값을 선정
		cal1.memory = 100;
		cal2.memory = 200;
		System.out.println("cal1의 메모리 값: " + cal1.memory);
		System.out.println("cal2의 메모리 값: " + cal2.memory);
		
		//정적 필드 값을 설정 //객체마다 저장이 되지 않는다. //또한 아래의 방법은 추구하지 않는다.
		cal1.color = "blakc";
		cal2.color = "red";
		System.out.println("cal1의 값: " + cal1.color);
		System.out.println("cal2의 값: " + cal2.color);
		
		//static은 반드시 참조형식이 아닌 클래스를 통한 접근 및 수정을 할 것!!
		Calculator.color = "yello";
		System.out.println("calculator.color 값: " + Calculator.color);
		
		
		
		
		
		
		
		
		

	}

}
