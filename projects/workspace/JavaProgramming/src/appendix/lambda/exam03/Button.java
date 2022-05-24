package appendix.lambda.exam03;

public class Button {
	
	private OnClickListener listenner;
	
	void touch() {
		System.out.println("윈도우를 닫습니다");
	}
	
	
	//중첩 인터페이스
	static interface OnClickListener{
		void onClick();
	}


	public void setOncClickListener(Object object) {
		// TODO Auto-generated method stub
		
	}


	
	


}
