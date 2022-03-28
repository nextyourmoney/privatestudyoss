package appendix.lambda.exam06;

public class ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person person = new Person();
		
		person.action(Computer :: staticMethod);
		
		Computer com = new Computer();
		
		person.action(com :: instanceMethod);

	}

}
