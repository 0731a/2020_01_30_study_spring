package com.springbook.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳� ���� 
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷ� ���� UserImpl ��ü�� Lookup �Ѵ�.
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. �α��� ��� �׽�Ʈ 
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("1234");
		
		UserVO user = userService.getUSer(vo);
		if(user != null) {
			System.out.println(user.getName()+"�� ȯ���մϴ�.");
		}else {
			System.out.println("�α��� ����");
		}
		
		// 4. Spring �����̳� ���� 
		container.close();
		
	}
}
