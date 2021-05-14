package com.iu.ss1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
//FileDown fd(참조변수명) = new FileDonw();
// 참조변수명.메서드명()
// 개발자가 따로 지정하지 않으면 클래스명의 첫글자를 소문자로 바꾼것이 참조변수명
//컴포넌트("참조변수명")으로 변수명 설정 가능
public class FileDown extends AbstractView{

	//추상클래스여서,, 추상매서드 있을시 오버라이딩 해줘야되서 빨간줄 간다
	
	//스프링에서 만들어주는 객체 중 하나
	@Autowired
	private ResourceLoader resourceLoader;
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("cuustom view");
		String fileName = (String)model.get("fileName");
		String filePath = (String)model.get("filePath");
		String ogName = (String)model.get("ogName");
		
//		System.out.println("fileName : " +fileName);
//		System.out.println("filePath : " +filePath);
	
		
		//경로 처리
		String path = "classpath:/static/";
	
		File file =  new File(resourceLoader.getResource(path).getFile(),filePath);
//		System.out.println(file.getAbsolutePath());
		
		
		//경로+이름으로 파일 특정
		file=new File(file,fileName);
		
		
		//한글 처리
				response.setCharacterEncoding("UTF-8");
				
		//총 파일의 크기 - 다운 속도 계산 위해
				response.setContentLengthLong(file.length());

		//다운로드시 파일 이름을 인코딩 처리 - ogName 넣어주삼
		fileName = URLEncoder.encode(ogName, "UTF-8");

		//header 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"" ); //다운로드 파 이름 보내줌
		response.setHeader("Content-Transfer-Encoding", "binary");	//서버에서 보내는 컨텐츠는 텍스트도 동영상도 다 되니까 2진비트입니다 라고말해줌
		//헤더에는 그런 정보,, 엑셀파일 누르면 엑셀파일 실행시키는 프로그램 실행되고 그런것들이 저장된다
		
		//HDD에서 파일을 읽고
				FileInputStream fi = new FileInputStream(file);
				//Client로 전송 준비
				OutputStream os = response.getOutputStream();
				
				//전송
				FileCopyUtils.copy(fi, os);
				
				os.close();
				fi.close();
		
	}
	//model : ModelAndView 의 Model 객체

	
	
		
}
