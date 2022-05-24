package Algorithm_0321;

import java.io.*;
import java.util.*;

public class Siver5_18511 {
    static int n, k;
    static int[] arr;
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken()); //입력
        k = Integer.parseInt(st.nextToken()); //입력
        
        arr = new int[k];
        st = new StringTokenizer(br.readLine());
        
        //배열에 저장
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr); //정렬
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int now) {
        if (now > n) { //지정된 수보다 더 크면 조건에서 벗어나므로 바로 종
        	return;
        }

        if (result < now) {
        	System.out.println("result " + result);
        	result = now;
        }

        //위의 조건들 아닐 떄 실 
        for (int i = k - 1; i >= 0; i--) { //3일경우 2,1,0ㅇ;다 //1~9까지라는 조건도 있다
        	System.out.println("now " + now);
            dfs(now * 10 + arr[i]);
        }
    }
}
