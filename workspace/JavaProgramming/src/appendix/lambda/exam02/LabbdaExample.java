package appendix.lambda.exam02;

public class LabbdaExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		
		person.action(() -> {
			System.out.println("출근을 합니다");
			System.out.println("프로래밍을 합니다");
		});
		
		person.action(() -> System.out.println("퇴근을 합니다"));

	}

}
