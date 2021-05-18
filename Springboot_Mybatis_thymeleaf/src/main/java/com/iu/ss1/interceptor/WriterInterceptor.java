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

import com.iu.ss1.board.BoardVO;
import com.iu.ss1.member.MemberVO;

//상세페이지에서 작성자만 수정,삭제 볼수 있도록


@Component
public class WriterInterceptor implements HandlerInterceptor{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		//작성자 출력
		//writerInterceptorConfig
		
		
		
		//0.메서드 형식 구하기
		
		String method = request.getMethod();
		
		if(method.equals("GET")) {
			this.check(request, modelAndView);
		}
		
		

	
	}
	
	
	private void check(HttpServletRequest request, ModelAndView modelAndView) {
		
		//1로그인
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		String myId=null;
		String writerId=null;
		
		if(obj!=null) {
			
			MemberVO memberVO = (MemberVO)obj;

			myId=memberVO.getId();
		}
		
		
		//2.작성자
		BoardVO boardVO = (BoardVO)modelAndView.getModel().get("vo");

		writerId=boardVO.getWriter();
		

		//4. 로그인 안했으면
		//common/result 이동
		//alert 로그인 필요, 로그인 이동

		if(myId==null) {
			
			
//			request.setAttribute("msg","로그인 필요");
//			request.setAttribute("path","/member/login");
//			RequestDispatcher view = request.getRequestDispatcher("/common/result");
//			view.forward(request, response);
			//pre에서 보내는 방식이었다
			
			modelAndView.setViewName("common/result");
			modelAndView.addObject("msg","로그인 필요");
			modelAndView.addObject("path","../member/login");
			
		}else {
		
		
		
		//3. 유저와 작성자가 일치하지 않으면 
		//common/ result로 이동
		//alert 작성자가 아님, list로 이동
		
		
			if(!myId.equals(writerId)) {
				
				modelAndView.setViewName("common/result");
				modelAndView.addObject("msg","작성자가 아님");
				modelAndView.addObject("path","./list");
				
				
				}
		
		
		}
	}//end of method
	
	
	
}
