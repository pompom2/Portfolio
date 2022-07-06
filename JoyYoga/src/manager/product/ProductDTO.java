package manager.product;

import java.sql.Timestamp;

//ProductDTO - 데이터를 객체로 저장하여 이동하는 클래스
//12개의 프로퍼티 - DB product 테이블과 매핑
//상품 아이디, 상품 종류, 상품 이름, 상품 가격, 상품 수량, 저자
//출판사, 출판일, 상품 이미지 이름, 상품 내용, 할인율, 등록 일시
public class ProductDTO {
	private int product_id;
	private String product_kind;
	private String product_name;
	private int product_price;
	private int product_count;
	private String product_brand;
	private String product_country;
	private String product_image1;
	private String product_image2;
	private String product_image3;
	private String product_content1;
	private int discount_rate;
	private Timestamp reg_date;

	public int getProduct_id() {
		return product_id;
	}

	public String getProduct_kind() {
		return product_kind;
	}

	public String getProduct_name() {
		return product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public int getProduct_count() {
		return product_count;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public String getProduct_country() {
		return product_country;
	}

	public String getProduct_image1() {
		return product_image1;
	}

	public String getProduct_image2() {
		return product_image2;
	}

	public String getProduct_image3() {
		return product_image3;
	}

	public String getProduct_content1() {
		return product_content1;
	}

	public int getDiscount_rate() {
		return discount_rate;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setProduct_kind(String product_kind) {
		this.product_kind = product_kind;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public void setProduct_country(String product_country) {
		this.product_country = product_country;
	}

	public void setProduct_image1(String product_image1) {
		this.product_image1 = product_image1;
	}

	public void setProduct_image2(String product_image2) {
		this.product_image2 = product_image2;
	}

	public void setProduct_image3(String product_image3) {
		this.product_image3 = product_image3;
	}

	public void setProduct_content1(String product_content1) {
		this.product_content1 = product_content1;
	}

	public void setDiscount_rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", product_kind=" + product_kind + ", product_name="
				+ product_name + ", product_price=" + product_price + ", product_count=" + product_count
				+ ", product_brand=" + product_brand + ", product_country=" + product_country + ", product_image1="
				+ product_image1 + ", product_image2=" + product_image2 + ", product_image3=" + product_image3
				+ ", product_content1=" + product_content1 + ", discount_rate=" + discount_rate + ", reg_date="
				+ reg_date + "]";
	}

}
