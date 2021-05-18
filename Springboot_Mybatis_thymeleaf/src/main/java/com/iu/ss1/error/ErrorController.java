package com.iu.ss1.error;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

	
	@ExceptionHandler(NullPointerException.class)
	public String getNull(Model model) {
		
		model.addAttribute("msg", "널 발생");
		
		return "error/500";
	}
	@ExceptionHandler(SQLException.class)
	public String getsql(Model model) {
		
		model.addAttribute("msg", "DB 문제 발생");
		
		return "error/500";
	}
	@ExceptionHandler(Exception.class)
	public String getException(Model model) {
		
		model.addAttribute("msg", "exception 발생");
		
		return "error/500";
	}
	@ExceptionHandler(Throwable.class)
	public String getAll(Model model) {
		
		model.addAttribute("msg", "관리자에게 문의하세요");
		
		return "error/500";
	}
	
	@ExceptionHandler(MyException.class)
	public String getMyException(Model model,Exception exception) {
		
		
		model.addAttribute("msg", exception.getMessage());
		return "error/500";
	}
	
	
	
}
