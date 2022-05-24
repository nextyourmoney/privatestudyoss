package sec121.sec01.exam01;

import java.awt.Toolkit;

public class BeepPrintExample1 {
	public static void main(String[] args) {
		Thread thread = new Thread(new Task());
		thread.start();
		
		for (int i=0; i<5; i++) {
			System.out.println("삐");
			try {Thread.sleep(500);} catch(Exception e) {}
		}
	}

}
