package org.zerock.domain;

import lombok.Data;

@Data
public class PageMaker {
	private Criteria cri;
	private int totalCount;
	private double pagePerCount = 10;
	private int startPage, endPage;
	private boolean prev, next;
	
	public PageMaker(Criteria cri, int totalCount) {
		this.cri = cri;
		this.totalCount = totalCount;
		setUp();
	}
	
	
	public void setUp() {
		this.endPage = (int) (Math.ceil(cri.getPage() / 10.0) * 10);
		this.startPage = (endPage -10) + 1;
		int tempEnd = (int) (Math.ceil(totalCount / pagePerCount));
		if(endPage > tempEnd) {
			endPage = tempEnd;
		}	
		this.prev = startPage != 1? true : false;
		this.next = endPage * 10 < totalCount ? true: false;
	}
	
	
	
	
	

}
