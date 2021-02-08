package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.GetBoardListController;
import com.springbook.view.user.LoginController;

//  ���  Controller ��ü���� ����
// Ŭ���̾�Ʈ�� ��û�� ��� �� ��� ��û�� ó���� Ư�� Controller �˻���� ���� 
// DispatchServlet�� ����ϴ� ��ü  (DispatchServlet init �޼ҵ� ȣ��� ���� ��)
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
