<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@page contentType="text/html" charset="EUC-KR"%>

<%
	// Model 1 방식 
	// 사용자가 입력한 아이디, 비밀번호를 추출하여 로그인을 처리하는 jsp
	// 1. 사용자 입력 정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB 연동 처리 
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	// 3. 화면 네비게이션
	if( user != null ){
		response.sendRedirect("getBoard.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
	
%>
	
	