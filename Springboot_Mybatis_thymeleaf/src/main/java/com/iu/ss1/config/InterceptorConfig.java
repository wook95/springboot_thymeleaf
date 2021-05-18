package com.iu.ss1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.ss1.interceptor.TestInterceptor;

//@Configuration //이게 xml역할을 합니다. 라는 어노테이션
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private TestInterceptor TestInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터 빈을 등록
		//어떤 url이 왔을때 interceptor를 발동시킬거냐
		//add - 인터셉터 적용할 url 등록, exclude 제외
		//registry.add를 만들어도, config.java파일을 만들어도 된다
		
		registry.addInterceptor(TestInterceptor)
//		.addPathPatterns("/notice/**")
		.addPathPatterns("/qna/**");
//		.excludePathPatterns("/notice/list");
		
		
		//체인룰,, 세미콜론 안쓴다 마지막까지
		
		//WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
}
