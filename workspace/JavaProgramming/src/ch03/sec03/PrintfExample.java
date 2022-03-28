package ch03.sec03;

public class PrintfExample {
	public static void main(String[] args) {
		int value = 123;
		int value2 = 100;
		
		System.out.printf("상품의 가격: %d\n",value);
		System.out.printf("상품의 가격: %s\n",value);
		System.out.printf("상품의 가격: %6d\n",value);
		System.out.printf("상품의 가격: %-6d\n",value);
		System.out.printf("상품의 가격: %10.2f\n",(double)value);
		System.out.printf("상품의 가격: %1$d 이고 나눈 가격: %2$d\n",value,value/10);
		System.out.printf("상품의 가격: %1$d 이고 나눈 가격: %2$d\n "
				+ "원의 계산:%3$10.3f\n",value,value/10, 3.14*10);
		
		String name = "길";
		String job = "도적";
		
		System.out.printf("%d:%2$3s:%3$-3s",1,name,job);
		
		
		
	}
	
}
