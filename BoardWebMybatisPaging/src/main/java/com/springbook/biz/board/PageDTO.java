package com.springbook.biz.board;

// 이전, 다음, 시작 페이지, 끝 페이지를 설정하는 클래스
public class PageDTO {
	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	private boolean prev, next; // 이전, 다음 동작 유무
	private int total; // 전체 글 수
	private BlockDTO block;
	private int pageCount; // 전체 페이지 수

	public PageDTO(BlockDTO block, int total) {
		this.block = block;
		this.total = total;
		
		this.pageCount = total / block.getAmount() 
				+ (total % block.getAmount() == 0 ? 0 : 1); //전체 페이지수
		
		//#############
		
		this.endPage = (int) (Math.ceil(block.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;

		int endPage2 = (int) (Math.ceil(total * 1.0) / block.getAmount())
				+ ((Math.ceil(total * 1.0) / block.getAmount()) == 0 ? 0 : 1); // 실제 endPage
		if (endPage2 < this.endPage)
			this.endPage = endPage2;

		this.prev = this.startPage > 1;
		this.next = this.endPage < endPage2;
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public BlockDTO getBlock() {
		return block;
	}

	public void setBlock(BlockDTO block) {
		this.block = block;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", block=" + block + ", pageCount=" + pageCount + "]";
	}


}
