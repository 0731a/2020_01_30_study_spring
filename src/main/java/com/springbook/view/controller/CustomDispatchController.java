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
public class CustomDispatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomDispatchController() {
        super();
        // TODO Auto-generated constructor stub
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
		
		// 2. Ŭ���̾�Ʈ�� ��û path�� ���� ������ �б� ó�� 
		if(path.equals("/login.do")) {
			// ����ڰ� �Է��� ���̵�, ��й�ȣ�� �����Ͽ� �α����� ó���ϴ� jsp
			// 1. ����� �Է� ���� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB ���� ó�� 
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			// 3. ȭ�� �׺���̼�
			if( user != null ){
				response.sendRedirect("getBoardList.do");
			}else{
				response.sendRedirect("login.jsp");
			}
		}else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
		}else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ó��");
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ó��");
			
			// 1. ����� �Է� ���� ����(�˻� ����� ���߿� ����)
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			BoardDAOByJDBC boardDAO = new BoardDAOByJDBC();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			
			/* ������ �������� ���� �޸𸮿� �ϳ��� �����Ǵ� ��ü�̹Ƿ� ���� ���忡�� �δ㽺����
			 * HttpServletRequest�� �̿��Ͽ� ������ �δ� ���̱�
			 * HttpServletRequest ��ü�� Ŭ���̾�Ʈ�� ������ ��û�� �����Ҷ����� �Ź� ���Ӱ� ����, ���� ��ȯ�� �ٷ� �����Ǵ� 1ȸ�� ��ü 
			// 3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
			*/
			
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardListModel2.jsp");
		}
	}


}