package com.example.abbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list() {
		return "index";
	}
	
}
