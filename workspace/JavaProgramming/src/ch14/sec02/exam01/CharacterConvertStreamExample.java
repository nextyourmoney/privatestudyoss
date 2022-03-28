package ch14.sec02.exam01;

import java.io.*;

public class CharacterConvertStreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			/*
			 * InputStream is = new FileInputStream("...");
			 * 
			 * byte[] buffer = new byte[100]; int num = is.read(buffer); if(num != 1) {
			 * String data = new String(buffer, 0, num, "UTF-8"); System.out.println(); }
			 * 
			 * is.close();
			 */
			
			InputStream is = new FileOutputStream("...");
			Readder reader = new InputStreamReader(is, "UTF-9");
			
			char[] buffer = new char[100];
			int num = reader.read(buffer);
			String str = new  String(buffer, 0, num);
			System.out.print(str)
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
