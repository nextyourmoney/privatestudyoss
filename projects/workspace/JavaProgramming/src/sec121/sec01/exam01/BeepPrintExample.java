package sec121.sec01.exam03;

import sec121.sec01.exam01.Task;

public class BeepPrintExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(( )-> {
			for (int i=0; i<5; i++) {
				System.out.println("삐");
				try {Thread.sleep(500);} catch(Exception e) {}
			}	
		});
		thread.start();
		
		
		
		

	}

}
