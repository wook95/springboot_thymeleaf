package com.iu.ss1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.ss1.board.BoardVO;
import com.iu.ss1.board.notice.NoticeMapper;

@SpringBootTest
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	
	@Test
	void test() throws Exception{
		
		List<BoardVO> ar = noticeMapper.getList();
		
		
		for(BoardVO boardVO:ar) {
			System.out.println(boardVO.toString());
		}
		
		
		assertNotEquals(0, ar.size());
		
	}

}
