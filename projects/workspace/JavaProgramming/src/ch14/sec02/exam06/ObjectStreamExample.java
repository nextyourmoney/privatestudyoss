package ch14.sec02.exam06;

public class ObjectStreamExample {
	
	public static void main(String[] args) throws Exception{
		writeList();
		List<Board> list = readList();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(Board board: list) {
			System.out.print(false);
		}
	}

}
