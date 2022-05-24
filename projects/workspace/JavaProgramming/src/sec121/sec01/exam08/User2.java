package sec121.sec01.exam08;

import java.util.ArrayList;
import java.util.Vector;

public class User2 extends Thread {

	//private ArrayList list;
	private Vector list;

	public void setList  (Vector list) {
		this.setName("User1");
		this.list = list;
	}

	@Override
	public void run() {
		
		
	}

}
