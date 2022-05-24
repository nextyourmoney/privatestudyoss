package ch14.sec02.exam05;

import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("...");
		PrintStream ps = new PrintStream(fos);
		
		ps.println("smsms");
		ps.println("smsmds");
		ps.println("smfdasms");
		ps.println("smfasdfsms");
		
		ps.flush();
		ps.close();
		
		FileInputStream fis = new FileInputStream("...");
		Reader reader = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(reader);
		
	}

}
