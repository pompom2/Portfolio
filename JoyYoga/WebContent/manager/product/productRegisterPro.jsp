<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="manager.product.*, java.util.*" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 처리</title>
</head>
<body>
<% 
request.setCharacterEncoding("utf-8");

// 폼의 입력 정보 획득
// 파일 업로드 폼 -> cos.jar 라이브러리의 MultipartRequest 클래스를 사용
// request, 업로드 폴더, 파일의 최대크기, encType, 파일명 중복정책
String realFolder ="c:/images_joyyoga";
int maxSize = 1024 * 1024 * 5; // 5MB
String encType = "utf-8";

MultipartRequest multi = null;

try {
	 multi = new MultipartRequest(request, realFolder, maxSize,
			 encType, new DefaultFileRenamePolicy());
	 List<String> fileNameList = new ArrayList<String>();
	 Enumeration<?> files = multi.getFileNames();
	 while(files.hasMoreElements()) {
		 String name = (String)files.nextElement();
		 String fileName = multi.getFilesystemName(name);
		 System.out.println("파일 이름 : " + fileName);
		 fileNameList.add(fileName);
		 
	 }
	 
	// 폼에서 넘어오는 10개의 필드 값을 획득 - 제외) product_id, reg_date
	String product_kind = multi.getParameter("product_kind");
	String product_name = multi.getParameter("product_name");
	int product_price = Integer.parseInt(multi.getParameter("product_price"));
	int product_count = Integer.parseInt(multi.getParameter("product_count"));
	String product_brand = multi.getParameter("product_brand");
	String product_country = multi.getParameter("product_country");
	//String product_image = multi.getParameter("product_image"); // 여기에는 이름을 얻을 수 없음.
	int discount_rate = Integer.parseInt(multi.getParameter("discount_rate"));
	
	// ProductDTO 객체 생성하고 setter 메소드를 사용하여 값을 설정
	ProductDTO product = new ProductDTO();
	product.setProduct_kind(product_kind);
	product.setProduct_name(product_name);
	product.setProduct_price(product_price);
	product.setProduct_count(product_count);
	product.setProduct_brand(product_brand);
	product.setProduct_country(product_country);
	product.setProduct_image1(fileNameList.get(3)); // 업로드한 파일의 실제 이름
	product.setProduct_image2(fileNameList.get(2));
	product.setProduct_image3(fileNameList.get(1));
	product.setProduct_content1(fileNameList.get(0));
	product.setDiscount_rate(discount_rate);
	
	//System.out.println("product 객체: " + product);
	
	// DB 연결, product 테이블에 상품 추가 처리
	ProductDAO productDAO = ProductDAO.getInstance();
	productDAO.insertProduct(product);
	response.sendRedirect("productList.jsp");

} catch(Exception e) {
	System.out.println("productRegisterPro.jsp 파일: " + e.getMessage());
	e.printStackTrace();
}


%>
</body>
</html>