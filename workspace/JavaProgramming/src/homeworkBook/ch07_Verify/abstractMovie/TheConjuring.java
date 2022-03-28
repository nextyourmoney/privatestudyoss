package Java.homeworkBook.ch07_Verify.abstractMovie;

public class TheConjuring extends MovieInformation{
	

	public TheConjuring(String genre, int time) {
		this.genre = genre;
		this.time = time;
	}

	@Override
	public void director() {
		// TODO Auto-generated method stub
		System.out.println("영화 감독: 제임스 완.");
		
	}

	@Override
	public void actor() {
		// TODO Auto-generated method stub
		System.out.println("주연배우: 패트릭 윌슨.");
	}
	

}
