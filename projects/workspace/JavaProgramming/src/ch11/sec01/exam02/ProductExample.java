package ch11.sec01.exam02;

import java.util.*;

public class ProductExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product p1 = new Product(1, "mycompany", "TV", 100000);
		Product p2 = new Product(1, "yourcompany", "TV", 100000);
		//p1 = p2;
		
		System.out.println(p1.hashCode()); //동일한 정수값 나오
		System.out.println(p2.hashCode()); //동일한 정수값 나오도록
		
		System.out.println(p1.equals(p2)); //true가 나오독 하고자 한다. 
		
		HashSet<Product> hashSet = new HashSet<>();
		hashSet.add(p1);
		hashSet.add(p2);
		System.out.println("저장된 수: " + hashSet.size()); //1이 나오도록한다
		
	}

}
