package appendix.generic.exam04;

public class genericExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Box<Product<String, String>> box1 = new Box<>();
		Product<String, String> p1 = new Product<> ();
		p1.setKind("TV");
		p1.setModel("SmarTv");
		box1.content = p1;
		
		Box<Product<String, String>> box2 = new Box<>();
		Product<String, String> p2 = new Product<> ();
		p1.setKind("TV");
		p1.setModel("SmarTv");
		box2.content = p2;
		
		boolean result = box1.compare(box2);
		System.out.println(result);
		

	}

}
