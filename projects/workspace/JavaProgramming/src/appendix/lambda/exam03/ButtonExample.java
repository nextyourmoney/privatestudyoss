package appendix.lambda.exam03;

public class ButtonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button btnCall = new Button();
		btnCall.setOncClickListener(() -> System.out.println("전화를 겁니다"));
		btnCall.touch();
		
		Button btnMessage = new Button();
		//btnMessage.setOncClickListener(new MessageListener());
		btnMessage.setOncClickListener(() -> System.out.println("전화를 겁니다"));
		btnMessage.touch();

		Button btnClose = new Button();
		//btnClose.setOnClickListener = new Button(new CloseListener);
		btnMessage.setOncClickListener(() -> System.out.println("전화를 겁니다"));
		btnClose.touch();
		
	}
	
	
}
