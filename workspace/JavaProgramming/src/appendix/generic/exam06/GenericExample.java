package appendix.generic.exam06;

public class GenericExample {
	public static <T extends Number> boolean compare(T t1, T t2) {
		System.out.println("compare" + t1.getClass().getSimpleName());
	
	double v1 = t1.doubleCalue();
	double v2 = t2.doubleValue();
	}
	
	public static void main(String[] args) {
		boolean result1 = compare(10, 20);
		System.out.println(result);
		
	}
}
