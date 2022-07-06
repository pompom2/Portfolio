<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="manager.product.*, java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Luckiest+Guy&display=swap');
@import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300&display=swap');
#container { width: 550px; margin: 0 auto;}
a { text-decoration: none; color: black; }
/* 상단 - 메인, 서브 타이틀 */
.m_title { font-family: 'Luckiest Guy', cursive; font-size: 50px; margin-bottom: 10px;text-align: center;}
.s_title { font-family: 'IBM Plex Sans KR', sans-serif;  font-weight: bold; font-size: 1.7em; text-align: center; margin-bottom: 30px; }
.c_logout { text-align: center; margin-bottom: 20px; font-size: 0.9em; font-weight: bold;}
.c_logout a { color: #54d6c1; }
/* 중단 - 상품 등록 테이블 */
.c_p_id, .c_p_reg_date{ background: #dee2e6;}
.s_p_id, .s_p_reg_date { color: #f00; font-size: 0.8em; font-weight: bold; margin-left: 10px;}
.s_p_image { color: #00f; font-size: 0.8em;}
table { width: 100%; border: 1px solid #d5ba99; border-collapse: collapse;
border-top: 5px solid #d5ba99; border-bottom: 5px solid #d5ba99; border-left: hidden; border-right: hidden;}
tr { height: 35px;}
td, th { border: 1px solid #d5ba99; }
th { background: #f7f8f0; }
td { padding-left: 5px;}
/* 중단 - 테이블 안의 입력상자 */
input[type="number"] { width: 100px; }
textarea { margin: 5px 0 2px 0; }
/* 하단 - 버튼 */
select { height: 24px; }
input::file-selector-button {width: 80px; height: 28px; background:#d5ba99; color: #fff; border: none; 
border-radius: 3px; font-weight: bold; cursor: pointer;}
.btns{ text-align: center; margin-top: 20px;}
.btns input{ width : 100px; height: 37px; border: none; background: #d5ba99; color: #fff; 
font-weight: bold; margin: 5px; cursor: pointer; }
.btns input:nth-child(1), .btns input:nth-child(2) { background:#c89072;}
.btns input:nth-child(1):hover, .btns input:nth-child(2):hover { border: 2px solid #c89072; background: #fff; color: #c89072; font-weight: bold; }
</style>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		let form = document.updateForm;
		
		// 상품 분류가 선택되도록 설정 - ex) 자기계발: 310
		let product_kind = form.product_kind; // select 태그
		let p_kind = form.p_kind;			   // ex) 자기계발: 310이 있는 input 태그
		for(let i=0; i<product_kind.length; i++) {
			if(p_kind.value == product_kind[i].value) {
				product_kind[i].selected = true;
				break;
			}
		}
			
		// 상품 수정 처리  폼 페이지로 이동
		let btn_update = document.getElementById("btn_update");
		btn_update.addEventListener("click", function() {
			
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
		
		// 상품 삭제 처리 페이지로 이동
		let product_id = form.product_id.value;
		let btn_delete = document.getElementById("btn_delete");
		btn_delete.addEventListener("click", function() {
			location = 'productDeletePro.jsp?product_id=' + product_id + "&pageNum=" + pageNum;
		})
		
		
		// 상품 수정 처리 페이지로 이동
		let product_id = form.product_id.value;
		let btn_delete = document.getElementById("btn_update");
		btn_delete.addEventListener("click", function() {
			location = 'productUpdatePro.jsp?product_id=' + product_id + "&pageNum=" + pageNum;
		})
		
		// 상품 목록 페이지로 이동
		let btn_list = document.getElementById("btn_list");
		btn_list.addEventListener("click", function() {
			location = 'productList.jsp?pageNum=' + pageNum;
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

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

String pageNum = request.getParameter("pageNum");
int product_id = Integer.parseInt(request.getParameter("product_id"));

// DB 연결, 질의
ProductDAO productDAO = ProductDAO.getInstance();
ProductDTO product = productDAO.getProduct(product_id);
%>
<div id="container">
	<div class="m_title"><a href="../managerMain.jsp">Joy Yoga!</a></div>
	<div class="s_title">상품 정보 확인</div>
	
	<form action="productUpdatePro.jsp" method="post" name="updateForm" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<table>
			<tr>
				<th>상품번호</th>
				<td>
					<input type="text" name="product_id" value="<%=product.getProduct_id()%>" size="11" readonly class="c_p_id">
					<span class="s_p_id">상품번호는 변경불가</span>
				</td>
					
			</tr>
			<tr>
				<th width="20%">상품 분류</th>
				<td width="80%">
					<input type="hidden" name="p_kind" value= "<%=product.getProduct_kind()%>">
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
				<td><input type="text" name="product_name" size="58" value="<%=product.getProduct_name()%>"></td>
			</tr>
			<tr>
				<th>상품 가격</th>
				<td><input type="number" name="product_price" min="1000" max="1000000" value="<%=product.getProduct_price()%>">원</td>
			</tr>
			<tr>
				<th>상품 수량</th>
				<td><input type="number" name="product_count" min="0" max="100000" value="<%=product.getProduct_count()%>">권</td>
			</tr>
			<tr>
				<th>제조사</th>
				<td><input type="text" name="product_brand" value="<%=product.getProduct_brand()%>"></td>
			</tr>
			<tr>
				<th>원산지</th>
				<td><input type="text" name="product_country" value="<%=product.getProduct_country()%>"></td>
			</tr>
			<tr>
				<th>상품 이미지1</th>
				<td>
					<input type="file" name="product_image1"><br>
					<span class="s_p_image">상품 이미지를 다시 선택해 주세요.</span>
				</td>
			</tr>
			<tr>
				<th>상품 이미지2</th>
				<td>
					<input type="file" name="product_image2"><br>
					<span class="s_p_image">상품 이미지를 다시 선택해 주세요.</span>
				</td>
			</tr>
			<tr>
				<th>상품 이미지3</th>
				<td>
					<input type="file" name="product_image3"><br>
					<span class="s_p_image">상품 이미지를 다시 선택해 주세요.</span>
				</td>
			</tr>
			<tr>
				<th>상품 내용</th>
				<td>
					<input type="file" name="product_content1"><br>
					<span class="s_p_content">상품 내용을 다시 선택해 주세요.</span>
				</td>
			</tr>
			<tr>
				<th>할인율</th>
				<td><input type="number" name="discount_rate" min="0" max="90" value=<%=product.getDiscount_rate() %>>%</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>
					<input type="text" name="reg_date" value="<%=sdf.format(product.getReg_date())%>" size="10" readonly class="c_p_reg_date">
					<span class="s_p_reg_date">등록일은 변경 불가</span>
				</td>
			</tr>
		</table>
		<div class="btns">
			<input type="button" value="상품 정보 수정" id="btn_update">
			<input type="button" value="상품 정보 삭제" id="btn_delete">
			<input type="button" value="상품 목록" id="btn_list">
			<input type="button" value="관리자 페이지" id="btn_main">
		</div>
	</form>
</div>
</body>
</html>