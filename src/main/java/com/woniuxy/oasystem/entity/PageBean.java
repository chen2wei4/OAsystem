package com.woniuxy.oasystem.entity;

import java.util.List;

//定义一个泛型类封装分页数据
public class PageBean<T> {
	private List<T> beanList;// 当前页显示的数据，数据查询
	private int pageSize;// 页大小,业务规则
	private int pageIndex;// 当前页索引，用户请求
	private int totalRecord;// 数据总条数，数据查询
	@SuppressWarnings("unused")
	private int totalPage;// 总页数,根据totalRecord和pageSize计算
	private int pageBegin;// 显示的开始页码
	private int pageEnd;// 显示的结束页码
	private String url; // 在哪赋值：Servlet

	public PageBean() {
		super();
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		// 如何计算:
		return (totalRecord % pageSize == 0) ? totalRecord / pageSize : totalRecord / pageSize + 1;
	}

	// 可以不要
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public void setPageBeginAndPageEnd() {
		if (getTotalPage() < 10) {
			pageBegin = 1;
			pageEnd = getTotalPage();
		} else {
			pageBegin = pageIndex - 5;
			pageEnd = pageIndex + 4;
			if (pageBegin < 1) {
				pageBegin = 1;
				pageEnd = 10;
			}
			if (pageEnd > getTotalPage()) {
				pageBegin = getTotalPage() - 9;
				pageEnd = getTotalPage();
			}
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "PageBean [beanList=" + beanList + ", pageSize=" + pageSize + ", pageIndex=" + pageIndex
				+ ", totalRecord=" + totalRecord + ", totalPage=" + getTotalPage() + ", pageBegin=" + pageBegin
				+ ", pageEnd=" + pageEnd + "]";
	}

}
