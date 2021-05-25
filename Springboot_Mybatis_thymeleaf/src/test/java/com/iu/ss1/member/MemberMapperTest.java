package com.iu.ss1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	
	
	@Test
	void setMemberRoleTest()throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("userName", "id3");
		map.put("roleName", "MEMBER");
		int result = memberMapper.setMemberRole(map);
		assertEquals(1, result);
	}
	
	
	
//	@Test
//	void test()throws Exception {
//
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("id3");
//		memberVO.setPw("pw3");
//		memberVO.setName("name3");
//		memberVO.setPhone("01010");
//		memberVO.setEmail("email.com");
//		memberVO.setEnabled(1);
//	
//		int result = memberMapper.setJoin(memberVO);
//		assertNotEquals(0, result);
//	
//	}

}
