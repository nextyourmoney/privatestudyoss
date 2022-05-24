package ch10.sec02.exam03;

public class CatchByException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println("aldkf");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매가값의 수가부족하다");
		} catch(NumberFormatException e) {
			System.out.print("숫자로 변환할 수 없습니다");
		} finally {
			System.out.print("다시 실행하세요");
		}
	}

}
