package com.example.exam6;

import java.util.List;

public interface MemberService {
	
	void memberInsert(String name, int age, String country);
	
	List<Member> memberList();
}
