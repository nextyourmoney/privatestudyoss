package Algorithm_0316;

import java.util.Scanner;

//https://www.acmicpc.net/problem/7568
public class Silver5_7568 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String humancount = scanner.nextLine();
		int humanCountNum = Integer.parseInt(humancount);
		
		int[][] heightAndWeight = new int[humanCountNum][2];
		
		for(int i = 0; i < humanCountNum; i++) {
			String[] heightAndWeightArr = scanner.nextLine().split(" ");
			heightAndWeight[i][0] = Integer.parseInt(heightAndWeightArr[0]);
			heightAndWeight[i][1] = Integer.parseInt(heightAndWeightArr[1]);
		}
		
		for(int i = 0; i < humanCountNum; i++) {
			int rank = 1;
			
			for(int j = 0; j < humanCountNum; j++) {
				if(i == j) { //같은 사람이니까 패스한다.
					continue;
				}
				if (heightAndWeight[i][0] < heightAndWeight[j][0] && heightAndWeight[i][1] < heightAndWeight[j][1]) {
					rank++; //조건을 만족할 경우에만 i번째 사람의 순위가 그만큼 상승한다. 즉 i가 만난 사람이 본인보다 덩치가 더 큰것이기 때문
				}
			}
 
			System.out.print(rank + " "); //i의 랭
		}
		
	}

}
