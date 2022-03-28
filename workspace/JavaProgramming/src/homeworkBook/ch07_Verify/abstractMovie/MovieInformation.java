package Java.homeworkBook.ch07_Verify.abstractMovie;

public abstract class MovieInformation {
	
	//필드
	public String genre; //영화 장르
	public String countrOfOrigin = "USA"; //영화 제작사 소속 국가
	int time;
	 
	//메소드
	public void movieStart() {
		System.out.println("영화를 시작합니다.");
	}
	
	public void movieEnd() {
		System.out.println("영화를 끝냅니다.");
	}
	
	public void endingCredit() {
		System.out.println("엔딩 크래딧 시작합니다.");
	}
	
	
	public void movieTimer() {
		while(time > 0) {
			System.out.println("영화 상영시간이 " + time + "분 남았습니다.");
			time -= 1;
		}
		endingCredit();
	}
	
	public abstract void director(); //엔딩크레딧에 감독
	public abstract void actor(); //엔딩크레딧에 배우


}
