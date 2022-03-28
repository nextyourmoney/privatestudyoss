package appendix.generic.exam03;

public class HomeAgency implements Rentable<Home>{
	@Override
	public Home rent() {
		return new Home();
	}
	

}
