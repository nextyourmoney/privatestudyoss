package ch14.sec02.exam03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AddLineNumberExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		String filePath = "...";
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		
		int count = 0;
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			count++;
			line = count + ": " + line;
			System.out.println(line);
			
		}
		
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
