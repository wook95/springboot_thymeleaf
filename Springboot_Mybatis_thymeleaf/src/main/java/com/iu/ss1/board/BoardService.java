package com.iu.ss1.board;

import java.util.List;

public interface BoardService {
	
	
	//list select count insert update deleete hit
	
	public List<BoardVO> getList()throws Exception;
	public BoardVO getSelect(BoardVO boardVO)throws Exception;
	public int setInsert(BoardVO boardVO) throws Exception;
	public int setUpdate(BoardVO boardVO) throws Exception;
	public int setDelete(BoardVO boardVO) throws Exception;

	
	
}
