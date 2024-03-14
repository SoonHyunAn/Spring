package com.example.abbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.abbs.entity.Anniversary;

@Mapper
public interface AnniversaryDao {
	
	@Select("SELECT * FROM anniversary WHERE (uid=#{uid} or uid='admin') and "
			+ "adate BETWEEN #{startDay} AND #{endDay} order by adate")
	List<Anniversary> getAnnivList(String uid, String startDay, String endDay);
	
	@Insert("insert into anniversary values(defalut, #{uid}, #{aname}, #{adate}, #{isHoliday})")
	void insertAnniv(Anniversary anniv);
	
	
	
}
