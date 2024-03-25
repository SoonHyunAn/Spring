package com.example.springSecurity.Service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springSecurity.Dao.SecurityUserDao;
import com.example.springSecurity.Entity.SecurityUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 16~20 대체 1
public class SecurityUserServiceImpl implements SecurityUserService{
//	private SecurityUserDao securityDao;
//	@Autowired 
//	public SecurityUserServiceImpl (SecurityUserDao securityDao) {
//		this.securityDao = securityDao;
//	}
	
	private final SecurityUserDao securityDao; // 16~20 대체 2
	
	
	@Override
	public SecurityUser getUserByUid(String uid) {
		return securityDao.getUserByUid(uid);
	}

	@Override
	public List<SecurityUser> getSecurityUserList(int page) {
		int count = count_per_page;
		int offset = (page-1) * count_per_page;
		return securityDao.getSecurityUserList(count, offset);
	}

	@Override
	public int getSecurityUserCount() {
		return securityDao.getSecurityUserCount();
	}

	@Override
	public void insertSecurityUser(SecurityUser securityUser) {
		securityDao.insertSecurityuser(securityUser);
	}

	@Override
	public void updateSecurityUser(SecurityUser securityUser) {
		securityDao.updateSecurityuser(securityUser);
	}

	@Override
	public void deleteSecurityUser(String uid) {
		securityDao.deleteSecurityuser(uid);
	}
	
}
