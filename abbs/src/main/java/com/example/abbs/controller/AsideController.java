package com.example.abbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.abbs.util.AsideUtil;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/aside")
@PropertySource("classpath:/static/data/myKeys.properties")
public class AsideController {
	@Autowired private AsideUtil asideUtil;
	
	
	@GetMapping("/stateMsg")
	@ResponseBody
	public String changeStateMsg(String stateMsg, HttpSession session) {
		session.setAttribute("stateMeg", stateMsg);
		return "return message"; // ResponseBody: 이번엔 데이터를 보내야 함.
	}
	
	@ResponseBody
	@GetMapping("/weather")
	public String weather(HttpSession session) {
		String location = (String) session.getAttribute("location")+"청";
		String roadAddr;
		try {
			roadAddr = asideUtil.getRoadAddr(location);
			return roadAddr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
