<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글등록</title>
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
table .writer { width: 150px; height: 20px;}
.btns { margin-top: 20px; text-align: center;}
.btns input { width: 100px; height: 35px; font-size: 1.02em; font-weight: bold; border-radius: 3px; cursor: pointer;}
.btns input[type=submit] { background: #000; color: #fff; border: 1px solid #000;}
.btns input[type=button] { background: #868e96; color: #fff; border: 1px solid #868e96;}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		let form = document.insertForm;
			
		// 글목록 버튼 처리
		let btn_board_list = document.getElementById("btn_board_list");
		btn_board_list.addEventListener("click", function() {
			form.action = "getBoardList.do";
			form.submit();
		})
	})
</script>
</head>
<body>
<div class="container">
	<h1><spring:message code="message.board.insert.title"/></h1>
	<div class="d1"><a href="logout.do"><spring:message code="message.board.insert.logout"/></a></div>
	<form action="insertBoard.do" method="post" name="insertForm" enctype="multipart/form-data">
		<table>
			<tr>
				<th width="20%"><spring:message code="message.board.insert.table.head.title"/></th>
				<td width="80%"><input type="text" name="title" class="title"></td>
			</tr>
			<tr>
				<th><spring:message code="message.board.insert.table.head.writer"/></th>
				<td><input type="text" name="writer" class="writer"></td>
			</tr>
			<tr>
				<th><spring:message code="message.board.insert.table.head.content"/></th>
				<td><textarea name="content" cols="52" rows="20"></textarea></td>
			</tr>
			<tr>
				<th><spring:message code="message.board.insert.table.head.upload"/></th>
				<td><input type="file" name="uploadFile"></td>
			</tr>
		</table>
		<div class="btns">
			<input type="submit" value="<spring:message code="message.board.insert.insertButton"/>">&ensp;
			<input type="button" value="<spring:message code="message.board.insert.boardListButton"/>" id="btn_board_list">
		</div>
	</form>
</div>
</body>
</html>