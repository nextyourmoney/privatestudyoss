package appendix.generic.exam03;

public class GenericExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();
		
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();

	}

}
