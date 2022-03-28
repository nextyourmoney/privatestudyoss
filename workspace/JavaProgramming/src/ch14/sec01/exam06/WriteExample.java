package ch14.sec01.exam06;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Writer Writer = new FileWriter(".....");
		
		char a = 'A';
		char b = 'B';
		char c = 'C';
		
		Writer.write(a);
		Writer.write(b);
		Writer.write(c);
		
		Writer.flush();
		Writer.close();

	}

}
