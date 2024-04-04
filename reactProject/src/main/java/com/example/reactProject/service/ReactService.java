package com.example.reactProject.service;

import java.util.List;

import com.example.reactProject.entity.User;



public interface ReactService {
	public static final int count_per_page = 10;
	
	User getUserByUid(String uid);
	
	List<User> getSecurityUserList(int page);

	int getSecurityUserCount();
	
	void insertSecurityUser(User securityUser); 

	void updateSecurityUser(User securityUser);
	
	void deleteSecurityUser(String uid);

}
