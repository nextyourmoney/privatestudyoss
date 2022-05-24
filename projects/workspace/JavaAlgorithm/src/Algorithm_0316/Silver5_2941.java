package Algorithm_0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2941
public class Silver5_2941 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		
		try {
			String alphabet = bf.readLine();
			
			int count = 0;
			
			//String alphabet = scanner.nextLine();
			for(int i = 0; i < alphabet.length(); i++) {
				char alphabetWord = alphabet.charAt(i);
				
				if(alphabetWord == 'c') {
					if(alphabet.charAt(i + 1) == '=') { //c=
						i++;
						
					} else if(alphabet.charAt(i + 1) == '-') { //c-
						i++;
					}
				} 
				
				else if(alphabetWord == 'd') {
					if(alphabet.charAt(i + 1) == 'z') {
						if(alphabet.charAt(i + 2) == '=') {	//dz= 
							i += 2;
						}
					} else if(alphabet.charAt(i + 1) == '-') {//d-
						i++;
					}
				}
				
				else if(alphabetWord == 'l') {
					if(alphabet.charAt(i + 1) == 'j') {//lj
						i++;
					}
				} 
				
				else if(alphabetWord == 'n') {
					if(alphabet.charAt(i + 1) == 'j') {//nj
						i++;
					}
				} 
				
				else if(alphabetWord == 's') {
					if(alphabet.charAt(i + 1) == '=') {//s= 
						i++;
					}
			    } 
				
				else if(alphabetWord == 'z') {
					if(alphabet.charAt(i + 1) == '=') {//z=
						i++;
					}
				}
			    
				count++;
			 
			}
			 
			System.out.println(count);
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
}
