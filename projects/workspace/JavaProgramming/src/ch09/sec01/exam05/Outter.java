package ch09.sec01.exam05;

public class Outter {
	String field = "fsdjf";
	void method() {
		System.out.println("Oadlsfjk");
	}
	
	class Nested{
		String field = "fjkldsf";
		void method() {
			System.out.println("dkfkf");
			
		}
		
		void print() {
			System.out.println(this.field);
			this.method();
			
			System.out.println(Outter.this.field);
			Outter.this.method();
		
		}
		
	
		}
	}


