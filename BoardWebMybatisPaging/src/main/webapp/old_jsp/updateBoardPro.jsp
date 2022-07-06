<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.springbook.biz.board.*"%>
<%@page import="com.springbook.biz.board.impl.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 처리</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

//1. 요청 정보 획득
int seq = Integer.parseInt(request.getParameter("seq"));
String title = request.getParameter("title");
String content = request.getParameter("content");

//2. 객체 생성, DB 연동
BoardDTO dto = new BoardDTO();
dto.setSeq(seq);
dto.setTitle(title);
dto.setContent(content);

BoardDAO boardDAO = new BoardDAO();
boardDAO.updateBoard(dto);

// 3. 화면 이동
response.sendRedirect("getBoardList.jsp");

%>
</body>
</html>