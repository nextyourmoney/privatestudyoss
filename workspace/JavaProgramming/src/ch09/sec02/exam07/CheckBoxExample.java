package ch09.sec02.exam07;

import java.awt.*;

public class CheckBoxExample {
	public static void main(String[] args) {
		

		
		Check dbSex = new Check("남자");
		dbSex.addCheckListener(new SexListener());
		dbSex.check(); //남자를 체크했다.
		
		Check dbpublic = new Check("비공");
		dbSex.addcheckListener(new PublicListener)); //비공개를 체크했습니다.
		dbSex.check();
}
