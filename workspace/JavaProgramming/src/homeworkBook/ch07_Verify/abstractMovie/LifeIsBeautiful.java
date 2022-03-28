package Java.homeworkBook.ch07_Verify.abstractMovie;

public class LifeIsBeautiful extends MovieInformation {

	public LifeIsBeautiful(String genre, int time) {
		this.genre = genre;
		this.time = time;
	}

	@Override
	public void director() {
		// TODO Auto-generated method stub
		System.out.println("영화 감독: 로베르토 베니니.");
		
	}

	@Override
	public void actor() {
		// TODO Auto-generated method stub
		System.out.println("주연배우: 로베르토 베니니.");
	}
	
	public void movieRank3() {
		System.out.println("인생작 3위");
	}
	
	
}
