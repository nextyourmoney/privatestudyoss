package ch14.sec03.exam03;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("...");
		File file1 = new File("...");
		File file2 = new File("...");
		File file3 = new File("...");
		
		if(dir.exists() == false) { dir.mkdir();}
		try {
			if(file1.exists() == false) { file1.createNewFile();}
			if(file2.exists() == false) { file1.createNewFile();}
			if(file3.exists() == false) { file1.createNewFile();}
			
			File temp = new File("...");
			File[] contents = temp.listFiles();
			
			System.out.println("시간 \t\t\t형태 \t\t 크기 \t 이름");
			System.out.println("-------");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd-a hh:mm");
			
			for(File file : contents) {
				System.out.print(sdf.format(new Date(file.lastModified())));
				if(file.isDirectory()) {
					System.out.print(file.getName());
				} else {
					System.out.print(file.getName());
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
