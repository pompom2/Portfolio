<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 쇼핑몰 상단 페이지 : 쇼핑몰의 모든 페이지 상단에 포함되는 페이지 --%>

<style>
@import url('https://fonts.googleapis.com/css2?family=Luckiest+Guy&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Barriecito&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');
/* 전체 레이아웃 */
.top a { text-decoration: none; color: #000;}
.t_box1, .t_box2, .t_box3, .t_box4 { display: inline-block; padding: 2%;}
.t_box1, .t_box3 { width: 60%;}
.t_box2, .t_box4 { width: 30%;}
/* 구역1(상단 좌측): 타이틀, 검색 */
.t_box1 .m_title { font-family:  'Luckiest Guy', cursive; font-size: 50px; text-align: center; margin-left: 100px;}
.t_box1 .t_search { width: 400px; text-align: center; margin-top: 30px; margin-left: 220px; 
border-bottom: 1px solid #000;  padding: 5px;}
.t_box1 .t_search #keyword {  font-family: 'Hi Melody', cursive; height: 38px; width: 300px; border: none; font-size: 1.1em; font-size: 0.9em;}
.t_box1 .t_search #keyword:focus { outline: none;}
.t_box1 .t_search button { border: none; cursor: pointer; background: #fff; float: right; margin: 3px 20px 0 0;}
/* 구역2(상단 우측): 회원정보, 구매정보, 장바구니정보 */
.t_box2 { float: right; text-align: right; line-height: 100px;}
/* 구역3(하단 좌측): 메인메뉴(하위메뉴) */
.t_box3 { float: left; position: relative;}
.m_menu0 { display: inline-block;}
.m_menu0 .m_menu_img:hover  { content: url('../../icons/menu2.png');}
.m_menu { display: inline-block;}
.m_menu a { font-family: 'Barriecito', cursive; color:gray; font-size: 30px; width: 100px; padding: 5px; margin: 20px; }
.s_menu { display: none; position: absolute; top: 55px; width: 140px; z-index: 10; background: black; border-radius: 3px; }
.sm1 { left: 20px;}
.sm2 { left: 130px;}
.sm3 { left: 250px;}
.sm4 { left: 370px;}
.sm5 { left: 500px;}
.m_menu:hover .s_menu { display: block;}
.s_menu div { padding: 10px 0;}
.s_menu div a { font-family: 'Hi Melody', cursive; font-size: 0.9em; color: white;}
/* 구역4(하단 우측): 로그인, 회원가입, 고객센터 */
.t_box4 { float: right; text-align: right;}
.t_box4 a { font-family: 'Hi Melody', cursive; color: black; font-size: 0.9em; font-weight: bold;}
.top_end { clear: both;}
</style>
<script>
<%
String memberId = (String)session.getAttribute("memberId");

%>
</script>
<div class="top">
	<div class="t_box1"> <%-- 구역1(상단 좌측): 타이틀, 검색 --%>
		<div class="m_title"><a href="../shopping/shopAll.jsp">Joy Yoga!</a></div>
		<div class="t_search">
			<form action="" method="post" name="searchForm">
				<input type="search" name="keyword" id="keyword" placeholder="제품을 입력하세요.">
				<button type="submit"><img src="../../icons/search.png" width="30" height="30"></button>
			</form>
		</div>
	</div>
	<div class="t_box2"> <%-- 구역2(상단 우측): 회원정보, 구매정보, 장바구니정보 --%>
		<a href="../member/memberInfoForm.jsp"><img src="../../icons/user.png" width="40" 
		height="40" title="회원정보" class="t_b2_img1"></a>&emsp;&emsp;
		<a href="../buy/buyList.jsp"><img src="../../icons/sale.png" width="40" title="구매정보" class="t_b2_img2">
		</a>&emsp;&emsp;
		<a href="../cart/cartList.jsp"><img src="../../icons/trolley.png" width="40" 
		title="장바구니정보" class="t_b2_img3"></a>
	</div>
	<div class="t_box3"> <%-- 구역3(하단 좌측): 메인메뉴(하위메뉴) --%>
		<div class="m_menu0"></div>
		<div class="m_menu mm1">
			<a href="#">Mat</a>
			<div class="s_menu sm1">
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=110#t_kind">요가 매트</a></div>
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=120#t_kind">타월</a></div>
			</div>
		</div>
		<div class="m_menu mm2">
			<a href="#">Wear</a>
			<div class="s_menu sm2">
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=210#t_kind">상의</a></div>
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=220#t_kind">하의</a></div>
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=230#t_kind">요가 양말</a></div>
			</div>
		</div>
		<div class="m_menu mm3">
			<a href="#">Props</a>
			<div class="s_menu sm3">
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=310#t_kind">요가블럭</a></div>
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=320#t_kind">스트랩</a></div>
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=330#t_kind">덤벨&케틀벨</a></div>
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=340#t_kind">짐볼&웨이트볼</a></div>
			</div>
		</div>
		<div class="m_menu mm4">
			<a href="#">Accs</a>
			<div class="s_menu sm4">
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=410#t_kind">가방&슬링</a></div>
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=420#t_kind">아이필로우</a></div>
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=430#t_kind">요가밴드</a></div>
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=440#t_kind">마사지볼</a></div>
			</div>
		</div>
		<div class="m_menu mm5">
			<a href="#">Diet Food</a>
			<div class="s_menu sm5">
				<div><a href="/JoyYoga/mall/shopping/shopAll.jsp?product_kind=510#t_kind">다이어트 식품</a></div>
			</div>	
		</div>
	</div>
	<div class="t_box4"> <%-- 구역4(하단 우측): 로그인, 회원가입, 고객센터 ... --%>
		<%if(memberId == null)  {%>
		<a href="../logon/memberLoginForm.jsp"><span>로그인</span></a>&ensp;|&ensp;
		<a href="../member/memberJoinForm.jsp"><span>회원가입</span></a>&ensp;|&ensp;
		<%} else {%>
		<a href="../member/memberInfoForm.jsp"><%=memberId %>님</a>&ensp;|&ensp;<a href="../logon/memberLogout.jsp">로그아웃</a>&ensp;|&ensp;
		<%} %>
		
	
		<a href="#"><span>고객센터</span></a>
	</div>
</div>
<hr class="top_end">