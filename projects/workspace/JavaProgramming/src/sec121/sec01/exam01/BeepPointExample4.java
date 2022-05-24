package sec121.sec01.exam04;

import sec121.sec01.exam01.Task;

public class BeepPointExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//상속을 통해 정
		BeepThread thread = new BeepThread();
		thread.start();
		
		for (int i=0; i<5; i++) {
			System.out.println("삐");
			try {Thread.sleep(500);} catch(Exception e) {}
		}
	}

	}

