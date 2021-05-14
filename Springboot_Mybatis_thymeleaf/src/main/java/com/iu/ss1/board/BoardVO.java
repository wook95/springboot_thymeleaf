package com.iu.ss1.board;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
@Setter
@Getter
@ToString			//toSTring override
@NoArgsConstructor		//default constructor
@AllArgsConstructor		//매개변수가 있는 생성자
@EqualsAndHashCode		//hash, equals 메서드
@RequiredArgsConstructor //필수 매개변수만 있는 생성자

**/
@Data
public class BoardVO {

	
	private Long num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private Long hit;
	private List<BoardFileVO> boardFiles;
	
	
}
