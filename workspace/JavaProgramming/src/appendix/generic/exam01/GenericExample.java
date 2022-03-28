package appendix.generic.exam01;

public class GenericExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Box<String> box = new Box<String>();
		Box<String> box = new Box<>();
		
		Box<Clock> box3 = new Box<>();
		box3.content = new Clock();
		Clock content3 = box3.content;
	}

}
