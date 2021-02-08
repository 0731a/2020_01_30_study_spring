<%@page import="java.util.List" %>
<%@page import="com.springbook.biz.board.impl.BoardDAOByJDBC" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<% 
	// ���ǿ� ����� �� ��� ������
	List<BoardVO> boardList = (List) session.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="EUC-KR">
<title>�� ���</title>
</head>
<body>
<center>
<h1>�۸��</h1>
<h3>�׽�Ʈ�� ȯ���մϴ�...<a href="logout_proc.jsp">Log-out</a></h3>

<!-- �˻� ����  -->
<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<td align="right">
		<select name="searchCondition">
		<option value="TITLE">����
		<option value="CONTENT">����
		</select>
		<input name="searchKeyword" type="text" />
		<input type="submit" value="�˻�" />
	</td>
</table>
</form>

<!-- �˻� ����  -->
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100">��ȣ</th>
	<th bgcolor="orange" width="200">����</th>
	<th bgcolor="orange" width="150">�ۼ���</th>
	<th bgcolor="orange" width="150">�����</th>
	<th bgcolor="orange" width="100">��ȸ��</th>
</tr>

<% for(BoardVO board:boardList){ %>
<tr>
	<td><%= board.getSeq()%></td>
	<td><a href="getBoard.jsp?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></th>
	<td><%= board.getWriter() %></td>
	<td><%= board.getRegDate() %></td>
	<td><%= board.getCnt() %></td>
</tr>
<% } %>

</table>
<br>
<a href="insertBoard.jsp">���� ���</a>
</center>
</body>
</html>