package ch12.sec02.exam02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CalendarExample {
	
	public static void main(String[] args) {
	LocalDateTime now = LocalDateTime.now();
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	System.out.println(now.format(dtf));
	
	LocalDateTime result = now.plusDays(30);
	System.out.println(result.format(dtf));
	
	LocalDateTime chrimas = LocalDateTime.of(now.getYear(),  12, 25, 0, 0); //지정 일자까지 남은 시간
	long remainDays = now.until(chrimas,ChronoUnit.DAYS); ///기간 일까지 정해진  //chronounit은  기준이라고 할 수 있다.
	System.out.println("d-day" + remainDays);
	
	
	}
	
	
	

}
