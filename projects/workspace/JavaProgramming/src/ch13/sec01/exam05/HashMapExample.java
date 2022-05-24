package ch13.sec01.exam05;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("me", 843);
		map.put("me1", 833);
		map.put("me2", 823);
		map.put("me3", 813);
		
		System.out.println(map.size());
		
		System.out.println(map.get("me2"));
		
		Set<String> keySet = map.keySet();
		

	}

}
