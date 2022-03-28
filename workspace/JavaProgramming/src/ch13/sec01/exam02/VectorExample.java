package ch13.sec01.exam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Board> list = new Vector<Board>();
		List<Board> list = new ArrayList<>();
		
		Thread thread1 = new Thread() {
			@Override
			public  void run() {
				for(int i = 0; i<=1000000; i++) {
					list.add (new Board ("wpahr" + i, "fsdf" + i, "dfj" + i));
				}
			}
		};
		
		Thread thread2 = new Thread() {
			@Override
			public  void run() {
				for(int i = 1000001; i<=2000000; i++) {
					list.add (new Board ("wpahr" + i, "fsdf" + i, "dfj" + i));
				}
			}
		};
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
			
		} catch(Exception e) {}
		
		
		/*
		 * list.add(new Board("test1", "ssoduyd", "rmfTmsdl")); list.add(new
		 * Board("test1", "ssoduyd", "rmfTmsdl")); list.add(new Board("test1",
		 * "ssoduyd", "rmfTmsdl"));
		 * 
		 * list.remove(2); Board board = list.get(2); System.out.println(board.content);
		 */
		
		

	}

}
