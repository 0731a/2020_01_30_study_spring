package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.GetBoardListController;
import com.springbook.view.user.LoginController;

//  모든  Controller 객체들을 저장
// 클라이언트의 요청이 들어 올 경우 요청을 처리할 특정 Controller 검색기능 제공 
// DispatchServlet이 사용하는 객체  (DispatchServlet init 메소드 호출시 생성 됨)
public class HandlerMapping {
	private Map<String, CustomController> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, CustomController>();
		mappings.put("/login.do",new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
	}
	
	public CustomController getController(String path) {
		return mappings.get(path);
	}

}
