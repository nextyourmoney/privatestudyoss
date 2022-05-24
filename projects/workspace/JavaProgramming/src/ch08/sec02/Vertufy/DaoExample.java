package ch08.sec02.Vertufy;

public class DaoExample {
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
	}
	
	public static void main(String[] args) {
		dbWork(new MySqlDao());
	}

}
