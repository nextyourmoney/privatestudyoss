package ch14.sec02.exam01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamToWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			OutputStream os = new FileOutputStream(",,,");
			OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");
			
			
			String data = "qhhqhq";
			writer.write(data);
			
			
			//byte[] bytes = data.getBytes("UTF-8");
			//os.write(bytes);
			os.flush();
			os.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
