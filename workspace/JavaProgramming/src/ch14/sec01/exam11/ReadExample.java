package ch14.sec01.exam11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Reader reader = new FileReader("...");
			
			while(true) {
				int data = reader.read();
				if(data == -1) break;
				System.out.println((char) data);
			}
			
			reader.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
