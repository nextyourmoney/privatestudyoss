package BookHomeWork.ch05_Verify;

//201p 5번
public class ch05_HomeWork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			for(int num: array[i]) {
				sum += num;
				count += 1;
			}
		}
		avg = (double) sum / count;
		
		
		
		System.out.println("sum: " + sum);
		System.out.println("avg: " + avg);

	}

}
