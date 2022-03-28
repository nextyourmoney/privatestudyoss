package homeworkAlgorithm.feb21Mon;

import java.util.*;

public class HomeWordk1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		int result = 1; //테이프의 개수
		
		String[] firstLine = scanner.nextLine().split(" "); //물이 새는 장소의 개수와 테이프의 길이
		String[] secondLine = scanner.nextLine().split(" "); //물이 새는 위
		
		int positionCount = Integer.parseInt(firstLine[0]); //물이 새는 장소의 개수
		int tapeLength = Integer.parseInt(firstLine[1]); //테이프의 길이
		double range = Integer.parseInt(secondLine[0]) - 1 + tapeLength; //+0.5, -0.5의 차이이므로 1만큼 차이난다.
	
		for(int i = 1; i < positionCount; i++) { //첫 값의 다음 값부터 비교하기 위해 i는 1부터시작 
			if(range < Integer.parseInt(secondLine[i])) {//테이프의 길이 내에서 숫자가 들어갈 경우 갯수를 늘릴 필요가 없고 범위가 벗어날때만 시작 값을 새로 정하고 카운트를 늘려주면된다.
				range = Integer.parseInt(secondLine[i]) - 0.5 + tapeLength;
				result++;
			 }
		}
		System.out.println(result);
	}
}
