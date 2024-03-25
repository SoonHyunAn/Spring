package com.example.springSecurity.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springSecurity.Entity.MyUserDetails;
import com.example.springSecurity.Entity.SecurityUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyUserDetailService implements UserDetailsService{
	private final SecurityUserService securityService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUser securityUser = securityService.getUserByUid(username);
		if (securityUser != null) {
			log.info("로그인 완료: " + securityUser.getUid());
			return new MyUserDetails(securityUser);
		}
		return null;
	}

}
