package com.iu.ss1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.iu.ss1.board.BoardFileVO;
import com.iu.ss1.board.BoardService;
import com.iu.ss1.board.BoardVO;
import com.iu.ss1.util.Pager;
import com.iu.ss1.util.FileManager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaMapper qnaMapper;

	@Autowired
	private FileManager fileManager;
	
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {

		pager.makeRow();
		pager.makeNum(qnaMapper.getTotalCount(pager));
		return qnaMapper.getList(pager);
	}

	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {

		qnaMapper.setHitUpdate(boardVO);
		return qnaMapper.getSelect(boardVO);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		
		//insert update insert 중 하나만 잘못되도(익셉션발생) rollback 될 수 있또록 --> transactional
		
		//1. qna table insert
		int result =  qnaMapper.setInsert(boardVO);
		
		//2. ref update
		result = qnaMapper.setRefUpdate(boardVO);
		
		//3. File save
		//예외 발생 안할경우 대비해 강제로 예외 발생
				if(result<1){
					throw new Exception();
			}
				
				String filePath="upload/qna/";
				
				
				for(MultipartFile multipartFile : files) {
					
					if(multipartFile.getSize()==0) {
						continue;
					}
					String fileName=fileManager.save(multipartFile, filePath);
						BoardFileVO boardFileVO = new BoardFileVO();
						boardFileVO.setFileName(fileName);
						boardFileVO.setOgName(multipartFile.getOriginalFilename());
						boardFileVO.setNum(boardVO.getNum());
						
						qnaMapper.setFileInsert(boardFileVO);
				}
		 
		 
		 return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
	
		return qnaMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		
		//원래는,, 글삭제 하고 파일 삭제도 해야댐
		
		return qnaMapper.setDelete(boardVO);
	}

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int setReplyInsert(BoardVO boardVO,MultipartFile[] files)throws Exception {
		//boardVO.num = 부모의 글 번호
		
		//답글에서는,, step을 먼저 증가해줘야된다
		int result = qnaMapper.setReplyUpdate(boardVO);

		// reply insert
		result = qnaMapper.setReplyInsert(boardVO);
		
		//첨부파일 hdd에 저장
		String filePath="upload/qna/";
		
		
		for(MultipartFile multipartFile : files) {
			
			if(multipartFile.getSize()==0) {
				continue;
			}
			String fileName=fileManager.save(multipartFile, filePath);
				BoardFileVO boardFileVO = new BoardFileVO();
				boardFileVO.setFileName(fileName);
				boardFileVO.setOgName(multipartFile.getOriginalFilename());
				boardFileVO.setNum(boardVO.getNum());
				
				qnaMapper.setFileInsert(boardFileVO);
		}
 
 
		return result;
	}
	
	
	
}
