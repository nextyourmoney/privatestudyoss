package Algorithm_0311;

import java.io.*;

//https://www.acmicpc.net/problem/2798
public class bronze_2798 {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String inputCardCount = br.readLine(); //카드의 장수N과 제한 수(가까울 수록 이기는 수)M을 입력한다.
			String[] cardCountArrStr = inputCardCount.split(" "); //배열에 N과 M을 입력하기 위한 배열 생성
			int[] cardCountArrInt = new int[2];
			
			for(int i = 0; i < 2; i++) {
				cardCountArrInt[i] = Integer.parseInt(cardCountArrStr[i]);
			}

			int cardCount = cardCountArrInt[0]; //카드의 장수
			
			String inputCardList = br.readLine(); //카드의 목록들을 입력한다.
			String[] cardListStr = inputCardList.split(" "); ///나열되는 카드를 위한 배열
			int[] cardListInt = new int[cardCount]; //첫줄에 선언 된 카드의 장수만큼의 배열을 생성
			
			for(int i = 0; i < cardCount; i++) {
				cardListInt[i] = Integer.parseInt(cardListStr[i]); //모든 카드리스트를 리스트로변꼉한다.
			}
			
			int result =0; //결과 값 비교를 위한 result
			int targetNum =  cardCountArrInt[1]; //딜러가외치는 숫
			 int addResult = 0;

	        //첫번째 카드
	        for (int i = 0; i < cardCount - 2; i++) {
	            //두번째 카드
	            for(int j = i + 1; j < cardCount - 1; j++) {
	                //세번째 카드
	                for(int k = j + 1; k < cardCount; k++) {

	                    //세 수의 합 : add
	                    addResult = cardListInt[i] + cardListInt[j] + cardListInt[k];

	                    //딜러가 부른 숫자와 일치하면 add return
	                    if( targetNum == addResult) {
	                    	System.out.println(addResult);
	                    	System.exit(0);
	               
	                    }

	                    //그렇지 않다면 최대한 근접하게 result 값에 넣어준다.
	                    if((result < addResult) && (addResult < targetNum)) {
	                        result = addResult;
	                    }
	                }
	            }
	        }
	        
	        System.out.println( result);
	       		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
