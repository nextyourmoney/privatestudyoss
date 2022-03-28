package ch07.sec01.exam01;

public class DmbCellPhone extends CellPhone {
	
	int channel;
	
	DmbCellPhone(String model, String color, int channel){
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	//메소드
	void turnOnDmb() {
		System.out.println("채널 수" + channel);
		
	}
	
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("변경 할 채널" + channel);
		
	}
	
	void turnOffDmb() {
		System.out.println("stop dmb");
	}
	

}
