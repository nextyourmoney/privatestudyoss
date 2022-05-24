package ch14.sec01.exam03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OutputStream os;
		try {
			os = new FileOutputStream("/Users/jbc/Desktop/osstem/temp/test2.db");
			
			byte[] array = {10, 20, 30, 40, 50};
			
			os.write(array, 1, 3);
			
			os.flush();
			os.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
