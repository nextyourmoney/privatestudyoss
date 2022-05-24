package homeworkAlgorithm.feb16we;

import java.util.Scanner;

public class final2 { //1 2 3 4
	static String[] deleteNSort(int idx, String word, String[] remember) {//삭제 + 정렬 메소드
		String[] tempArray = new String[remember.length];
		
		for(int j=0; j<idx; j++) {//위치 바꾸기
			tempArray[j] = remember[j];//동일한(삭제할)단어 전까지 복사.
		}
		
		for(int k=idx+1; k<remember.length; k++) {//동일한(삭제할)단어 뒷부분 복사.
			tempArray[k-1] = remember[k];
		}
		
		tempArray[tempArray.length-1] = word;//맨 마지막에 단어 추가
		
		return tempArray;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input1 = sc.nextLine();
		String input2 = sc.nextLine();
		
		String[] array1 = input1.split(" ");
		int capacity = Integer.parseInt(array1[0]); //암기 가능한 단어 수
		String[] words = input2.split(" ");
		String[] remember = new String[capacity];
		
		int totalLength = 0; //단어 총 길이
		double avgLength = 0; //단어들 평균 길이
		int time = 0; //걸린 시간
		
		for(int i=0; i<words.length; i++) {//시간 추가하기.
			for(int r=0; r<remember.length; r++) {//이미 외운 단어인지 점검.
				if(words[i].equals(remember[r])) {//words가 remember배열에 있는지 점검.			
					remember = deleteNSort(r, words[i], remember);
					time += 1; //1초 걸림.
					break;			
				} else {//안 외운 단어의 경우.
					if(remember[remember.length-1] == null) {//외울자리 있는지 점검.
						//자리 있으면 바로 추가.
						for(int l=0; l<remember.length; l++) {
							if(remember[l] == null) {
								remember[l] = words[i];
								break;
							}
						}
						time += 3; //3초 걸림.
						break;
					} else {//자리 없으면 삭제하고 추가.
						//이때,단어평균길이 점검해서 삭제할 원소 정하기.
						for(String r2 : remember) {//remember배열 단어의 전체길이.
							if(r2 != null) {
								totalLength += r2.length();				
							}
						}
						avgLength = (double)totalLength / remember.length;//remember배열 단어의 평균길이.
						for(int r3=0; r3<remember.length; r3++) {//앞에서부터 차례대로 평균길이 미만인 단어의 위치 찾기.
							if(remember[r3]!=null && remember[r3].length() > avgLength) {//평균길이보다 큰 단어는 삭제하지 않음.
								continue;
							} else {//=<평균길이 이면 삭제.
								remember = deleteNSort(r3, words[i], remember);
								break;//평균길이 미만인 단어는 1개만 찾으면 됨.
							}
						}
						time += 3; //3초 걸림.
						break;
					}
				}
			}		
		}
		System.out.println("걸린 시간을 초 단위로 출력");
		System.out.println(time);
	}
}