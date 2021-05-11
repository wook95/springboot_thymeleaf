package com.iu.ss1.board.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class QnaController {

	
	@GetMapping("/qna/list")
	public String getQnaList()throws Exception{
		
		return "board/list";
	}
	
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	
}
