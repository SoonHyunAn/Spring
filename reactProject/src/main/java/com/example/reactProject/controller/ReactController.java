package com.example.reactProject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.reactProject.entity.User;
import com.example.reactProject.service.ReactService;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController // 화면 렌더링 없이 데이터 전송 가능한 컨트롤러 (ResponseBody 와 유사)
@RequestMapping("/react")
public class ReactController {
	@Autowired
	private ReactService rSuc;

	@GetMapping("/data")
	public String data() {
		return "스프링 부트에서 보낸 데이터";
	}

	@GetMapping("/json")
	public String json() {
		JSONObject jObj = new JSONObject();
		jObj.put("uid", "james");
		jObj.put("uname", "제스");

		return jObj.toString();
	}

	@PostMapping("/form")
	public String form(String uid, String uname) {
		return "uid=" + uid + ", uname=" + uname;
	}

	@PostMapping("/multi")
	public String multi(String uid, String uname, MultipartFile file) {
		return "uid=" + uid + ", uname=" + uname + ", file =" + file.getOriginalFilename();
	}

	@GetMapping("/useDB")
	public String useDB(String uid, String uname, String email) {
		List<User> userList = rSuc.getSecurityUserList(1);
		System.out.println(userList);
		JSONObject jObj = new JSONObject();
		JSONArray jArr = new JSONArray();
		
		for (int i = 0; i < userList.size(); i++) {
			JSONObject jObject = new JSONObject();//배열 내에 들어갈 json
			User user = userList.get(i);
			
			jObject.put("uid", user.getUid());   
			jObject.put("uname", user.getUname()); 
			jObject.put("email", user.getEmail());                    
			jArr.add(jObject);
		} 
		jObj.put("item", jArr);//배열을 넣음
		
		System.out.println(jArr.toString());
		return jArr.toString();
	}

}
