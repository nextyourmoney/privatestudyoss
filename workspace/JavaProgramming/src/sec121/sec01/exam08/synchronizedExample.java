package sec121.sec01.exam08;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import sec121.sec01.exam08.User1;
import sec121.sec01.exam08.User2;

public class synchronizedExample {

	public static void main(String[] args) {
		// 공유 객체
		
	//ArrayList list = new ArrayList();
	List list = new ArrayList();
	//Vector list = new Vector();

		
		//user1 스레드 실행
		User1 user1 = new User1();
		user1.setList(list);
		user1.start();
		
		//User2 스레드 실
		User2 user2 = new User2();
		user2.setList(list);
		///user2.start();
		
		//User1과  User2가 모두 실행될 때까지 main 스레드를 대기d
		
		try {
			user1.join();
			user2.join();
		} catch (InterruptedException e) {
			
		}
		System.out.println("총 저장된 수:" +list.size());

	}

	

}
