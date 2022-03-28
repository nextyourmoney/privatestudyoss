package ch09.sec02.exam06;

public class ButtonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button btnCall = new Button();
		btnCall.setOnClickListener(new CallListenner());
		btnCall.touch();
		
		Button btnMessage = new Button(new MessageListener);
		btnMessage.touch();
		btnMessage.touch();

	}
	
	
}
