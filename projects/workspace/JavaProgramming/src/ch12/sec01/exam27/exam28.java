package ch12.sec01.exam27;

import java.text.*;
import java.util.*;

public class exam28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM월 dd일 hh시 mm분 ss");
		String strNow = sdf.format(now);
		System.out.println(strNow);

	}

}
