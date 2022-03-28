package sec121.sec01.exam04;

import java.awt.Toolkit;

public class BeepThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i<5; i++) {
			toolkit.beep();
			try {Thread.sleep(500);} catch(Exception e) {}
		}
	
	}
}
