package com.iu.ss1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.ss1.board.BoardFileVO;
import com.iu.ss1.board.BoardService;
import com.iu.ss1.board.BoardVO;
import com.iu.ss1.util.Pager;
import com.iu.ss1.util.fileManager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private fileManager fileManager;
	

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		
		return noticeMapper.getTotalCount(pager);
	}

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(getTotalCount(pager));
		return noticeMapper.getList(pager);
		
	}

	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {
		noticeMapper.setHitUpdate(boardVO);
		return  noticeMapper.getSelect(boardVO);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		
		
		int result= noticeMapper.setInsert(boardVO);
		//레거시에선, request에서 뽑은 realPath-- webapp에 있었는데 이젠 statatic이 클래스패스로 ,,
		String filePath="upload/notice/";
		
		//예외 발생 안할경우 대비해 강제로 예외 발생
		if(result<1){
			throw new Exception();
	}
		
		
		
		
		for(MultipartFile multipartFile : files) {
			
			if(multipartFile.getSize()==0) {
				continue;
			}
			String fileName=fileManager.save(multipartFile, filePath);
				BoardFileVO boardFileVO = new BoardFileVO();
				boardFileVO.setFileName(fileName);
				boardFileVO.setOgName(multipartFile.getOriginalFilename());
				boardFileVO.setNum(boardVO.getNum());
				
				noticeMapper.setFileInsert(boardFileVO);
		}
		
		
		
		
		return result;
		//return noticeMapper.setInsert(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		
		return noticeMapper.setDelete(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		
		return noticeMapper.setUpdate(boardVO);
	}

}
