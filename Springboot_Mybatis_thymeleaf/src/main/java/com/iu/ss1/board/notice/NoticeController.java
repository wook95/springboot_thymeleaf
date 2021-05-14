package com.iu.ss1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.ss1.board.BoardVO;
import com.iu.ss1.util.Pager;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/notice/fileDown")
	public ModelAndView fileDown(String fileName,String ogName)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("fileName", fileName);
		mv.addObject("ogName",ogName); // 파라미터로 받거나, db에서 조회해도 된다
		mv.addObject("filePath", "/upload/notice/");
		
		
		mv.setViewName("fileDown");
		
		// fileDown이라는 bean먼저 찾고 없을시
		// /fileDown.html 찾으러 간다.
		// 지금은 @component로 Filedown이 빈 filedown이 되서 파일 다운 가능!
		
		
		
		return mv;
	
	}
	
	
	
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
	public String setInsert(Model model)throws Exception{
		model.addAttribute("vo", new BoardVO());
		model.addAttribute("action","insert");
		return "board/form";
	}
	
	@PostMapping("/notice/insert")
	public String setInsert(BoardVO boardVO, MultipartFile[] files)throws Exception{
		int result = noticeService.setInsert(boardVO,files);
		
//		System.out.println(files.length);
//		for(MultipartFile f : files) {
//			System.out.println(f.getOriginalFilename());
//		}
		
		return "redirect:./list";
	}
	
	
	@GetMapping("/notice/update")
	public String setUpdate(BoardVO boardVO,Model model)throws Exception{
		
		//번호만 넘어오면(boardVO) 수정한 내용이 뭔지 모른다 ,,,,, 그래서!
		//select를 해줘야 하는것! ! !
		boardVO = noticeService.getSelect(boardVO);
		model.addAttribute("vo", boardVO);
		model.addAttribute("action","update");
		return "board/form";
	}
	
	@PostMapping("/notice/update")
	public String setUpdate(BoardVO boardVO)throws Exception{
		int result=noticeService.setUpdate(boardVO);
		return "redirect:./list";
	}
	
	@GetMapping("notice/delete")
	public String setDelete(BoardVO boardVO)throws Exception{
		
		int result = noticeService.setDelete(boardVO);
		return "redirect:./list";
		
	}
	
	
	
	
	
	
	
	
	
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	
	
}
