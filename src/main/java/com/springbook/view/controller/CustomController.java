package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// � ��Ʈ�ѷ� ��ü�� �˻��Ǵ��� ���� �ڵ�� �����ϱ� ���� ��Ʈ�ѷ� �������̽� 
public interface CustomController {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
