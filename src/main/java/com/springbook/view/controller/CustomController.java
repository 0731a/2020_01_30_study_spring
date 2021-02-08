package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어떤 컨트롤러 객체가 검색되더라도 같은 코드로 실행하기 위한 컨트롤러 인터페이스 
public interface CustomController {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
