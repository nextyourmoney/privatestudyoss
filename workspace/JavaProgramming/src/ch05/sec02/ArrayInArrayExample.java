package ch05.sec02;

public class ArrayInArrayExample {

	public static void main(String[] args) {
		int[][] mathScores = mathScores = new int[2][3];
		
		for(int i = 0; i < mathScores.length; i++) {
			for(int k = 0; k < mathScores[i].length; k++) {
				System.out.println("mathScores["+i+"]["+k+"]=" + mathScores[i][k]);
			}
		}
		System.out.println();
		
		int [][] englishScores = new int[2][];
		englishScores[0] = new int[2];
		
		englishScores[1] = new int[3];
		for(int i = 0; i < englishScores.length; i++) {
			for(int k = 0; k < englishScores[i].length; k++) {
				
			}
			
		}
		
		System.out.println("");
		
		int[][] javaScores = {{95, 80},{92, 86, 80}};
		javaScores[0] = new int[2];
		
		javaScores[1] = new int[3];
		for(int i = 0; i < javaScores.length; i++) {
			for(int k = 0; k < javaScores[i].length; k++) {
				
			}
			
		}
	}

}
