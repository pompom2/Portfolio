<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<style>
.container { width: 500px; margin: 20px auto;}
h1, .d1 { text-align: center;}
.d1 { margin-bottom: 20px;}
a { text-decoration: none; color: #196ab3; font-weight: bold; font-size: 1.05em;}
table { width: 100%; border: 1px solid black; border-collapse: collapse;}
tr { height: 40px;}
th, td { border: 1px solid black;}
th { background: #e9ecef;}
td { padding: 5px;}
table .seq { width: 100px; height: 20px; background: #f1f3f5;}
table .title { width: 380px; height: 20px;}
table .writer { width: 380px; height: 20px; background: lightgray;}
.btns { margin-top: 20px; text-align: center;}
.btns input { width: 100px; height: 35px; font-size: 1.02em; font-weight: bold; border-radius: 3px; cursor: pointer;}
.btns input[type=submit] { background: #000; color: #fff; border: 1px solid #000;}
.btns input[type=button] { background: #868e96; color: #fff; border: 1px solid #868e96;}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		let form = document.detailForm;
		let pageNum = form.pageNum.value;
		
		// 글목록 버튼 처리
		let btn_board_list = document.getElementById("btn_board_list");
		btn_board_list.addEventListener("click", function() {
			form.action = "getBoardList.do?pageNum=" + pageNum;
			form.submit();
		})
		
		// 글삭제 버튼 처리
		let btn_delete = document.getElementById("btn_delete");
		btn_delete.addEventListener("click", function() {
			form.action = "deleteBoard.do";
			form.submit();
		})
		
	})
</script>
</head>
<body>
<div class="container">
	<h1>글 상세</h1>
	<div class="d1"><a href="logout.do">로그아웃</a></div>
	<form action="updateBoard.do" method="post" name="detailForm">
	<input type="hidden" name="pageNum" value="${param.pageNum }">
	<table>
		<tr>
			<th width="20%">번호</th>
			<td width="80%"><input type="text" name="seq" value="${board.seq }" readonly class="seq"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${board.title }" class="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${board.writer }" class="writer" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" cols="52" rows="15">${board.content }</textarea></td>
		</tr>
		<tr>
			<th>동록 날짜</th>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.regdate}"/></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.cnt }</td>
		</tr>
	</table>
	<div class="btns">
		<c:if test="${member.id == board.writer }">
			<input type="submit" value="글 수정">&ensp;
			<input type="button" value="글 삭제" id="btn_delete">&ensp;
		</c:if>
		<input type="button" value="목록 보기" id="btn_board_list">
	</div>
	</form>
</div>
</body>
</html>