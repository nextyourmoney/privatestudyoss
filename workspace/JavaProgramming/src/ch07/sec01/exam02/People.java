package ch07.sec01.exam02;

public class People {
	public String name;
	public String ssn;
	
	//생성자
	public People(String name, String ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}
	
	public People()
	{
		System.out.println("People2");
	
	}
	

}
