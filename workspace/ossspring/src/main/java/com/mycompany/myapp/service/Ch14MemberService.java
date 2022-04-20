package com.mycompany.myapp.service;

import javax.annotation.Resource;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.controller.dto.Ch14Member;
import com.mycompany.myapp.dao.mybatis.Ch14memberDao;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Ch14MemberService {
	public enum JoinResult{
		SUCCESS, FAIL, DUPLICARTED
	}
	
	public enum LoginResult{
		SUCCESS, FAIL, FAIL_MPASSWORD, FAIL_MID
	}
	
	@Resource
	private Ch14memberDao memberDao;
	
	public JoinResult join(Ch14Member member) {
		Ch14Member dbMember = memberDao.selectByMid(member.getMid());
		if(dbMember == null) {
			PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			member.setMpassword(passwordEncoder.encode(member.getMpassword()));
			int result = memberDao.insert(member);
			return JoinResult.SUCCESS;
			
		} else {
			
			return JoinResult.DUPLICARTED;
		} 
		
	}
	
	public LoginResult login(Ch14Member member) {
		Ch14Member dbMember = memberDao.selectByMid(member.getMid());
		if(dbMember == null) {
			return LoginResult.FAIL_MPASSWORD;
		} else {
			PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			if(passwordEncoder.matches(member.getMpassword(), dbMember.getMpassword())) {
				return LoginResult.SUCCESS;
			} else {
				return LoginResult.FAIL_MPASSWORD;
			}
		}
	}
	
}
