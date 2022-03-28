package ch06.sec06.exam02.mycompany;

import ch06.sec06.exam02.hyundai.Engine;
import ch06.sec06.exam02.kumho.BigWidthTire;
import ch06.sec06.exam02.hankook.Tire; //패키지가 달라도 클래스 이름이 같으면 사용불가.
//import ch06.sec.exam02.kumho.Tire;   //클래스 이름이 같다면 직접 지정한다. 
import ch06.sec06.exam02.hankook.SnowTire;

public class Car {

	//Field
	Engine engin = new Engine(); //필드 선언이며 필드에서도, 생성자에서도 선언가능하다
	SnowTire tire1 = new SnowTire();
	Tire tire2 = new Tire();
	Tire tire3 = new Tire();
	ch06.sec06.exam02.kumho.Tire tire4 = new ch06.sec06.exam02.kumho.Tire(); //경로를 직접 입력하여 같은 클래스의 이름이라도 구별 할 수 있도록 한다.
	BigWidthTire tire5 = new BigWidthTire();
	
	
	
	//Constructor
//	Car(){
//		engine = new Engine(); //필드 선언 Field에서 선언도 가능하며 생성자에서도 선언 가능하다
//	}
	
	
	
	//method
}
