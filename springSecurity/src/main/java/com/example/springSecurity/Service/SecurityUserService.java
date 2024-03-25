package com.example.springSecurity.Service;

import java.util.List;

import com.example.springSecurity.Entity.SecurityUser;


public interface SecurityUserService {
	public static final int count_per_page = 10;
	
	SecurityUser getUserByUid(String uid);
	
	List<SecurityUser> getSecurityUserList(int page);

	int getSecurityUserCount();
	
	void insertSecurityUser(SecurityUser securityUser); 

	void updateSecurityUser(SecurityUser securityUser);
	
	void deleteSecurityUser(String uid);
	

}
