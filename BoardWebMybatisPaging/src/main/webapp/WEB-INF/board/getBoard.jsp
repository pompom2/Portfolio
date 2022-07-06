<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
<style>
.container { width: 500px; margin: 20px auto;}
h1, .d1 { text-align: center;}
.d1 { margin-bottom: 20px;}
a { text-decoration: none; color: #1e94be; font-weight: bold; font-size: 1.05em;}
table { width: 100%; border: 1px solid black; border-collapse: collapse;}
tr { height: 40px;}
th, td { border: 1px solid black;}
th { background: #e9ecef;}
td { padding: 5px;}
table .seq { width: 100px; height: 20px; background: #f1f3f5;}
table .title { width: 380px; height: 20px;}
.btns { margin-top: 20px; text-align: center;}
.btns input { width: 100px; height: 35px; font-size: 1.05em; font-weight: bold; border-radius: 5px; cursor: pointer;}
.btns input[type=submit] { background: #000; color: #fff; border: 1px solid #000;}
.btns input[type=button] { background: #868e96; color: #fff; border: 1px solid #868e96;}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		let form = document.detailForm;
		
		// 글 삭제 처리
		let btn_delete = document.getElementById("btn_delete");
		btn_delete.addEventListener("click",function() {
			form.action = "deleteBoard.do";
			form.submit();
		})
		
		// 글 목록 보기
		let btn_board_list = document.getElementById("btn_board_list");
		btn_board_list.addEventListener("click",function() {
			form.action = "getBoardList.do";
			form.submit();
		})
	})
</script>
</head>
<body>
<div class="container">
	 <h1>글 상세 보기</h1>
	 <div class="d1"><a href="logout.do">LOGOUT</a></div>
	 <hr>
	 <form action="updateBoard.do" method="post" name="detailForm">
	 	<table>
	 		<tr>
	 			<th width="20%">글 번호</th>
	 			<td width="80%"><input type="text" name="seq" value="${board.seq}" readonly class="seq"></td>
	 		</tr>
	 		<tr>
	 			<th>제목</th>
	 			<td><input type="text" name="title" value="${board.title}" class="title"></td>
	 		</tr>
	 		<tr>
	 			<th>작성자</th>
	 			<td>${board.writer}</td>
	 		</tr>
	 		<tr>
	 			<th>내용</th>
	 			<td><textarea name="content" cols="51" rows="15">${board.content}</textarea></td>
	 		</tr>
	 		<tr>
	 			<th>등록 날짜</th>
	 			<td>${board.regdate}</td>
	 		</tr>
	 		<tr>
	 			<th>조회수</th>
	 			<td>${board.cnt}</td>
	 		</tr>
	 	</table>
	 	<div class="btns">
	 		<input type="submit" value="글 수정">&emsp;
	 		<input type="button" value="글 삭제" id="btn_delete">&emsp;
	 		<input type="button" value="글 목록" id="btn_board_list">
	 	</div>
	 </form>
</div>



</body>
</html>