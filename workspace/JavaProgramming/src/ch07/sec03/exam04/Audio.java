package ch07.sec03.exam04;

public class Audio implements RemoteControl {
	private int volume;

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("audio시작");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("audio끝");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if(volume > RemoteControl.MAX_VOLUME) { //인터페이스 값 바로 연결
			volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		
		System.out.println("audio볼륨을" + this.volume + "으로 설정");
	}

}
