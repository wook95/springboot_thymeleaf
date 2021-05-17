package com.iu.ss1.board.qna;

import java.util.List;

import com.iu.ss1.board.BoardFileVO;
import com.iu.ss1.board.BoardVO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QnaVO extends BoardVO{

	
	
	private Long ref;
	private Long step;
	private Long depth;
	
	private List<BoardFileVO> files;
	
	
	//hashCode 객체의 주소를 10진수로 바꿔논것 해쉬
}
