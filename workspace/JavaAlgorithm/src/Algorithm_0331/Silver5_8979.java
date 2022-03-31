package Algorithm_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Silver5_8979 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stt.nextToken()); //참여한 국가 
        int K = Integer.parseInt(stt.nextToken()); //조회 할 국가 번
        int[][] numArr = new int[N][4]; //국가의 수 만큼 배열선언 각 국가에는 번호와 메달 3개이므로 배열이 들어가는 이중 배열
        
        for(int i = 0; i < N; i++) {
        	String[] medalInfor = br.readLine().split(" ");//문자열 입력 받음 국가 번호, 금메달 수, 은메달 수, 동메달 
        	
        	for(int j = 0; j < 4; j++) {
        		numArr[i][j] = Integer.parseInt(medalInfor[j]);	
        	}
        	
        }
        
        Arrays.sort(numArr, new Comparator<int[]>(){  //이중 배열 정
        	@Override 
        	public int compare(int[] o1, int[] o2) {

	        	if(o1[1] == o2[1]){ //첫번째(금메달)의 수가 같을 떄 
	        		if(o1[2] == o2[2]) { //은메달이 같은 때 
	        			return o2[3] - o1[3]; //동메달 개수로 비교 //내림차
	        		} else {
	        			return o2[2] - o1[2]; //은메달 개수로 비교 //내림차순
	        		}
	        	} else{ //금메달 개수로 비교 //내림차순
	        		return o2[1] - o1[1]; 
	        	} 
        	}
        });
        /*
        System.out.println("test");
        for (int i = 0; i <N; i++) { // 행 반복
			for (int j = 0; j < 4; j++) { // 열 반복
				System.out.print(numArr[i][j]);
			}
			System.out.printf("\n");
		}
        */
		
        
        
        
        int rank = 1;
        int[] arr2 = new int[3];
        arr2[0] = numArr[0][1];
 	   	arr2[1] = numArr[0][2];
 	   	arr2[2] = numArr[0][3];
 	   	
 	   	if(K == numArr[0][0]) {
 	   		System.out.println(rank);
 	   	
 	   		
 	   	} else {
 	   	
	 	   	for(int i = 1; i < N; i++) {
	    	   int[] arr1 = new int[3];
	    	   arr1[0] = numArr[i][1];
	    	   arr1[1] = numArr[i][2];
	    	   arr1[2] = numArr[i][3];
	    	   
	    	   if(Arrays.equals(arr1, arr2)) {
	    		   if(K == numArr[i][0]){
		    		   System.out.println(rank);
		    		   break;
		    	   } else {
		    		   arr2[0] = numArr[i][1];
		    	 	   arr2[1] = numArr[i][2];
		    	 	   arr2[2] = numArr[i][3];
		    	   }
	    		   
	    	   } else {
	    		   rank++;
	    		   arr2[0] = numArr[i][1];
	    	 	   arr2[1] = numArr[i][2];
	    	 	   arr2[2] = numArr[i][3];
	    	 	  //System.out.println(rank);
	    	   }
	       }
	 	   	
	 	   System.out.println(rank);
 	   	}

        
        
	}

}
