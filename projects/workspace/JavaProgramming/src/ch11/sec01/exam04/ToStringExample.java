package ch11.sec01.exam04;

import java.util.*;

public class ToStringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Member m = new Member("winter", "눈송이");
		Product p = new Product(1, "mycompany", "노트북", 2500000);
		Date d = new Date();
		
		/*
		System.out.println(m.toString()); //{id: windter, name: 눈송이}를 나오도록 하시
		System.out.println(p.toString()); //pno:1, company: mycompany, anme:노트북, price:25000}이 나오도록 하시오
		System.out.println(d.toString());
		*/
		
		System.out.println(m);
		System.out.println(p);
		System.out.println(d);
	}

}
