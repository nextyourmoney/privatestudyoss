package test;

public class Test implements AutoCloseable{

	@Override
	public void close() throws Exception{
		System.out.println("닫음");
	}
	
	public static void main(String[] args) {
		
		/*
		// (3월 23일) 객체 생성과 닫을 때의 일반적인 방법  #1
		Test test = null;
		try {
			test = new Test();
			//...... 콛드 작성
		} catch(Exception e) {
			
		} finally {
			try {
				test.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 */
		
	//(3월 23일) 자동으로 객체를 생성하고 close를 통해 작업하는 방식 #2 //반드시 AutoCloseable or closeable과 같은 것이 함께 구현되어 있어야 한다. 
	try(Test test = new Test()){
		//.... 코드 작성
	} catch(Exception e) {
		
	}
		
		
	}
}
