package Algorithm_0324;
//https://www.acmicpc.net/problem/11047

import java.io.*;
import java.util.StringTokenizer;

public class Sillver3_1107 {

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int resultCount = 0; //결과를 위한 동전의 개수
		
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int coinCount = Integer.parseInt(str.nextToken()); //동전개수
		int targetNum = Integer.parseInt(str.nextToken()); //목표 금액
		
		int[] numArr = new int[coinCount]; //금액들이 들어갈 배열 선언
		for(int i = 0; i < coinCount; i++) {
			numArr[i] = Integer.parseInt(bfr.readLine()); //각 동전의 값 입력
		}
		
		int remainAmount = targetNum; //계산을 위해 나눈 후 남는 금액을 선언하는데 최초에는 목표금액으로 설정한다.
		for(int i = coinCount - 1; i >= 0; i--) { //뒤에서부터 반복을 시작한다.
			if(remainAmount / numArr[i] > 0 ){ //최대 금액으로 목표금액을 나눌 수 있다. //반복을 줄일 수 있다.
				 resultCount += remainAmount / numArr[i]; //동전의 개수를 나누기 한 몫까지 나누
				 remainAmount = remainAmount % numArr[i]; //나눈 후 나머지 금액 
					 
			} else if(remainAmount / numArr[i] == 0) { //입력 금액 중 최대치보다 목표 금액이 작다는 소리이므로 최대로 나눌 수 있는 값을 찾을때까지 반복한다.
				continue;
			}
			
		}
		System.out.println(resultCount);
	
	}

}
