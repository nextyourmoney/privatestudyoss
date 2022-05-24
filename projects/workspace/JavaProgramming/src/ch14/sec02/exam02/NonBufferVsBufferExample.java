package ch14.sec02.exam02;

import java.io.*;

public class NonBufferVsBufferExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String originalFilePath1 = NonBufferVsBufferExample.class.getResource("ReadImage.png").getPath();
			String targetFilePath1 = "/Users/jbc/Desktop/osstem/temp/ReadImage.png";
			
			//기본 스트림만 생성
			FileInputStream fis = new FileInputStream(originalFilePath1);
			FileOutputStream fos = new FileOutputStream(targetFilePath1);
			
			//버퍼를 제공하는 보조 스트림 생성 
		/*	FileInputStream fis2 = new FileInputStream(originalFilePath1);
			FileOutputStream fos2 = new FileOutputStream(targetFilePath1);
			BufferedInputStream bis = new BufferedInputStream(fis2);
			BufferedOutputStream bos = new BufferedOutputStream(fos2);*/
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(originalFilePath1));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFilePath1));
		
			//복사 시간 측정
			long time1 = copy(fis, fos);
			long time2 = copy(bis, bos);
			System.out.println(time1 + "ns");
			System.out.println(time2 + "ns");
				
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		
	public static long copy(InputStream is, OutputStream os) throws IOException{
		long start = System.nanoTime();
			
		while(true) {
			int data = is.read();
			if(data == -1) break;
			os.write(data);
		}
		
		os.flush();
			
		long end = System.nanoTime();
		return (end - start);
			
	}
		
}


