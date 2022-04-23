package com.mycompany.myapp.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.mybatis.Ch14memberDao;
import com.mycompany.myapp.controller.dto.Ch14Member;

@Service
public class Ch17UserDetailsService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(Ch17UserDetailsService.class);
	
	@Resource
	private Ch14memberDao memberDao;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Ch14Member member = memberDao.selectByMid(username); 
		if(member == null) {
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(member.getMrole()));
		
		Ch17UserDetails userDetails = new Ch17UserDetails(
				member.getMid(), 
				member.getMpassword(),
				member.isMenabled(),
				authorities,
			
				member.getMemail());
		
		return userDetails;
	}
}

