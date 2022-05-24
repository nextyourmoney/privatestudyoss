package Java.homeworkBook.ch07_Verify.abstractMovie;

public class MissionImpossible extends MovieInformation {
	public MissionImpossible(String genre, int time) {
		this.genre = genre;
		this.time = time;
	}

	@Override
	public void director() {
		// TODO Auto-generated method stub
		System.out.println("영화 감독: 브라이언 드 팔마.");
	}

	@Override
	public void actor() {
		// TODO Auto-generated method stub
		System.out.println("주연배우: 톰 크루즈.");
	}
	
	public void movieRank5() {
		System.out.println("인생작 5위");
	}

}
