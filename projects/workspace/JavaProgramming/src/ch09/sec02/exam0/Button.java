package ch09.sec02.exam06;

public class Button {
	
	private OnClickListener listenner;
	
	void touch() {
		System.out.println("윈도우를 닫습니다");
	}
	
	public void setOncClickListener(OnClickListener listener) {
		this.listner = listener;
	}
	//중첩 인터페이스
	static interface OnClickListener{
		void onClick();
	}
	
	


}
