package com.example.abbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.abbs.entity.Board;

@Mapper
public interface BoardDao {
	

	@Select("SELECT b.*, u.NAME FROM board b JOIN users u ON b.uid=u.uid"
			+ " WHERE b.bid = #{bid}")
	Board getBoard(int bid);
	
	@Select("Select count(bid) from board where isDeleted=0 and ${field} like #{query}") // MySQL만 가능
	int getBoardCount(String field, String query);

	@Select("SELECT b.*, u.NAME FROM board b JOIN users u ON b.uid=u.uid"
			+ " WHERE b.isDeleted=0 and ${field} like #{query}"
			+ " ORDER BY b.modTime DESC LIMIT ${count} OFFSET #{offset};")
	List<Board> getBoardList(String field, String query, int count, int offset);
	
	@Insert("insert into board valuse (default, #{title}, #{content}, #{uid}, "
			+ " default, default, default, default, default, #{files})")
	void insertBoard(Board board);
	
	@Update("update board set title=#{title}, content=#{content}, modTime=now(), files = #{files}"
			+" where bid = #{bid}")
	void updateBoard(Board board);
	
	@Delete("update board set isDeleted = 1 where bid = #{bid}")
	void deleteBoard(int bid);
	
	@update("update board set ${field}=${field}+1 where bid = #{bid}")
	void increaseCount(String field, int bid);
}
