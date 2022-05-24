package ch14.sec03.exam01;

import java.io.*;

public class GetLineStringFromKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			InputStream is = System.in;
			Reader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			
			while(true) {
				System.out.println("입력하세요: ");
				String lineStr = br.readLine();
				if(lineStr.equals("q") || lineStr.equals("quit")) break;
				System.out.print(lineStr);
				
			}

			br.close();
		} catch(IOException e) {
			
		}
	}

}
