<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
<style>
.container { width: 300px; margin: 20px auto;}
h1 { text-align: center;}
.a_tags { text-align: center;}
a { text-decoration:none; color:#000;}
table { width: 100%; border: 1px solid black; border-collapse: collapse;}
tr { height: 50px;}
th, td { border: 1px solid black;}
th { background: #e9ecef;}
td { padding-left: 5px;}
tr:nth-of-type(3) td { text-align: center;}
input[type=text], input[type=password] { width: 190px; height: 25px;}
input[type=submit] { width: 100px; height: 35px; font-size: 1.03em; font-weight: bold;}
</style>
</head>
<body>
<div class="container">
	<h1><spring:message code="message.member.login.title"/></h1>
	<div class="a_tags">
	<a href="login.do?lang=en"><spring:message code="message.member.login.language.en"></spring:message></a> | 
	<a href="login.do?lang=ko"><spring:message code="message.member.login.language.ko"></spring:message></a>
	</div>
	<hr>
	<form action="login.do" method="post">
	<table>
		<tr>
			<th width="30%"><spring:message code="message.member.login.id"/></th>
			<td width="70%"><input type="text" name="id"></td>
		</tr>
		<tr>
			<th><spring:message code="message.member.login.password"/></th>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="<spring:message code="message.member.login.loginButton"/>"></td>
		</tr>
	</table>
	</form>
	<hr>
</div>
</body>
</html>