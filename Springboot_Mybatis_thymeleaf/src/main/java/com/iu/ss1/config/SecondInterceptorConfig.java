package com.iu.ss1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.ss1.interceptor.SecondInterceptor;

@Configuration
public class SecondInterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private SecondInterceptor secondInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub

		registry.addInterceptor(secondInterceptor)
		.addPathPatterns("/notice/select")
		.order(0);
		
	
	}
	
	
}
