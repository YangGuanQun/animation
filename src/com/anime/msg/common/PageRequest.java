package com.anime.msg.common;

import java.io.Serializable;

public class PageRequest<T> extends ResultBean implements Serializable{

	private static final long serialVersionUID = 4768343823426469838L;
	
	private Integer pageNum;
	
	private Integer pageSize;
	
	private String orderBy;
	
	private String orderMethod;

	public String getOrderMethod() {
		return orderMethod;
	}

	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageRequest [pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}
	
	public Integer getStartIndex(){
		return this.pageNum*this.pageSize;
	}
	
}
