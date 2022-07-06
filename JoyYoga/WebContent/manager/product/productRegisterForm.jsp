<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 폼</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Luckiest+Guy&display=swap');
@import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300&display=swap');
#container { width: 550px; margin: 0 auto;}
a { text-decoration: none; color: black; }
/* 상단 - 메인, 서브 타이틀 */
.m_title { font-family:  'Luckiest Guy', cursive; font-size: 50px;text-align: center; margin-bottom: 10px;}
.s_title { font-family: 'IBM Plex Sans KR', sans-serif; font-size: 1.7em; text-align: center; margin-bottom: 30px; font-weight: bold; }
.c_logout { text-align: center; margin-bottom: 20px; font-size: 0.9em; font-weight: bold;}
.c_logout a { color: #54d6c1; }
/* 중단 - 상품 등록 테이블 */
table {font-family: 'IBM Plex Sans KR', sans-serif; width: 100%; border: 1px solid #c89072; border-collapse: collapse;
border-top: 5px solid #c89072; border-bottom: 5px solid #c89072; border-left: hidden; border-right: hidden;}
tr { height: 35px;}
td, th { border: 1px solid #c89072; }
th { background: #f7f8f0; }
td { padding-left: 5px;}
/* 중단 - 테이블 안의 입력상자 */
input[type="number"] { width: 100px;}
textarea { margin: 5px 0 2px 0; }
/* 하단 - 버튼 */
select { height: 24px; }
input::file-selector-button { font-family: 'IBM Plex Sans KR', sans-serif; width: 80px; height: 28px; background:#c89072; color: #fff; border: none; 
border-radius: 3px; font-weight: bold; cursor: pointer;}
.btns{ text-align: center; margin-top: 20px;}
.btns input{ font-family: 'IBM Plex Sans KR', sans-serif; width : 100px; height: 37px; border: none; background: #d5ba99; color: #fff; 
font-weight: bold; margin: 5px; cursor: pointer; }
.btns input:nth-child(1) { background: #c89072;}
.btns input:nth-child(1):hover { border: 2px solid #c89072; background: #fff; color: #c89072; font-weight: bold; }
</style>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		let form = document.registerForm;
		
		// 상품 등록  폼 페이지
		let btn_register = document.getElementById("btn_register");
		btn_register.addEventListener("click", function() {
			
			if(!form.product_name.value) {
				alert('상품 제목을 입력하시오.');
				return;
			}
			if(!form.product_price.value) {
				alert('상품 가격을 입력하시오.');
				return;
			}
			if(!form.product_count.value) {
				alert('상품 수량을 입력하시오.');
				return;
			}
			if(!form.product_brand.value) {
				alert('제조사를 입력하시오.');
				return;
			}
			if(!form.product_country.value) {
				alert('원산지를 입력하시오.');
				return;
			}
			if(!form.discount_rate.value) {
				alert('할인율을 입력하시오.');
				return;
			}
			
			form.submit();
		})
		
		// 상품 목록 페이지로 이동
		let btn_list = document.getElementById("btn_list");
		btn_list.addEventListener("click", function() {
			location = 'productList.jsp';
		})
		
		// 관리자 페이지로 이동
		let btn_main = document.getElementById("btn_main");
		btn_main.addEventListener("click", function() {
			location = '../managerMain.jsp';
		})
		
	})
</script>
</head>
<body>
<%
String managerId = (String)session.getAttribute("managerId");
if(managerId == null) {
	out.print("<script>location='../logon/managerLoginForm.jsp';</script>");
}
%>
<div id="container">
	<div class="m_title"><a href="../managerMain.jsp">Joy Yoga!</a></div>
	<div class="s_title">상품 등록</div>
	
	<form action="productRegisterPro.jsp" method="post" name="registerForm" enctype="multipart/form-data">
		<table>
			<tr>
				<th width="20%">상품 분류</th>
				<td width="80%">
					<select name="product_kind">
						<option value="110" selected>요가 매트</option>
						<option value="120">타월</option>
						<option value="210">상의</option>
						<option value="220">하의</option>
						<option value="230">요가 양말</option>
						<option value="310">요가 블럭</option>
						<option value="320">스트랩</option>
						<option value="330">덤벨 & 케틀벨</option>
						<option value="340">짐볼 & 웨이트볼</option>
						<option value="410">가방 & 슬링</option>
						<option value="420">아이필로우</option>
						<option value="430">요가밴드</option>
						<option value="440">마사지볼</option>
						<option value="510">다이어트 식품</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>상품 제목</th>
				<td><input type="text" name="product_name" size="58"></td>
			</tr>
			<tr>
				<th>상품 가격</th>
				<td><input type="number" name="product_price" min="1000" max="1000000" >원</td>
			</tr>
			<tr>
				<th>상품 수량</th>
				<td><input type="number" name="product_count" min="0" max="100000">개</td>
			</tr>
			<tr>
				<th>제조사</th>
				<td><input type="text" name="product_brand" size="15"></td>
			</tr>
			<tr>
				<th>원산지</th>
				<td><input type="text" name="product_country" size="15"></td>
			</tr>
			<tr>
				<th>상품 이미지1</th>
				<td><input type="file" name="product_image1"></td>
			</tr>
			<tr>
				<th>상품 이미지2</th>
				<td><input type="file" name="product_image2"></td>
			</tr>
			<tr>
				<th>상품 이미지3</th>
				<td><input type="file" name="product_image3"></td>
			</tr>
			<tr>
				<th>상품 내용</th>
				<td><input type="file" name="product_content1"></td>
			</tr>
			
			<tr>
				<th>할인율</th>
				<td><input type="number" name="discount_rate" min="0" max="90">%</td>
			</tr>
		</table>
		<div class="btns">
			<input type="button" value="상품 등록" id="btn_register">
			<input type="reset" value="다시 입력">
			<input type="button" value="상품 목록" id="btn_list">
			<input type="button" value="관리자 페이지" id="btn_main">
		</div>
	</form>
</div>
</body>
</html>