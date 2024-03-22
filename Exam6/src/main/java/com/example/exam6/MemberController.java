package com.example.exam6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService memberService;
	
	@GetMapping("/insert")
	public String insertform() {
		return "member/insert";
	}
	
	@PostMapping("/insert")
	public String insertProc(String name, int age, String country) {
		memberService.memberInsert(name, age, country);
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Member> memberList =  memberService.memberList();
		model.addAttribute("memberList", memberList);
		return "member/list";
	}
}
