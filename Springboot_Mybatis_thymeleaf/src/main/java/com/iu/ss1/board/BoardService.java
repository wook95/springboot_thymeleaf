package com.iu.ss1.board;

import java.util.List;

import com.iu.ss1.util.Pager;

public interface BoardService {
	
	
	//list select count insert update deleete hit
	
	public List<BoardVO> getList(Pager pager)throws Exception;
	public BoardVO getSelect(BoardVO boardVO)throws Exception;
	public int setInsert(BoardVO boardVO) throws Exception;
	public int setUpdate(BoardVO boardVO) throws Exception;
	public int setDelete(BoardVO boardVO) throws Exception;
	public Long getTotalCount(Pager pager)throws Exception;
	
	
}
