package com.iu.ss1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.ss1.member.MemberVO;

@Component
public class AdminInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		boolean result = false;
		MemberVO memberVO = null;
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		
		if(obj!=null) {
			memberVO = (MemberVO)obj;
			if(memberVO.getId().equals("admin")) {
				result=true;
			}
		}
		
		
	if(!result) {
		//1. redirect login
		//response.sendRedirect("/member/login");
		
		
		request.setAttribute("msg", "관리자가 아님");
		request.setAttribute("path", "../member/login");
		RequestDispatcher view = request.getRequestDispatcher("../common/result");
		view.forward(request, response);
		
		
	}
		
		
		
		
	return result;
	
	}
	
	//controller 진입 전 admin 판별
	//admin이면 진행
	//아니라면 1.로그인폼으로 리다이렉트
	//2.권한이 없음 alert, index로 이동
	
	//adminInterceptorConfig
	// notice insert update delete
	
	
	
	
}
