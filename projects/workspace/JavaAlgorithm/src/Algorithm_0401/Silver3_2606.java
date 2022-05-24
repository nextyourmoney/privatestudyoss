package Algorithm_0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver3_2606 {
	
	static int count = 0;
	static int computerLink[][];
	static boolean[] check;
	static int computerNum;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		computerNum = Integer.parseInt(br.readLine()); //컴퓨터의 대수
		int lineNum = Integer.parseInt(br.readLine()); //연결된 선의 수
		
		
		computerLink = new int[computerNum + 1][computerNum + 1 ]; //연결의 상태가 들어간 이중배열
		check = new boolean[computerNum + 1];//컴퓨터의 대수 만큼 체크 여부의 배열크기 정의,
		
		for(int i = 0; i < lineNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int linkFirst = Integer.parseInt(st.nextToken());
			int linkSecond = Integer.parseInt(st.nextToken());	
			
			computerLink[linkFirst][linkSecond] = computerLink[linkSecond][linkFirst] = 1; //이면 연결 되어있다.true) //1-2연결이나 2-1연결이나 같기 때문에 같은 1로 선언;
			
		}
		
		dfs(1); //무조건 1번 컴퓨터에서 시작한다.
		
		System.out.println(count-1); //1번 컴퓨터는 기본 디폴트 값이므로 1을빼준다. 
	}
		
		public static void dfs(int start) {
			check[start] = true; //감염되었다. 
			count++; //감염대수 증가
			
			for(int i = 1 ; i <= computerNum ; i++) { //실질적으로 배열에서 인덱스 0은 빈값이다.
				if(computerLink[start][i] == 1 && check[i] == false) //현재 컴퓨터와 연결되어있고 감염여부에서 감염되어있지 않다면 dfs를 실행시키는데 이 때 시작은 현재 연결된 컴퓨터 i이다.
					
					dfs(i);
			}
			
		}
}
		
		
		
		
		
	
	
