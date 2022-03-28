package ch14.sec01.exam01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;



public class WriteExmaple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		OutputStream os = new FileOutputStream("/Users/jbc/Desktop/osstem/temp/test.db");
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		os.write(a);
		os.write(b);
		os.write(c);
		
		os.flush();
		os.close();
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
