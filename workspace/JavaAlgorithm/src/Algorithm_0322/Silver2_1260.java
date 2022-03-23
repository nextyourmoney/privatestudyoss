package Algorithm_0322;

import java.io.*;
import java.util.StringTokenizer;

//DFS 깊이 우선 탐색 //루트 노드(혹은 다른 임의의 노드)에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법
//BFS 넓이 우선 탐 //루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법


public class Silver2_1260 {
	
	static StringTokenizer st;
	static boolean visited[]; //방문을 완료한 값들의 배
	static String dfsResult;
	static int lineArr[][];
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(bfr.readLine());  //split으로 쪼개기
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //선의 개수
        int begin = Integer.parseInt(st.nextToken()); //시작 위치
        
        lineArr =  new int[N + 1][N + 1]; //이중배열의 크기를 선언한다. //0은 비우고 1부터 시작한다. 햇갈려
        visited = new boolean[N + 1]; //1부터 시작하기 위해서 +1을 기준으로 시작한다.
		
        for(int i = 0; i<  M; i++){
        	st = new StringTokenizer(bfr.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lineArr[x][y] = lineArr[y][x] = 1; //간선이 있는 곳에 1을 삽입한다. //그외으ㅢ 곳은 default 0이다.
            									/*  0111
            									 *  1001
            									 *  1001
            									 *  1110
            									 */
        }
        
        dfs(begin);
        bfw.write(dfsResult.toString());
        
	}
	
	static void dfs(int begin){
		System.out.println(begin);
        visited[begin] = true;
        dfsResult += Integer.toString(begin) + " "; //결과에 입력된ㄷ.
        
        for(int i = 1; i < N + 1; i++){
            if(lineArr[begin][i] == 1 && visited[i] == false){ //아직 방문하지 않고 위의 배열에서 연결이 되어 있을 경우에 된다. 단 오름차순으로만 적용된다.
                dfs(i);
            }
        }
    }

}
