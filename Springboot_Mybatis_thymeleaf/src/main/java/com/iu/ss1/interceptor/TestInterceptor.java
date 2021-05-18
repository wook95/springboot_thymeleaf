package com.iu.ss1.interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iu.ss1.member.MemberVO;

@Component
public class TestInterceptor implements HandlerInterceptor {

	//1 자바 클래스 생성
	//2 핸들러인터셉터어댑터 상속

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
//		HttpSession session = request.getSession();
//		Object obj = session.getAttribute("member");
//		MemberVO memberVO=null;
//		boolean result=false;
//		
//		if(obj != null) {
//			memberVO = (MemberVO)obj;
//			if(memberVO.getId().equals("admin")) {
//				result = true;
//			}
//			
//		}
//		
//		if(!result) {
//			response.sendRedirect("/member/login");
//		}
		
//		request.setAttribute("name", "data");
//		RequestDispatcher view = request.getRequestDispatcher("view경로");
//		view.forward(request, response);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {


		System.out.println("컨트롤러 종료 후");
		
		
		
		Map<String, Object> map = modelAndView.getModel();
		//컨트롤러에서 보내준 모델 꺼낼수 있다
		
		
		Iterator<String> it = map.keySet().iterator();
		//셋은 중복X, 순서 유지 안됨
		
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
			System.out.println(map.get(key));
		}
	
		//view의 경로르 확인하거나 변경 가능
		//modelAndView.getViewName(null);
		//modelAndView.setViewName(null);
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		
		System.out.println("Client 전송 전");
		
	}
	
	
	
	
	
	
}
