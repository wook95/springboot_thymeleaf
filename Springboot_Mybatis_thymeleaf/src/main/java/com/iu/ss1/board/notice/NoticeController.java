package com.iu.ss1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.iu.ss1.board.BoardVO;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	
	
	@GetMapping("/notice/list")
	public String getNoticeList(Model model)throws Exception{
		
		List<BoardVO> ar = noticeService.getList();
		model.addAttribute("list",ar);
		
		return "board/list";
	}
	
	@GetMapping("/notice/select")
	public String getSelect(BoardVO boardVO,Model model)throws Exception{
		
		boardVO = noticeService.getSelect(boardVO);
		model.addAttribute("vo", boardVO);
		return "board/select";
	}
	
	@GetMapping("/notice/insert")
	public String setInsert(BoardVO boardVO,Model model)throws Exception{
		
		int result = noticeService.setInsert(boardVO);
		model.addAttribute("vo", boardVO);
		return "board/insert";
	}
	
	
	
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	
}
