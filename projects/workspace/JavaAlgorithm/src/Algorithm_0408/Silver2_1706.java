package Algorithm_0408;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Silver2_1706 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken()); //가로 크기를 입력 받느다
		int C = Integer.parseInt(st.nextToken()); //세로 크기를 입력받는다.
		
		String[][] crossWord = new String[R][C];

		for(int i = 0; i < R; i++ ) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				crossWord[i][j] = String.valueOf(line.charAt(j));
			}
		}
		
		ArrayList words = new ArrayList();
		
		//가로 단어 찾기
		for(int i = 0; i < R; i++) {
			String word = "";
			
			for(int j = 0; j < C; j++) {
				if(crossWord[i][j].equals("#") && word.length() > 1) { //단어의 최소 단위를 만족했을 경우
					words.add(word); //단어 리스트에 현재까지 완성된 단어를 추가한다. 
					word = ""; //이후 단어 초기화
					
				} else if(!crossWord[i][j].equals("#")) {
					word += crossWord[i][j]; //문자일 경우 단어 완성을 위해 연결한다.
				} else if(crossWord[i][j].equals("#") && word.length() == 1) { //단어의 최소 단위를 만족했을 경우
					word = ""; //이후 단어 초기화
					
				} 
			}
			if(word.length() > 1) {
				words.add(word);
			}
		}
		

		//세로 단어 찾
		for(int j = 0; j < C; j++) {
			String word = "";
			for(int i = 0; i < R; i++) {
				if(crossWord[i][j].equals("#") && word.length() > 1) { //단어의 최소 단위를 만족했을 경우
					words.add(word); //단어 리스트에 현재까지 완성된 단어를 추가한다. 
					word = ""; //이후 단어 초기화
					
				} else if(!crossWord[i][j].equals("#")) {
					word += crossWord[i][j]; //문자일 경우 단어 완성을 위해 연결한다.
				} else if(crossWord[i][j].equals("#") && word.length() == 1) { //단어의 최소 단위를 만족했을 경우
					word = ""; //이후 단어 초기화
					
				} 
			}
			if(word.length() > 1) {
				words.add(word);	
			}
		}
		
		Collections.sort(words);
		
		
		System.out.println(words.get(0));
		
		
		
	}

}