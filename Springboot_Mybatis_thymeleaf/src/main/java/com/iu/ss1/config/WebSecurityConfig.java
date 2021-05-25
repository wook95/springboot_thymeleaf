package com.iu.ss1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends  WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {

		//security를 무시(제외)
		web.ignoring()
		.antMatchers("/resources/**")
		.antMatchers("/images/**")
		.antMatchers("/css/**")
		.antMatchers("/js/**")
		.antMatchers("/vendor/**")
		.antMatchers("/favicon/**")
		;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.cors().and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/notice/list","/notice/select").permitAll()
			.antMatchers("/notice/**").hasRole("ADMIN")
			.antMatchers("/qna/list").permitAll()
			.antMatchers("qna/**").hasAnyRole("ADMIN","MEMBER")		
			.antMatchers("/member/join").permitAll()
			.antMatchers("/member/**").hasAnyRole("ADMIN","MEMBER")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			//로그인 페이지 따로 안 만들어도 기본 폼으로 이동하는데
			//내가 만든 폼으로 이동하고 싶으면 이렇게 !
			//어서라이즈 리퀘스트 한덩어리,, 폼 로그인은 다르 덩어리
			//and 쓰기 싫으면 http. 쓰면 된다
			.loginPage("/member/login")
			.permitAll()
			;
		

	}
	
}
