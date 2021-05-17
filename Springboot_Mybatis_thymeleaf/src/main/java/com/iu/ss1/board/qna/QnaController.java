package com.iu.ss1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.iu.ss1.board.BoardVO;
import com.iu.ss1.util.Pager;

@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("/qna/list")
	public String getQnaList(Pager pager, Model model)throws Exception{
		List<BoardVO> ar = qnaService.getList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	
	@GetMapping("/qna/insert")
	public String setInsert(Model model)throws Exception{
		model.addAttribute("vo", new BoardVO());
		model.addAttribute("action","insert");
		return "board/form";
	}
	
	@PostMapping("/qna/insert")
	public String setInsert(BoardVO boardVO, MultipartFile[] files)throws Exception{
		int result = qnaService.setInsert(boardVO,files);
		
//		System.out.println(files.length);
//		for(MultipartFile f : files) {
//			System.out.println(f.getOriginalFilename());
//		}
		
		return "redirect:./list";
	}
	
	
	@GetMapping("/qna/select")
	public String getSelect(BoardVO boardVO,Model model)throws Exception{
		
		boardVO = qnaService.getSelect(boardVO);
		model.addAttribute("vo", boardVO);
		return "board/select";
	}
	
	
	
	@GetMapping("/qna/update")
	public String setUpdate(BoardVO boardVO,Model model)throws Exception{
		
		//번호만 넘어오면(boardVO) 수정한 내용이 뭔지 모른다 ,,,,, 그래서!
		//select를 해줘야 하는것! ! !
		boardVO = qnaService.getSelect(boardVO);
		model.addAttribute("vo", boardVO);
		model.addAttribute("action","update");
		return "board/form";
	}
	
	@PostMapping("/qna/update")
	public String setUpdate(BoardVO boardVO)throws Exception{
		int result=qnaService.setUpdate(boardVO);
		return "redirect:./list";
	}
	
	
	
	@GetMapping("qna/delete")
	public String setDelete(BoardVO boardVO)throws Exception{
		
		//file name 조회,  ,qnatable 글 삭제, hdd에서 파일 삭
		
		
		int result = qnaService.setDelete(boardVO);
		return "redirect:./list";
		
	}
	
	@GetMapping("qna/reply")
	public String setReplyInsert(BoardVO boardVO,Model model)throws Exception{
		
		model.addAttribute("vo", boardVO);
		model.addAttribute("action", "reply");
		return "board/form";
	}
	
	@PostMapping("/qna/reply")
	public String setReplyInsert(BoardVO boardVO, MultipartFile[] files)throws Exception{
		int result = qnaService.setReplyInsert(boardVO,files);
		
//		System.out.println(files.length);
//		for(MultipartFile f : files) {
//			System.out.println(f.getOriginalFilename());
//		}
		
		return "redirect:./list";
	}
	
	
	
}
