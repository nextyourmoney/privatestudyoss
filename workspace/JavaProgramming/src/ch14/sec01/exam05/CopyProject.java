package ch14.sec01.exam05;

import java.io.*;

public class CopyProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			InputStream is = new FileInputStream("/Users/jbc/Desktop/osstem/temp/ReadImage.PNG");
			OutputStream os = new FileOutputStream("/Users/jbc/Desktop/osstem/temp/ReadImage2.PNG");
			
			byte[] buffer = new byte[1000];
			
			while(true) {
				int readByteNum = is.read(buffer);
				if(readByteNum == -1) break;
				os.write(buffer, 0, readByteNum);
				
			}	
			
			os.flush();
			is.close();
			os.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
