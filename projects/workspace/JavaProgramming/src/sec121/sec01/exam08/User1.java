package sec121.sec01.exam08;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class User1 extends Thread{
	//private ArrayList list;
	//List list = new ArrayList;
	private Vector list;
	

	public void setList(List list2) {
		this.setName("User1");
		this.list = list2;
	}


	@Override
	public void run() {
		for(int i = 0; i < 10000000; i++) {
			list.add(i);
		}
		
		
	}

}
