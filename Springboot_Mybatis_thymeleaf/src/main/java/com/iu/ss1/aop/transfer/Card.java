package com.iu.ss1.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {

	//트랜스퍼 패키지 안에 있는 모든 매서
	@Around("execution(* com.iu.ss1.aop.transfer.Transfer.*())")
	public Object checkCard(ProceedingJoinPoint joinPoint)throws Throwable {
		System.out.println("----------탑승 전 카드 태그 ----------");
		
		//joinPoint에는 핵심 메서드(버스, 지하찰)을 객체화 시킨것..!
		Object obj = joinPoint.proceed();
		
		
		System.out.println(obj);
		System.out.println("----------하차 시 카드 태그 ----------");
		return obj;
	}
	
//	@AfterReturning("execution(* com.iu.ss1.board.notice.NoticeService.get*(..))")
//	public void selectCheck() {
//		System.out.println("select query 정상 종료");
//	}
//	
}
