<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 관리자 페이지</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Luckiest+Guy&display=swap');
@import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300&display=swap');
#container { width: 300px; margin: 0 auto;}
a { text-decoration: none; color: black;}
/* 상단 - 메인, 서브 타이틀 */
.m_title  { font-family:  'Luckiest Guy', cursive; font-size: 50px; text-align: center; margin-bottom: 10px;}
.s_title { font-family: 'IBM Plex Sans KR', sans-serif; font-size: 1.7em; text-align: center; margin-bottom: 30px; font-weight: bold;}
.c_logout {font-family:  'IBM Plex Sans KR', sans-serif; text-align: center; margin-bottom: 20px; font-size: 0.9em; font-weight: bold;}
.c_logout a { color: #a49d8f; }
h3 { text-align: center;font-family:  'IBM Plex Sans KR', sans-serif;}
/* 테이블 메뉴 */
table { width: 100%; border: 1px solid black; border-collapse: collapse;
border-top: 3px solid black; border-bottom: 3px solid gray; border-left: hidden; border-right: hidden; }
tr { height: 50px; }
th { border: 1px solid black; }
.title_row { background: #e4dfd1; font-size: 1.1em;  font-family:  'IBM Plex Sans KR', sans-serif;}
.a_row { background: #f7f8f0; font-family:  'IBM Plex Sans KR', sans-serif;}
.a_row a { color: #79746d; }
</style>
<script>

</script>
</head>
<body>
<%
String managerId = (String)session.getAttribute("managerId");
if(managerId == null) {
	out.print("<script>location='logon/managerLoginForm.jsp';</script>");
}
%>
<div id="container">	
	<div class="m_title"><a href="#">Joy Yoga!</a></div>
	<div class="s_title">관리자 로그인</div>
	<h3>쇼핑몰 관리자 페이지</h3>
	<div class="c_logout"><a href="logon/managerLogout.jsp">로그아웃</a></div>
	<table>
		<tr class="title_row"><th>상품 관리</th></tr>
		<tr class="a_row"><th><a href="product/productRegisterForm.jsp">상품 등록</a></th></tr>
		<tr class="a_row"><th><a href="product/productList.jsp">상품 목록(수정/삭제)</a></th></tr>
		<tr class="title_row"><th>주문 관리</th></tr>
		<tr class="a_row"><th><a href="">주문 목록(수정/삭제)</a></th></tr>
		<tr class="title_row"><th>회원관리</th></tr>
		<tr class="a_row"><th><a href="">회원 목록(수정/삭제)</a></th></tr>
	</table>
</div>
</body>
</html>