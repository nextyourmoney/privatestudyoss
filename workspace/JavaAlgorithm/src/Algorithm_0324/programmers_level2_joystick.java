package Algorithm_0324;

public class programmers_level2_joystick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.solution("JEROEN"));
		
		
	}
	
	

}

class Solution {
    public int solution(String name) {
        int answer = 0;
        int nameLength = name.length(); //문자 길이
        int[] arr = new int[nameLength];
        
        // 제일 짧은 좌, 우 이동은 그냥 맨 오른쪽으로 이동할 때
        int min = nameLength - 1; //단어 길이가 7이면 6번 이동이 가장 적은이동 값이다.
        
        //아스키 코드 65 ~ 90
        for(int i = 0; i < nameLength; i++) {
        	arr[i] = name.charAt(i); //한글자씩 가져와서 배열에 저장 //아스키 코드로 저장됨
        }
        
        for(int i = 0; i < arr.length; i++) { //상하 이동 
        	int nextmove = i + 1;
        	
        	if(arr[i] - 'A' < 'Z' - arr[i]) { //A와 Z에서 문자열의 아스키값을 뺴서 값이 더 큰쪽이 이동을 더 많이 해야한다. //이 조건의 경우 A에 더 가깝다는 의미이다. 
        									  //두수의 차이만큼 위로 이동한다.
        		answer += arr[i] - 'A';
        	
        		System.out.println("A: " + answer);
        		// 다음 단어가 A이고, 단어가 끝나기 전까지 nextIndex 증가 //중복되는 A의 개수를 구한다.  // BBBAAAAAAAAABBB에서 A가5
        	    while (nextmove < nameLength && name.charAt(nextmove) == 'A') {
        	      nextmove++;
        	    }
        		System.out.println("left: " + min);
        	    min = Math.min(min, (i * 2) + nameLength - nextmove);
        	    min = Math.min(min, (nameLength - nextmove) * 2 + i);
        		
        	    
        		
        	} else { //z에 더 가까울 때
        		answer += 'Z' - arr[i] + 1;
        		
        		System.out.println("Z: " + answer);
        	    // 다음 단어가 A이고, 단어가 끝나기 전까지 nextIndex 증가 //중복되는 A의 개수를 구한다.  // BBBAAAAABBBBB에서 A가5
        	    while (nextmove < nameLength && name.charAt(nextmove) == 'A') {
        	      nextmove++;
        	    }
        	    System.out.println("left: " + min);
        	    min = Math.min(min, (i * 2) + nameLength - nextmove);
        	    min = Math.min(min, (nameLength - nextmove) * 2 + i);
        	}
        	
        	
        	
        	
        }
        
        return answer + min;
        
 
    }
}
