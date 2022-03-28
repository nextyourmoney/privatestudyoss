package Algorithm_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



////씨이이이발 대가리가 안돌아간다!!!!!
public class Silver3_19941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); //입력 문자열 분리 및 입력
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N];
		ArrayList<Integer> hamburger = new ArrayList<Integer>(); 
		int result = 0;
		
		String hamPeople = br.readLine();
		for (int i = 0; i < N; i++) {
			if(hamPeople.charAt(i) == 'H') { //문자열에서 h가 같은 햄버거 있을 시 연결 리스트에 햄버거 위치 값에 붙이
				hamburger.add(i);
				visited[i]=true; //
			}
		}
		
		for (int i = 0; i < hamburger.size(); i++) {
			for (int j = hamburger.get(i) - K; j <= hamburger.get(i) + K; j++) {
				if(j < 0 || j >= N) {
					continue;
				}
				
				if(visited[j] == false) {
					visited[j] = true;
					result++;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
