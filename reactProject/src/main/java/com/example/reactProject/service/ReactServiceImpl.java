package com.example.reactProject.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reactProject.dao.ReactDao;
import com.example.reactProject.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 16~20 대체 1
public class ReactServiceImpl implements ReactService{
	
	private final ReactDao securityDao; // 16~20 대체 2
	
	
	@Override
	public User getUserByUid(String uid) {
		return new User();
//		return securityDao.getUserByUid(uid);
	}

	@Override
	public List<User> getSecurityUserList(int page) {
		int count = count_per_page;
		int offset = (page-1) * count_per_page;
		return securityDao.getSecurityUserList(offset);
	}

	@Override
	public int getSecurityUserCount() {
		return 0;
//		return securityDao.getSecurityUserCount();
	}

	@Override
	public void insertSecurityUser(User user) {
//		securityDao.insertSecurityUser(securityUser);
	}

	@Override
	public void updateSecurityUser(User user) {
//		securityDao.updateSecurityuser(securityUser);
	}

	@Override
	public void deleteSecurityUser(String uid) {
//		securityDao.deleteSecurityuser(uid);
	}
	
}
