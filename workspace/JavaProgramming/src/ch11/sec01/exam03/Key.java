package ch11.sec01.exam03;

import ch11.sec01.exam02.*;

public class Key {
	private int number;
	private String name;
	
	public Key(int i, String string) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.name = name;
	}

	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key k = (Key) obj;
			if(name == k.name && name.equals(k.name)) {
				return true;
			} else {
				return false;
			} 
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return number + name.hashCode();
	}
	

}
