package ch11.sec01.exam05;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private int hitcount; 
	
	//기본 생성자
	
	//모든 필드의 값을 외부에서 받아서 초기화하는 생성자
	
	//Getter, Setter
	
	//hashCode 재정의 //필드의 모든 해쉬 코드가 같은 때만 출력 되도록
	
	//equals 재정의 //필드의 모든 값들이 일치 할 때 출력 되도록
	
	//toString 재정의
}
