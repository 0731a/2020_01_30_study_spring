package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserVO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
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
