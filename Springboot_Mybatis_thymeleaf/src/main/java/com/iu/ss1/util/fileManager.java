package com.iu.ss1.util;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;



@Component
public class fileManager {
	
	@Autowired
	private ResourceLoader resourceLoader;
	//리소스 안에 있는 경로 가지고 온다
	//autowired 및 bean생성해야 된다
	
	

	public String save(MultipartFile multipartFile,String filePath)throws Exception{
		//filePath : resources/static/ 제외한 하위 경로
		
		/**
		 * 저장할 폴더가 시스템에 고정일 경우
		 * String path = "c:/upload"
		 * File file = new File(path,filePath);
		 * 밑에서 하는 것들은 경로를 알기 위해서 하는것들이다
		 * 
		 * **/
		
		
		
		
/**		첫번째 방법 resourceLoader
 * 		클래스패스 경로 받아오기 위해 사용
		//1. 경로 설정
		String path="classpath:/static/";
		File file = new File(resourceLoader.getResource(path).getFile(),filePath);
							//경로 string이라 getfile로 파일객체로 만들어줌 //경로명까지 있음
	
		
**/		
		//두번째 방법 클래스패스리소스
		//클래스 패스 경로 받아오기 위해 사용, 리소스로더와 다른점은 시작경로에서 classpath 제외
		String path="static";
		ClassPathResource classPathResource = new ClassPathResource(path);
		File file = new File(classPathResource.getFile(),filePath);
		
		
		System.out.println(file.getAbsolutePath());
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2.저장할 파일명 생성
		String fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		file = new File(file,fileName);
		//경로명, 파일명
		
		//3.파일저장
		multipartFile.transferTo(file);
		//FileCopyUtils.copy(multipartFile.getBytes(), file); 두번째방법
		
		
		
		return fileName;
	}
	
	
}
