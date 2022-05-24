package Algorithm_0310;
import java.util.Scanner;
import java.util.Stack;

public class silver_10828 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
	    int num = Integer.parseInt(scanner.nextLine());
	    String[] test = new String[num];
	    Stack<Integer> stack = new Stack<>(); //스택 선언
	
	    
	    for (int i = 0; i < num; i++) {
	    	test[i] = scanner.nextLine();
	    }
	    	
	    	
	    for(String numArr1 : test) {
	        String[] numArr = numArr1.split(" ");
	
	        switch (numArr[0]) {
	            case "push": //스택에 넣는다
	            	int inNum = Integer.parseInt(numArr[1]);
	            	stack.push(inNum);
	                
	                break;
	                
	            case "pop": //출력 후 삭제
	            	if(stack.peek() != null) {
	            		stack.peek(); //스택최상단 값 출력
		            	stack.pop(); //스택 최상단 삭제
	            	} else {
	            		System.out.println("-1");
	            	}
	            	
	                
	                break;
	            case "size":
	            	System.out.println(stack.size()); //사이즈 출력
	               
	                break;
	            case "empty":
	            	if(stack.empty()) { //스택이 비어있다면 true반환
	            		System.out.println("1");
	            		
	            	} else {
	            		System.out.println("0");
	            	}
	                
	                break;
	            case "top":
	            	if(stack.peek() != null) {
	            		stack.peek(); //스택최상단 값 출력
		            	
	            	} else {
	            		System.out.println("-1");
	            	}
	               
	                break;
	        }
	
	    }

	}

}
