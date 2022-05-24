package homeworkAlgorithm.feb21Mon;

import java.util.*;

public class HomeWork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine()); //입력 될 줄의 개수
        int[][] procession = new int[n][n]; //위치 값들의 저장을 위한 행렬구조형태의 이차원 배열
        long[][] position = new long[n][n]; //경로개수 확인을 위한 이차원 배열 //경로의 개수가 2^63 - 1로 정
        position[0][0] = 1; //경로 개수의 확인을 위한 것이므로 첫번쨰 값은 1로 시작이다. //시작은 1과 같으므로

        for(int i = 0; i < n; i++) { //행렬구조 입력 //행
        	 String[] inputNumStringArr = scanner.nextLine().split(" "); //문자열로 입력
        	 
            for(int z = 0; z < n; z++) {//열
                int inputNum = Integer.parseInt(inputNumStringArr[z]);//정수로 변환

                procession[i][z] = inputNum; //행렬구조에 저장
            }
        }

        for(int i = 0; i < n; i++) {
            for(int z = 0; z < n; z++) {
                int moveValue = procession[i][z]; //이동할 값

                if(moveValue == 0){ //0이 되면 종료
                    break;
                }
                
                if(i + moveValue < n ) { //현재의 위치에서 이동해도 행렬의 크기보다 작을 때 즉 열방향(세로) 방향 이동이 가능 할 때
                                         // break나 continue를 주지 않고 if문을 여러개 주었기 때문 다음 조건문이 실행된다.
                    position[i + moveValue][z] += position[i][z]; 
                }
                
                if(z + moveValue < n) {  //현재의 위치에서 이동해도 행렬의 크기보다 작을 때 즉 행방향(가로) 방향 이동이 가능 할 때
                    position[i][z + moveValue] += position[i][z];
                }
            }
        }
        System.out.println(position[n-1][n-1]); //경로개수 n-1, n-1이 가장 우측 하단의 값이다. //이는 procession또한 마찬가지
    }
}
