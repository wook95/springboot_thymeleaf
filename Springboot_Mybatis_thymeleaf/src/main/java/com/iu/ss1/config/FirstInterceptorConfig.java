package com.iu.ss1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.ss1.interceptor.FirstInterceptor;

@Configuration
public class FirstInterceptorConfig  implements WebMvcConfigurer{

	@Autowired
	private FirstInterceptor firstInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(firstInterceptor)
		.addPathPatterns("/notice/**")
		.order(1);

	
	
	}
	
	
}
