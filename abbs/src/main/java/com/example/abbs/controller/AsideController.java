package com.example.abbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/aside")
public class AsideController {
	
	
	@GetMapping("/stateMsg")
	@ResponseBody
	public String changeStateMsg(String stateMsg, HttpSession session) {
		session.setAttribute("stateMeg", stateMsg);
		return "return message"; // ResponseBody: 이번엔 데이터를 보내야 함.
	}
	
}
