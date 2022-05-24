import ch11.sec01.exam05.*;

public class BoardExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Board b1 = new Board(1, "title1", "content1", "writer1", 0);
		Board b2 = new Board(1, "title1", "content1", "writer1", 0);
		
		System.out.println(b1.hashCode() == b2.hashCode());
		System.out.println(b1.equals(b2));
		System.out.println(b1.toString());

	}

}
