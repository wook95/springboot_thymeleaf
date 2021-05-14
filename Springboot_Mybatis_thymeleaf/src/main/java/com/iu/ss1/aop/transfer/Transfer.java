package com.iu.ss1.aop.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {

	
	public void takeSubWay() {
		System.out.println("지하철 탑승");
		System.out.println("넷플 보기");
	}
	
	public void takeBus() {
		System.out.println("버스 탑승");
		System.out.println("벅스 듣기");
	}
	
	
	
	
}
