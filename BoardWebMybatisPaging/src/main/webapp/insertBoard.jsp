<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
table .writer { width: 150px; height: 20px; background: lightgray;}
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
	<h1>글 등록</h1>
	<div class="d1"><a href="logout.do">로그아웃</a></div>
	<form action="insertBoard.do" method="post" name="insertForm">
		<table>
			<tr>
				<th width="20%">제목</th>
				<td width="80%"><input type="text" name="title" class="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" class="writer" value="${member.id }" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="52" rows="20"></textarea></td>
			</tr>
		</table>
		<div class="btns">
			<input type="submit" value="글 등록">&ensp;
			<input type="button" value="목록 보기" id="btn_board_list">
		</div>
	</form>
</div>
</body>
</html>