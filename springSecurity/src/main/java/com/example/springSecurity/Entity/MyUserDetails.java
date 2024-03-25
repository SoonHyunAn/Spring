package com.example.springSecurity.Entity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;

// Spring Security 가 login post 요청을 낚아채서 login을 진행하는 코드
// Local Login - User Details 구현
// Social Login - OAuth2User 구현
@RequiredArgsConstructor
public class MyUserDetails implements UserDetails {

	private final SecurityUser securityUser;
	// 사용자의 권한을 return - 관리자/사용자 구분
	// GrantedAuthority 를 상속받은 누구나 ? 자리에 올 수 있다
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return securityUser.getRole();
			}
		});
		return collect;
	}

	@Override
	public String getPassword() {
		return securityUser.getPwd();
	}

	@Override
	public String getUsername() {
		return securityUser.getUid();
	}

	@Override
	public boolean isAccountNonExpired() { // 유효계정인가? 
		if (securityUser.getIsDeleted()==0)
			return true;
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
