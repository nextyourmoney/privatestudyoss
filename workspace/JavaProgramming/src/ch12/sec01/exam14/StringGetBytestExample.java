package ch12.sec01.exam14;

import java.io.*;

public class StringGetBytestExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "안녕하세요";
		
		//인코딩
		
		try {
			//byte[] bytes1;
			//bytes1 = str.getBytes("UTF-8");
			
			byte[] bytes1 = str.getBytes("UTF-8");
			System.out.println(bytes1.length);
			
			
			//디코딩
			String str2 = new String(bytes1, 0, 6, "UTF-8"); //문자열의 늑정 지역만 디코
			String str3 = new String(bytes1, 0, bytes1.length, "UTF-8"); //문자열의 늑정 지역만 디코
			System.out.println(str2);
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
