package com.iu.ss1.board.notice;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class NoticeController {

	
	@GetMapping("/notice/list")
	public String getNoticeList()throws Exception{
		
		return "board/list";
	}
	
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	
}
