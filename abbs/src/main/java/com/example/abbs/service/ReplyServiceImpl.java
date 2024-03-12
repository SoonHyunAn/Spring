package com.example.abbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.abbs.entity.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Override
	public List<Reply> getReplyList(int bid) {
		return null;
	}

	@Override
	public void insertReply(Reply reply) {
	}

}
