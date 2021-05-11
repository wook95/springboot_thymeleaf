package com.iu.ss1.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iu.ss1.board.BoardVO;




//thyme leag

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		//model.addAttribute("message","Thymeleaf Project");
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(1L);
		boardVO.setTitle("tt1");
		boardVO.setWriter("ww");
		System.out.println(boardVO.toString());
		return "index";
	}
	
}
