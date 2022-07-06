package com.springbook.biz.board;

// 페이지 블록 시작 번호, 개수, 페이지 번호 설정하는 클래스
public class BlockDTO {
	private int pageNum; // 현재 페이지 번호
	private int amount; // 보여줄 페이지 개수
	private int startNum; // 페이지의 시작 게시글의 번호

	public BlockDTO() {
		this(1, 10);	// 기본값 세팅, 1페이지 10개
	}

	public BlockDTO(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	@Override
	public String toString() {
		return "BlockDTO [pageNum=" + pageNum + ", amount=" + amount + ", startNum=" + startNum + "]";
	}

}
