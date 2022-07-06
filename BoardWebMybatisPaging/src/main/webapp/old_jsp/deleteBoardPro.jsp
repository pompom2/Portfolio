<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.springbook.biz.board.*"%>
<%@page import="com.springbook.biz.board.impl.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 처리</title>
</head>
<body>
<%
//1. 요청 정보 획득
int seq = Integer.parseInt(request.getParameter("seq"));

//2. 객체 생성, DB 연동
BoardDTO dto = new BoardDTO();
dto.setSeq(seq);

BoardDAO boardDAO = new BoardDAO();
boardDAO.deleteBoard(dto);

//3. 화면 이동
response.sendRedirect("getBoardList.jsp");
%>
</body>
</html>