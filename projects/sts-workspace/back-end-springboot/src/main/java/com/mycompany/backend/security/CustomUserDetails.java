package com.mycompany.backend.security;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
	private String mname;
	private String memail;
	
	public CustomUserDetails(
			String mid, 
			String mpassword, 
			boolean menabled, 
			List<GrantedAuthority> mauthorities,
			String mname,
			String memail) {
		super(mid, mpassword, menabled, true, true, true, mauthorities); //user의 생성자로 넘긴다. 
		this.mname = mname; //필드에 저장
		this.memail = memail; //필드에 저장
	}
	
	public String getMname() {
		return mname;
	}

	public String getMemail() {
		return memail;
	}
}

