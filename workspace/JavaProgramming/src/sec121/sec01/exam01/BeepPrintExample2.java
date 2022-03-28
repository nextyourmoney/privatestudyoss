package sec121.sec01.exam02;

import java.awt.Toolkit;

public class BeepPrintExample1 {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() { 
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i = 0; i<5; i++) {
					toolkit.beep();
					try {Thread.sleep(500);} catch(Exception e) {}
				}
			}
		});
		thread.start();
		
		for (int i=0; i<5; i++) {
			System.out.println("삐");
			try {Thread.sleep(500);} catch(Exception e) {}
		}
	}

}
