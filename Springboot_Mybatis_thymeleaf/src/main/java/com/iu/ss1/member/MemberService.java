package com.iu.ss1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
