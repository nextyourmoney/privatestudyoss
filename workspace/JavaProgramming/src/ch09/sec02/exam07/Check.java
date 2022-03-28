package ch09.sec02.exam07;

public class Check {
	
	private String text;
	private CheckListener listener;
	
	public Check(String text) {
		this.text = text;
	}
	
	public void addCheckListener(CheckListener listener) {
		this.listener = listener;
	}
	
	public void check() {
		listener.oncheck();
	}
	
	
	
	static interface CheckListener{
		void oncheck();
	}
	
	
	
	

}
