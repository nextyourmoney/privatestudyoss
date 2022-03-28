package appendix.lambda.exam04;

public class LabmdaExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person person  = new Person();
		
		person.action1((name, job) -> {
			System.out.println("name: " + name);
			System.out.println("job: " + job);
		});
		person.action1((name, job) -> System.out.println(name + "이" + job + "을 하지 않음"));

	}

}
