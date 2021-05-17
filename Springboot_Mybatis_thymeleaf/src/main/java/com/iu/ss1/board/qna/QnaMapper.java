package com.iu.ss1.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.iu.ss1.board.BoardMapper;
import com.iu.ss1.board.BoardVO;

@Mapper
public interface QnaMapper extends BoardMapper{
	
	
	public int setReplyInsert(BoardVO boardVO)throws Exception;
	//보드vo에는 ref, step , depth 없어서 서브쿼리 써줘야함
	
	public int setReplyUpdate(BoardVO boardVO)throws Exception;
	
	
	
	public int setRefUpdate(BoardVO boardVO)throws Exception;
}
