package Algorithm_0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Silver3_2108 {
 
	/*
	산술평균 : N개의 수들의 합을 N으로 나눈 값 // 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
	중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
	최빈값 : N개의 수들 중 가장 많이 나타나는 값 //여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
	범위 : N개의 수들 중 최댓값과 최솟값의 차이
	단 N은 홀수
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());  //홀수 입력
		int[] numArr = new int[N]; //숫자가 들어간 배열 입력 //ArrayList와 비교 했을 떄 속도차이가 없을 것이라 판단
		int[] resultArr = new int[4]; //4가지의 결과 값이 들어갈 배열
		
		for(int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(br.readLine()); //배열에 숫자 목록들 삽입
		}
		
		//산술평균 계산
		int result1 = 0;
		for(int i : numArr) {
			result1 += i;
		}
		System.out.println(Math.round(result1/N));
		
		//중앙값
		Arrays.sort(numArr); //정렬
		int centerNum = Math.round(N/2); // 반올림
		System.out.println(numArr[centerNum]); 
		
		//최빈값 //mine
		//HashMap<Integer, Integer> map = new HashMap<>(); //숫자를 key로 주고 빈도수를 value로준다.
		/*int count = 1;
		
		for(int i = 1; i < N; i++) {
			if (numArr[i - 1] != numArr[i]) { //숫자가 달라질 때 혹은 마지막 값일 
				if(i == N - 1) { //마지막일
					map.put(numArr[i], count);	
				}
				map.put(numArr[i-1], count);	
				count = 1; //초기
			} else { //같은 숫자일때 개수를 증가시킨다.
				count ++;
			}
		}*/
		
		//참고 코드
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int str : numArr) {
			Integer count = map.get(str);
			if (count == null) {
				map.put(str, 1);
			} else {
				map.put(str, count + 1);
			}
		}
		
//		for (Integer key : map.keySet()) {
//			System.out.println(key + " : " + map.get(key));
//			}
		int Mode = 0;
		if(map.size() >= 2) {
			Mode = map.get(1);
		}
		else {
			Mode = map.get(0);
		}
		
		System.out.println(Mode);
		
		//범위
		int bum = numArr[N - 1] - numArr[0];
		System.out.println(bum);
		
			
	}
}
