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
		ArrayList<Integer> hamburgerAndPeople = new ArrayList<Integer>(); 
		int result = 0;
		
		String hamPeople_str = br.readLine();
		for (int i = 0; i < N; i++) {
			if(hamPeople_str.charAt(i) == 'H') { //문자열에서 h가 같은 햄버거 있을 시 arraylist에 해당 위치값 i를 추가한다.
				hamburgerAndPeople.add(i); 
				visited[i]=true; //햄버거가 위치한 배열에 true로 변경
			}
		}
		
		for (int i = 0; i < hamburgerAndPeople.size(); i++) { //햄버거의 개수 만큼 반복
			for (int j = hamburgerAndPeople.get(i) - K; j <= hamburgerAndPeople.get(i) + K; j++) { //hamburgerAndPeople.get(i) - K은 햄버거의 위치 값에서 k만큼 뺸 것 즉 먹을 수 있는 최소 값의 햄버거
																								   //j <= hamburgerAndPeople.get(i) + K먹을 수 있는 가장 먼 햄버거의 위치 값	
																								   //즉 해당 햄버거 위치의 햄버거를 먹을 수 있는 모든 사람을 구할 수 있다.
				if(j < 0 || j >= N) { //-k에서 음수가 나오거나 값을 초과하는 경우는 종료 or 넘어간다.
					continue; 
				}
				
				if(visited[j] == false) { //위의 for에서 visited가 true인 위치는 햄버거이다. 즉 false라면 사람이기 떄문에 조건 만
					visited[j] = true; //사람이 먹었으므롬 바꿔준다. 
					result++;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
