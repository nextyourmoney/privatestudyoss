package ch07.sec02.exam03;

public class kumhoTire extends Tire {
	
	public kumhoTire (String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "Tire 수명:" + (maxRotation-accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println(location);
			return false;
		}
	}

}
