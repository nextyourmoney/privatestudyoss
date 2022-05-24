package BookHomeWork.ch05_Verify;

//200p 4
public class ch05_HomeWork1 {

	public static void main(String[] args) {
		int max = 0;
		int[] array = {1, 5, 3, 8, 2, 10};
		
		for(int num: array) {
			if(num > max) {
				max = num;
			}
			
		}
		
		System.out.println("max:" + max);

	}

}
