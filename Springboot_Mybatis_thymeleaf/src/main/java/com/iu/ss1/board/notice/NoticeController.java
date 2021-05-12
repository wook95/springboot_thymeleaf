package com.iu.ss1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.iu.ss1.board.BoardVO;
import com.iu.ss1.util.Pager;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	
	
	@GetMapping("/notice/list")
	public String getNoticeList(Model model,Pager pager)throws Exception{
		
		List<BoardVO> ar = noticeService.getList(pager);
		model.addAttribute("list",ar);
		model.addAttribute("pager",pager);
		
		return "board/list";
	}
	
	@GetMapping("/notice/select")
	public String getSelect(BoardVO boardVO,Model model)throws Exception{
		
		boardVO = noticeService.getSelect(boardVO);
		model.addAttribute("vo", boardVO);
		return "board/select";
	}
	
	@GetMapping("/notice/insert")
	public String setInsert()throws Exception{
		return "board/insert";
	}
	
	@PostMapping("/notice/insert")
	public String setInsert(BoardVO boardVO)throws Exception{
		int result = noticeService.setInsert(boardVO);
		return "redirect:./list";
	}
	
	
	
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	
}
