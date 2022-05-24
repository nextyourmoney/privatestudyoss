package Algorithm_0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_1051 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //첫번째 숫자
		int M = Integer.parseInt(st.nextToken()); //두번째 숫자
		int arr[][]= new int[N][M]; //값이 들어갈 배
		
		for (int i = 0; i < N; i++) {
			String inputNum = br.readLine(); //매 줄마다 문자열들을 입력 받는다. 
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = inputNum.charAt(j); //각각의 열에 해당 문자열을 삽입한다.																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		
			}
		}
		
		int ans = 1;
		int size = Integer.min(N, M);
		
		for (int k = 2; k <= size; k++) { //최소 2이므로 2부터 시작
			for (int i = 0; i < N-k+1; i++) {
				for (int j = 0; j < M-k+1; j++) {
					if(arr[i][j]==arr[i+k-1][j]&&arr[i][j]==arr[i][j+k-1]&&arr[i][j]==arr[i+k-1][j+k-1]) {
						if(ans<k) {
							ans = k;
						}
					}
				}
			}
		}
		
		System.out.println(ans*ans);
	}
}
