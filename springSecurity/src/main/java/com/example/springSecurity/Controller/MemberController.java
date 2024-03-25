package com.example.springSecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springSecurity.Entity.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 기존 Logger, LoggerFactory 대체
@Controller
@RequestMapping("/member")

public class MemberController {
	
	
	@ResponseBody // 그냥 화면에 보여주기 위함, 웹 미구현
	@GetMapping("/detail/{mid}")
	public String detail(@PathVariable int mid) {
		Member member = new Member(); 
		log.info("detail");
		return "";
	}
	
	@ResponseBody
	@GetMapping("/insert")
	public String insert() {
		Member m1 = new Member();
		m1.setName("James");
		m1.setEmail("james@naver.com");
		log.info(m1.toString());
		// Builder pattern - 생성자로 두개만 포함한 꼴이 존재하지 않더라도 만들 수 있음
		// 또한, 같은 타입의 변수들을 이용해 생성자를 생성하면 중복이 불가능 했지만
		// builder를 사용하면 변수의 이름을 사용해 만들 수 있기 때문에 유용하다.
		Member m2 = Member.builder()
						  .name("maria")
						  .email("maria@gmail.com")
						  .build();
		log.info(m2.toString());
		return m1.toString() + "<br>" + m2.toString();
	}
	
	@ResponseBody
	@GetMapping("/update")
	public String update() {
		Member member = Member.builder()
							  .mid(1).name("brian").email("brian@daum.net").build();
		log.info(member.toString());
		return member.toString();
	}
	
}
