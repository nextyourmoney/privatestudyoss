package ch14.sec01.exam09;

import java.io.FileWriter;
import java.io.Writer;

public class WriterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Writer writer = new FileWriter("...");
		
		char[] array = {'A', 'B', 'C', 'D', 'E'};
		
		writer.write(array, 1, 3);
		
		writer.flush();
		writer.close();
		
		

	}

}
