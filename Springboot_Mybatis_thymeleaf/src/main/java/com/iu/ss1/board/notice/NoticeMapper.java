package com.iu.ss1.board.notice;

import org.apache.ibatis.annotations.Mapper;

import com.iu.ss1.board.BoardMapper;


//@repository 는 새로운 객체를 만들어주는것이라 ,, 이젠 쓰지 않는다
//어떻게 찾아가는지 원리에 대해서 알아야해

@Mapper
public interface NoticeMapper extends BoardMapper {

}



//database-mappers-noticemapper에서 네임스페이스를 보고 여길로 와
//노티스매퍼라는 네임스페이스 알아서 찾아간다 ,, 패키지명 + 인터페이스 이름으
