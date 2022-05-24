
package ch12.sec01.exam27;

import java.util.*;

public class MathRandomExample {
	public static void main(String[] args) {
		Random r1 = new Random();
		int var1 = r1.nextInt(10);
		System.out.println(var1);
		
		Random r2 = new Random();
		int var2 = r2.nextInt(10);
		System.out.println(var2);
	}

}
