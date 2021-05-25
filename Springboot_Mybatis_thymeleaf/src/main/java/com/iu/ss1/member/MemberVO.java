package com.iu.ss1.member;

import java.util.Collection;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;



//Spring security에서 사용하는 VO가 존재
// userDetails
// 따로 생성 또는 구현

@Setter
@Getter
public class MemberVO implements UserDetails {


	
	
	private String username;
	private String password;
	private String pw1; //패스워드 확인용 변수
	@NotEmpty
	private String name;
	@Email
	private String email;
	private String phone;
	private boolean enabled;
	
	
	//해결 ,, id랑 pw이름 ,, enabled의타입 ,,,
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
}
