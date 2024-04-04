package com.example.LoveBridge.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.abbs.util.AsideUtil;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/aside")
public class AsideController {
	@Autowired private AsideUtil asideUtil;

	@ResponseBody
	@GetMapping("/stateMsg")
	public String changeStateMsg(String stateMsg, HttpSession session) {
		session.setAttribute("stateMeg", stateMsg);
		return "return message"; // ResponseBody: 이번엔 데이터를 보내야 함.
	}

	@ResponseBody
	@GetMapping("/weather")
	public String weather(HttpSession session) throws Exception {
		String location = (String) session.getAttribute("location") + "청";
		String roadAddr = asideUtil.getRoadAddr(location);
		Map<String, String> map = asideUtil.getGeocode(roadAddr);
		String result = asideUtil.getWeather(map.get("lon"), map.get("lat"));
		return result;
//		return "lon= " + map.get("lon") + ", lat=" + map.get("lat"); // 좌표가 나오는 리턴값
//		return roadAddr; // 도로명 주소가 나오는 리턴값
	}
}
