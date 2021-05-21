package com.iu.ss1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;

import com.iu.ss1.board.BoardFileVO;
import com.iu.ss1.board.BoardVO;
import com.iu.ss1.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager; 
	
	
	public boolean memberError(MemberVO memberVO,Errors errors)throws Exception{
		boolean result = false;
		
		//기본 제공 검증
//		if(errors.hasErrors()) {
//			result=true;
//		}
		result = errors.hasErrors();
		
		
		
		//paassword가 일치여부 검증
		if(!memberVO.getPw().equals(memberVO.getPw1())) {
			errors.rejectValue("pw1","memberVO.password.notEqual");
						//form path, properties의 키 값
			result = true;
		}
		if(memberVO.getId().equals("admin")
				||
			memberVO.getId().equals("administrator")) {
			errors.rejectValue("id", "memberVO.id.admin");
			result = true;
		}
		if(memberMapper.getSelectId(memberVO)!=null) {
			errors.rejectValue("id", "memberVO.id.duplicate");
			result = true;
		}
		//admin, administrator로 가입하면 안된다고 메세지 고
		
		
		return result;
	}
	
	
	
	
	
	public int setJoin(MemberVO memberVO,MultipartFile file)throws Exception{
		
		//member table 저장
		//hdd에 파일 저장
		//memberFiles 테이블 저장
		
		int result = memberMapper.setJoin(memberVO);
		
		String filePath="upload/member";
		System.out.println(file);
		
		if(file!=null) {
			
		
		String fileName=fileManager.save(file, filePath);
			MemberFileVO memberFileVO = new MemberFileVO();
			memberFileVO.setFileName(fileName);
			memberFileVO.setId(memberVO.getId());
			memberFileVO.setOgName(file.getOriginalFilename());
			result = memberMapper.setJoinFile(memberFileVO);
			
		}	
		
		
		
		return result;
	}
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getLogin(memberVO);
	}
	
	public int setUpdate(MemberVO memberVO)throws Exception{
		return memberMapper.setUpdate(memberVO);
	}
	public int setDelete(MemberVO memberVO)throws Exception{
		return memberMapper.setDelete(memberVO);
		
	}
	public MemberVO getSelectId(MemberVO memberVO)throws Exception{
		return memberMapper.getSelectId(memberVO);
	}
	
	
}
