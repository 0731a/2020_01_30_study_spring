package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.UserService;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	
	//ȸ�� ���
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	//ȸ�� ���
	public UserVO getUSer(UserVO vo) {
		return userDAO.getUSer(vo);
	}

}
