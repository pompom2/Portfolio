<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<style>
.container { width: 500px; margin: 20px auto;}
h1 { text-align: center;}
a { text-decoration: none; color: #196ab3; font-weight: bold; font-size: 1.05em;}
table { width: 100%; border: 1px solid black; border-collapse: collapse;}
tr { height: 70px;}
th, td { border: 1px solid black;}
th { background: #e9ecef;}
td { padding: 5px;}
.id, .password, .name { width: 150px; height: 20px;}
.email, .tel { width: 200px; height: 20px;}
.address { width: 380px; height: 20px;}
.ss { margin-top: 5px; font-size: 0.8em; font-weight: bold;}
.s1 { color: blue;}
.s2 { color: red;}
.btns { margin-top: 20px; text-align: center;}
.btns input { width: 100px; height: 35px; font-size: 1.02em; font-weight: bold; border-radius: 3px; cursor: pointer;}
input[type=submit] { background: #000; color: #fff; border: 1px solid #000;}
input[type=reset], input[type=button] { background: #868e96; color: #fff; border: 1px solid #868e96;}
#btn_id_check { width: 130px; height: 30px; font-size: 0.90em; font-weight: bold; background: #196ab3; border: 1px solid #196ab3; 
color: #fff; border-radius: 25px; cursor: pointer; margin-left: 10px;}
</style>
<script>
document.addEventListener("DOMContentLoaded", function() {
	let form = document.insertMemberForm;
	
	// 돌아가기 버튼
	let btn_back = document.getElementById("btn_back");
	btn_back.addEventListener("click", function() {
		location = "login.do";
	})
	
	// 아이디 중복 체크 버튼
	let btn_id_check = document.getElementById("btn_id_check");
	btn_id_check.addEventListener("click", function() {
		if (!form.id.value) {
			alert('아이디를 입력해 주새요');
			return;
		}
		form.action = "checkIdMember.do";
		form.submit();
	})
})
</script>
<body>
<div class="container">
	<h1>회원 가입</h1>
	<form action="insertMember.do" method="post" name="insertMemberForm">
		<table>
			<tr>
				<th width="20%">아이디</th>
				<td width="80%">
					<c:if test="${inId != 'notId' }"><input type="text" name="id" class="id" value="${inId }"></c:if>
					<c:if test="${inId == 'notId' }"><input type="text" name="id" class="id"></c:if>
					<input type="button" value="아이디 중복 체크" id="btn_id_check"><br>
					<c:if test="${inId != 'notId' }"><div class="ss s1">사용할 수 있는 아이디입니다.</div></c:if>
					<c:if test="${inId == 'notId' }"><div class="ss s2">사용할 수 없는 아이디입니다.</div></c:if>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="password" class="password"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" class="name"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" class="email"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="tel" class="tel"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" class="address"></td>
			</tr>
		</table>
		<div class="btns">
			<input type="submit" value="가입">
			<input type="reset" value="취소">
			<input type="button" value="돌아가기" id="btn_back">
		</div>
	</form>
</div>
</body>
</html>