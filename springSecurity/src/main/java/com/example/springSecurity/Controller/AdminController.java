package com.example.springSecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@ResponseBody
	@GetMapping("/show")
	public String show() {
		return "<h1>/admin/show</h1>";
	}
	
}
