package ch13.sec01.examp07;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		
		map.put(new Student(1, "test1"), 95);
		map.put(new Student(1, "test2"), 95);
		
		System.out.println(map.size());

	}

}
