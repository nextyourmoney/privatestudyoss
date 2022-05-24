package ch13.sec01.exam08;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashtableExmaple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("spring", "12");
		map.put("spring2", "122");
		map.put("spring2", "122");
		map.put("sprin3g", "122");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("id and password");
			String id = scanner.nextLine();
			String pwd = scanner.nextLine();
			
			if(map.containsKey(id)) {
				if(map.get(id).equals(pwd)) {
					System.out.println("success");
					break;
					
				} else {
					System.out.print("fail");
				}
				
			} else {
				System.out.print("noe");
			}
			
		}
		
	}

}
