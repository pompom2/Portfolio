<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.springbook.biz.member.*"%>
<%@page import="com.springbook.biz.member.impl.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
<style>

</style>
</head>
<body>

<%
request.setCharacterEncoding("utf-8");
// 1. 클라이언트의 입력 정보 획득
String id = request.getParameter("id");
String password = request.getParameter("password");

// 2. 객체 생성 및 DB 연동
MemberDTO dto = new MemberDTO();
dto.setId(id);
dto.setPassword(password);

MemberDAO memberDAO = new MemberDAO();
MemberDTO member = memberDAO.getMember(dto);

// 3. 화면 이동
if(member != null) {
	response.sendRedirect("getBoardList.jsp");
} else {
	response.sendRedirect("login.jsp");
}
%>

</body>
</html>