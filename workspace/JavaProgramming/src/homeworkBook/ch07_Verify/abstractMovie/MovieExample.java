package Java.homeworkBook.ch07_Verify.abstractMovie;

public class MovieExample {
	public static void information(MovieInformation infor){
		infor.movieStart();
		infor.movieTimer();
		infor.director();
		infor.actor();
		infor.movieEnd();
		
		if(infor instanceof LifeIsBeautiful) {
			LifeIsBeautiful movie = (LifeIsBeautiful) infor;
			movie.movieRank3();
		} else if(infor instanceof LoadOfTheRings) {
			LoadOfTheRings movie = (LoadOfTheRings) infor;
			movie.movieRank1();
		} else if(infor instanceof MissionImpossible) {
			MissionImpossible movie = (MissionImpossible) infor;
			movie.movieRank5();
		} else {
			System.out.println("인생작은 아님");
		}
		
		System.out.println("--------------------------");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		information(new LifeIsBeautiful("Romance", 10)); //장르와 시간 정
		information(new LoadOfTheRings("Fantasy", 8));
		information(new MissionImpossible("Action", 3));
		information(new TheConjuring("Horror", 3));
	}

}
