package com.example.exam6;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberDao {

	@Insert("insert into member values (default, #{name}, #{age}, #{country})")
	void memberInsert(String name, int age, String country);
	
	@Select("select * from member")
	List<Member> memberList();
}
