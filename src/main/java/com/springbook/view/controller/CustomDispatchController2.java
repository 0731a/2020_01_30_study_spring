package com.springbook.view.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAOByJDBC;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

/**
 * Servlet implementation class CustomController
 */
public class CustomDispatchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomDispatchController2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Ŭ���̾�Ʈ ��û path ������ ����
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. HandlerMapping�� ���� path�� �ش��ϴ� Controller �˻�
		CustomController ctrl = handlerMapping.getController(path);
		
		// 3. �˻��� Controller�� ���� ����
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver�� ���� viewName�� �ش��ϴ� ȭ�� �˻�
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 5. �˻��� ȭ������ �̵��Ѵ�.
		response.sendRedirect(view);
		
	}


}