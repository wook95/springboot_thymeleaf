package com.iu.ss1.aop.transfer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransferTest {

	@Autowired
	private Transfer transfer;
	@Autowired
	private Card card;
	
	@Test
	void test() {
		
		//oop
//		card.checkCard();
//		transfer.takeBus();
//		card.checkCard();
//		card.checkCard();
//		transfer.takeSubWay();
//		card.checkCard();

		//aop 관심 있는애들 실행
		//부수적인 애들 자동으로 실행
		transfer.takeBus();
		transfer.takeSubWay();
		
	}

	
	
	
	
}
