package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAOByJDBC;
import com.springbook.view.controller.CustomController;

public class GetBoardListController implements CustomController {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �˻� ó��");
		
		// 1. ����� �Է� ���� ����(�˻� ����� ���߿� ����)
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		BoardDAOByJDBC boardDAO = new BoardDAOByJDBC();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardListModel2";
	}
}
