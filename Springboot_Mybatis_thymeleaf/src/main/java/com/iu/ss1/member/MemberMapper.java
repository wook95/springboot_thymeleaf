package com.iu.ss1.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.iu.ss1.board.BoardVO;

@Mapper
public interface MemberMapper {

	
	public int setJoin(MemberVO memberVO)throws Exception;
	public int setJoinFile(MemberFileVO memberFileVO)throws Exception;
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception;
	
	public int setUpdate(MemberVO memberVO)throws Exception;
	public int setDelete(MemberVO memberVO)throws Exception;
	public MemberVO getSelectId(MemberVO memberVO)throws Exception;
	
	
	public int setMemberRole(Map<String, String>map)throws Exception;
	
}
