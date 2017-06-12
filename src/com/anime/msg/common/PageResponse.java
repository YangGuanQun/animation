package com.anime.msg.common;

import java.io.Serializable;
import java.util.List;

public class PageResponse<T> extends ResultBean implements Serializable{

	private static final long serialVersionUID = -1024573678904607645L;

	private Integer totalCount;
	
	private Integer totalPage;
	
	private List<T> resultList;
	
	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "PageResponse [totalCount=" + totalCount + ", totalPage=" + totalPage + ", resultList=" + resultList
				+ "]";
	}

	
}
