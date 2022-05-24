package ch13.sec01.exam04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class SetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<>();
		
		set.add("java");
		set.add("Vue.js");
		set.add("dfksf");
		set.add("dfksdfdff");
		
		for(String item : set) {
			System.out.println(item);
		}
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String item = iterator.next();
			System.out.println(item);
		}
		
		for(String item : set) {
			if(item.equals("Vue.js")) {
				set.remove(item);
			}
				
		}
		
		/*
		 * Iterator<String> iterator2 = set.iterator(); while(iterator.hasNext()) {
		 * String item = iterator.next(); if(item.equals("Vue.js")) { //오류 발
		 * iterator2.remove(); } System.out.println(item); }
		 */
		
		
	}

}
