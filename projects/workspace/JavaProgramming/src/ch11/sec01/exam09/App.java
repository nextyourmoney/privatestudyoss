package ch11.sec01.exam09;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class clazz = App.class;
		String image1Path = clazz.getResource("pg.jpeg").getPath();
		System.out.println(image1Path);
		
		String image2Path = clazz.getResource("image2/pg.jpeg").getPath();
		System.out.println(image2Path);
		


		

	}

}
