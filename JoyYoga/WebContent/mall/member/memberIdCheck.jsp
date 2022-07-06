<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mall.member.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberIdCheck</title>
</head>
<body>
	<% 
	// ID 중복 체크 처리 페이지
	String id = request.getParameter("id");
	
	MemberDAO memberDAO = MemberDAO.getInstance();
	int cnt = memberDAO.checkID(id);
	%>
	
	<script>
	<% if(cnt > 0) {%> <%-- 가입 가능한 아이디 --%>
		alert('사용가능한 아이디입니다.');
	<%} else {%>	<%-- 가입 불가능한 아이디 (이미 존재하는 아이디) --%>
		alert(`이미 존재하는 아이디입니다.\n다른 아이디를 입력하시오.`);
	<%} %>
	history.back();
	</script>
</body>
</html>