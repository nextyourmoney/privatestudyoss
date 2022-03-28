package ch14.sec01.exam04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.omg.CORBA.portable.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream is;
		try {
			is = new FileInputStream("...");
			
			while(true) {
				int data = is.read();
				if(data == -1) break;
				System.out.println(data);
				
			}
			
			is.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
