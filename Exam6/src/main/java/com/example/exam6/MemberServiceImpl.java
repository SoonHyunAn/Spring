package com.example.exam6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberDao dao;
	
	@Override
	public void memberInsert(String name, int age, String country) {
		dao.memberInsert(name, age, country);
	}

	@Override
	public List<Member> memberList() {
		return dao.memberList();
	}
	
}
