package com.iu.ss1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.ss1.board.BoardService;
import com.iu.ss1.board.BoardVO;
import com.iu.ss1.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	

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
		
		return  noticeMapper.getSelect(boardVO);
	}

	@Override
	public int setInsert(BoardVO boardVO) throws Exception {
		
		return noticeMapper.setInsert(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}