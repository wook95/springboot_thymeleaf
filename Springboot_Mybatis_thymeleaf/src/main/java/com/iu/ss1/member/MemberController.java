package com.iu.ss1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("join")
	public String setJoin()throws Exception{
		
		
		
		
		return "member/join";
	}
	@GetMapping("login")
	public String getLogin()throws Exception{

		return "member/login";
	}
	@PostMapping("login")
	public String getLogin(MemberVO memberVO,HttpSession session)throws Exception{
		System.out.println(memberVO);
		memberVO=memberService.getLogin(memberVO); 
		System.out.println(memberVO);
		session.setAttribute("member", memberVO);
		return "redirect:/";
	}
	@GetMapping("logout")
	public String setLogout()throws Exception{
		return "member/logout";
	}
	@GetMapping("myPage")
	public String getMyPage()throws Exception{
		return "member/myPage";
	}
	
}
