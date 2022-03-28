package ch13.sec01.exam06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("test1", 53);
		map.put("test2", 54);
		map.put("test3", 55);
		map.put("test4", 56);
		System.out.println(map.size());
		
		System.out.println(map.get("test1"));
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println();
		}
		
		map.remove("tetst3");
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryInterator = entrySet.iterator();
		
		while(entryUterator.hasNext()) {
			Map.Entry<K, V>
		}
	}

}
