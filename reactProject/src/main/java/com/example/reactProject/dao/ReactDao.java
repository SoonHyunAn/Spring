package com.example.reactProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.reactProject.entity.User;

@Mapper
public interface ReactDao {
	@Select("select * from users")
	List<User> getSecurityUserList(int offset);
}
