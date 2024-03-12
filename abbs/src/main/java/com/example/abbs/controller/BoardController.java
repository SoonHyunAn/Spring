package com.example.abbs.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.abbs.entity.Board;
import com.example.abbs.service.BoardService;
import com.example.abbs.util.JsonUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired private BoardService boardService;
	@Autowired private JsonUtil jsonUtil;
	@Value("${spring.servlet.multipart.location}") private String uploadDir;

	@GetMapping("/list")
	public String list(@RequestParam(name="p", defaultValue="1") int page,
				@RequestParam(name="f", defaultValue="title") String field,
				@RequestParam(name="q", defaultValue="") String query,
				HttpSession session, Model model) {
		List<Board> boardList = boardService.getBoardList(page, field, query);
		
		int totalBoardCount = boardService.getBoardCount(field, query);
		int totalPages = (int) Math.ceil(totalBoardCount / (double)BoardService.COUNT_PER_PAGE);
		int startPage = (int) Math.ceil((page-0.5)/BoardService.PAGE_PER_SCREEN - 1) * BoardService.PAGE_PER_SCREEN + 1;
		int endPage = Math.min(totalPages, startPage + BoardService.PAGE_PER_SCREEN - 1);
		List<String> pageList = new ArrayList<>();
		for (int i = startPage; i <= endPage; i++)
			pageList.add(String.valueOf(i));
		session.setAttribute("currentBoardPage", page);
		model.addAttribute("boardList", boardList);
		model.addAttribute("field", field);
		model.addAttribute("query", query);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageList", pageList);
		
		return "board/list";
	}
	
	@GetMapping("/insert")
	public String insertForm(String uid, HttpSession session, HttpServletRequest request) {
		session = request.getSession();
		String sessUid = (String) session.getAttribute("sessUid");
		session.setAttribute("sessUid", sessUid);
		
		if (sessUid==null||sessUid.equals(""))
			return "redirect:/user/login";
			
		return "board/insert";
	}
	
	@PostMapping("/insert")
	public String insertProc(String title, String content, HttpSession session, MultipartHttpServletRequest req) {
		String sessUid = (String) session.getAttribute("sessUid");
		List<MultipartFile> uploadFileList = req.getFiles("files");
		
		List<String> fileList = new ArrayList<>();
		for (MultipartFile part: uploadFileList) {
			// 첨부 파일이 없는 경우 - application/octet-stream
			if (part.getContentType().contains("octet-stream"))
				continue;
			
			String filename = part.getOriginalFilename();
			String uploadPath = uploadDir + "upload/" + filename;
			try {
				part.transferTo(new File(uploadPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
			fileList.add(filename);
		}
		String files = jsonUtil.list2Json(fileList);
		Board board = new Board(title, content, sessUid, files);
		boardService.insertBoard(board);
		return "redirect:/board/list";
	}
	
}



// 혼자 짜본 코드 - 파일 미구현
//@GetMapping("/insert")
//public String insertForm(String uid, HttpSession session, HttpServletRequest request) {
//	session = request.getSession();
//	String sessUid = (String) session.getAttribute("sessUid");
//	session.setAttribute("sessUid", sessUid);
//	
//	if (sessUid==null||sessUid.equals(""))
//		return "redirect:/user/login";
//		
//	return "board/insert";
//}
//
//@PostMapping("/insert")
//public String insertProc(String title, String content, HttpSession session, MultipartHttpServletRequest req) {
//	String uid = (String) session.getAttribute("sessUid");
//	Board board = new Board(title, content, uid);
//	boardService.insertBoard(board);
//	return "redirect:/board/list";
//}

