package com.mycompany.backend.security;

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

import com.mycompany.backend.dao.MemberDao;
import com.mycompany.backend.dto.Member;


@Service
public class CustomUserDetailService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);
	
	@Resource
	private MemberDao memberDao;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = memberDao.selectByMid(username); 
		if(member == null) {
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(member.getMrole()));
		
		CustomUserDetails userDetails = new CustomUserDetails(
				member.getMid(), 
				member.getMpassword(),
				member.isMenabled(),
				authorities,
				//위의 4가지는 필수적으로 들어가야 한다. //spring security의 데이터 베이스는 enabled와 ROLE가 반드시 정의되어야 한다. 
				member.getMname(),
				member.getMemail());
		
		return userDetails;
	}
}

