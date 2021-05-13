package com.iu.ss1.board;

import java.util.List;

import com.iu.ss1.util.Pager;

public interface BoardMapper {

	
	
	
	//list
	public List<BoardVO> getList(Pager pager)throws Exception;
	
	//count
	public Long getTotalCount(Pager pager)throws Exception;
	//select
	public BoardVO getSelect(BoardVO boardVO)throws Exception;
	//insert
	public int setInsert(BoardVO boardVO)throws Exception;
	//file insert
	public int setFileInsert(BoardFileVO boardFileVO)throws Exception;
	
	//update
	public int setUpdate(BoardVO boardVO)throws Exception;
	//hitUpdate
	public int setHitUpdate(BoardVO boardVO)throws Exception;
	//delete
	public int setDelete(BoardVO boardVO) throws Exception;
	
	
}
