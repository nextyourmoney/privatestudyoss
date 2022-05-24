package ch14.sec02.exam04;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class DataInputOutputStreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileOutputStream fos = new FileOutpuStream("...");
		DataOutputStream dos = new DataOutpuStream(fos);
		
		dos.writeUTF("dffafdl");
		dos.writeDouble(95.5);
		dos.writeInt(1);
		
		dos.writeUTF("fkfkf");
		dos.writeDouble(90.3);
		dos.writeInt(2);
		
		dos.flush(); dos.close();
		FileInputSteam fis = new FileInputStream("...");
		DataInputStream dis = new DataInputStream(fis);
		
		for(int i = 0; i<2; i++) {
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			
			System.out.println(name + ":" + score + ":" + order);
			
		}
		
		dis.close();
		

	}

}
