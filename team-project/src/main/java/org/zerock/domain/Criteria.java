package org.zerock.domain;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

@Getter

public class Criteria {
	
	private int page;
	private String type,keyword;
	

	public Criteria() {
		this.page = 1;
	}
	
	public Criteria(int page) {
		this.page = page;
	}
	
	public int getSkip() {
		return (page - 1) * 10;
	}
	
	public String[] getArr() {
		return type.split("-");
	}


	public void setPage(int page) {
		this.page = page;
		if(page <= 0) {
			this.page = 1;
		}
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	public String makeURL() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("page=");
		builder.append(page);
		
		if(type != null) {
			builder.append("&");
			builder.append("type=");
			builder.append(type);
		}
		if(keyword != null) {
			builder.append("&");	
			builder.append("keyword=");
			builder.append(keyword);
		}
		return builder.toString();
	}
	
	

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", type=" + type + ", keyword=" + keyword + "]";
	}
}
