package ch09.sec02.exam0;

public class ButtonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button btnCall = new Button();
		btnCall.setOnClickListener(new CallListenner());
		btnCall.touch();
		
		Button btnMessage = new Button();
		//btnMessage.setOncClickListener(new MessageListener());
		btnMessage.setOnclickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("메세지 보낸다.");
			}
		});
		btnMessage.touch();

		Button btnClose = new Button();
		//btnClose.setOnClickListener = new Button(new CloseListener);
		btnClose.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("종료한 보낸다.");
			}
		});
		btnClose.touch();
		
	}
	
	
}
