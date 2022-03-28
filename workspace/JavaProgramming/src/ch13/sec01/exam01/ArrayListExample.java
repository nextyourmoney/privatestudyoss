package ch13.sec01.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String>  list = new ArrayList<String>();
		
		list.add("test");
		list.add(1,"df");
		
		int size = list.size();
		
		String skill = list.get(1);
		
		
		for(int i =0; i<list.size(); i++) {
			String str = list.get(i);
		}
		
		list.remove(1);
		list.remove("test");
		
		
	}

}
