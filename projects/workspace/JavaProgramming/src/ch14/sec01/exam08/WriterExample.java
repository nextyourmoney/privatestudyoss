package ch14.sec01.exam08;

import java.io.FileWriter;
import java.io.Writer;

public class WriterExample {



		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Writer writer = new FileWriter(".....");
			
			char[] array = {'A', 'B', 'C'};
			
			writer.write(array);
			

			
			writer.flush();
			writer.close();

		}

}
