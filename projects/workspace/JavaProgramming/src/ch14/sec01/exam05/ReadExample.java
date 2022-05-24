package ch14.sec01.exam05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.omg.CORBA.portable.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream is;
		try {
			is = new FileInputStream("/Users/jbc/Desktop/osstem/temp/test2.db");
			

			byte[] buffer = new byte[100];
			
			//while(true) {
				int readByteNum = is.read(buffer);
				if(readByteNum == -1);
				
				for(int i = 0; i< readByteNum; i++) {
					System.out.println(buffer[i]);
				}
			//}
			
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
