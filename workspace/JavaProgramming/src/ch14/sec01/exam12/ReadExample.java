package ch14.sec01.exam12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Reader reader = new FileReader("...");
			
			char[] buffer = new char[100];
			
			while(true) {
				int readCharNum = reader.read(buffer);
				if(readCharNum == -1)break;
				for(int i = 0; i < readCharNum; i++) {
					System.out.println(buffer[i]);
				}
			}
			
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
