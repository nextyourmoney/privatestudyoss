package ch14.sec02.exam03;

import java.io.*;

public class ReadLIneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStream is = new FileInputStream(" ...");
			Reader reader = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			
			String str = br.readLine();
			System.out.println(str);		
			
			reader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
