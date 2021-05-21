package com.iu.ss1.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {


	
	
	private String id;
	private String pw;
	private String pw1; //패스워드 확인용 변수
	@NotEmpty
	private String name;
	@Email
	private String email;
	private String phone;
	
}
