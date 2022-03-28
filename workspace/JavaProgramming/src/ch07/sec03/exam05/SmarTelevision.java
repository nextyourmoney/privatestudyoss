package ch07.sec03.exam05;

import ch07.sec03.exam05.RemoteControl;

public class SmarTelevision implements RemoteControl, Searchable {

	private int volume;
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("tv시작");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("tv끝");
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
		
		System.out.println("tv볼륨을" + this.volume + "으로 설정");
	}

	@Override
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.println("회사 주소:" + url);
		
	}

}
