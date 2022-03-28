package ch11.sec01.exam03;

import java.util.*;

public class KeyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<>();
		
		String key1 = "m1";
		String key2 = new String("m1");
		
		map.put("m1", "길동");
		map.put("m1", "눈송이");
		System.out.println("저장된 수:" + map.size());
		
		System.out.println(key1.hashCode() == key2.hashCode());
		System.out.println(key1.equals(key2));
		
		HashMap<Key, String> Map2 = new HashMap<>();
		
		Key myKey = new Key(1, "windter");
		Key yourKey = new Key(1, "winter");
		
		Map2.put(myKey, "길동");
		Map2.put(yourKey, "눈송이");
		System.out.println("저장된 수:" + map.size());
		
		System.out.println(myKey.hashCode() == yourKey.hashCode());
		System.out.println(myKey.equals(yourKey));

	}

}
