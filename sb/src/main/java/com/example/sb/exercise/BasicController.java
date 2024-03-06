package com.example.sb.exercise;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ex")

public class BasicController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/hello") // localhost:8090/sb/ex/hello
	public String hello() {
		return "exercise/hello"; // hello.html
	}

	@GetMapping("/noHtml") // html 파일을 찾지 말고, 직접 데이터를 전송
	@ResponseBody
// Whitelabel Error Page
//	This application has no explicit mapping for /error, so you are seeing this as a fallback.
//
//	Wed Mar 06 09:26:13 KST 2024
//	There was an unexpected error (type=Internal Server Error, status=500).
// 이 오류 해결을 위해 ResponseBody 추가
	public String noHtml() {
		return "<h1>Hello Spring Boot!!!</h1>";
	}

	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/ex/hello"; // redirect
	}

	@GetMapping("/params")
	public String params(Model model) {
		model.addAttribute("name", "제임스");
		return "exercise/params";
	}

	@GetMapping("/params2") // http://localhost:8090/sb/ex/params2?name=브라이언
	public String params(Model model, HttpServletRequest req) {
		String name = req.getParameter("name");
		model.addAttribute("name", name);
		return "exercise/params";
	}

	@GetMapping("/params3")
	public String params(Model model, String name, int count) {
		model.addAttribute("name", name + count);
		return "exercise/params";
	}

	@GetMapping("/memberForm")
	public String memberForm() {
		return "exercise/memberForm";
	}

	@PostMapping("/memberProc")
	public String memberProc(Member member, Model model) {
		log.info(member.toString());
		// c.example.sb.exercise.BasicController Member [mid=1, name=2, age=3]
		model.addAttribute("name", member.getName());
		return "exercise/params";
	}

	@GetMapping("/login")
	public String login() {
		return "exercise/login";
	}

	@PostMapping("/loginProc")
	public String loginProc(String uid, String pwd, HttpSession session, Model model) {
		String hashedPwd = "$2a$10$2WG5Jvrq0NwWLRwvMs9UVevasL6zumzDnjCefALE4PqTg4HaPEM4K";
		if (uid.equals("sarah") && BCrypt.checkpw(pwd, hashedPwd)) {
			model.addAttribute("msg", uid + "님이 로그인 했습니다.");
			session.setAttribute("sessUid", uid);
			session.setAttribute("sessUname", "사라");
			return "exercise/loginResult";
		} else {
			model.addAttribute("msg", "등록된 정보가 없습니다.");
			return "exercise/loginResult";
		}

	}

	@GetMapping("/path/{uid}/{bid}")
	@ResponseBody
	public String path(@PathVariable String uid, @PathVariable int bid) {
		return "<h1>uid= " + uid + ", bid= " + bid + "</h1>";

	}
}
