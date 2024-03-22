package com.example.exam6;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	@GetMapping("/member")
	public String member(Model model) {
		List<Member> memberList = new ArrayList<>();
		
		memberList.add(new Member(1, "제임스", 23, "미국"));
		memberList.add(new Member(2, "사라", 18, "영국"));
		memberList.add(new Member(3, "한나", 15, "캐나다"));
		memberList.add(new Member(4, "철수", 30, "한국"));
		memberList.add(new Member(5, "영희", 27, "한국"));
		
		model.addAttribute("memberList", memberList);
		
		return "exam/memberList";
	}
}
