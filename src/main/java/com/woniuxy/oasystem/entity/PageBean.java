package com.woniuxy.oasystem.entity;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @Description  分页实体类
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月23日 [张钰平])
 *
 */
@Component
public class PageBean<T> {
	private List<T> beanList;//当前页数据
	private Integer pageSize;//页大小
	private Integer pageIndex;//当前页
	private Integer totalRecord;//数据总条数
	private Integer totalPage;//总页数
	private Integer pageBegin;//开始页码
	private Integer pageEnd;//结束页码
	private String url;
	
	public PageBean() {
		super();
	}
	
	public PageBean(List<T> beanList, Integer pageSize, Integer pageIndex, Integer totalRecord, Integer totalPage,
			Integer pageBegin, Integer pageEnd, String url) {
		super();
		this.beanList = beanList;
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.pageBegin = pageBegin;
		this.pageEnd = pageEnd;
		this.url = url;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(Integer pageBegin) {
		this.pageBegin = pageBegin;
	}

	public Integer getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
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
				+ ", totalRecord=" + totalRecord + ", totalPage=" + totalPage + ", pageBegin=" + pageBegin
				+ ", pageEnd=" + pageEnd + ", url=" + url + "]";
	}

	public void setPageBeginAndPageEnd() {
		if(totalPage<10) {
			pageBegin=1;
			pageEnd=totalPage;
		}else {
			pageBegin=pageIndex-5;
			pageEnd=pageIndex+4;
			if(pageBegin<1) {
				pageBegin=1;
				pageEnd=10;
			}
			if(pageEnd>totalPage) {
				pageBegin=totalPage-9;
				pageEnd=totalPage;
			}
		}
	}
	/**
	 * 设置页码索引(起始页和结束页)
	 * @changeLog 1.创建 (2020年4月26日 上午10:45:33 [陈一玮]
	 *            2.
	 */
	public void setBeginPageAndEndPage() {
		if(totalPage<=pageSize) {
			pageBegin=1;
			pageEnd=totalPage;
		}else if(pageIndex<=6){
			pageBegin=1;
			pageEnd=pageSize;
		}else if(pageIndex==totalPage) {
			pageBegin=totalPage-pageSize;
			pageEnd=totalPage;
		}else {
			pageBegin=pageIndex-5;
			pageEnd=pageIndex+4;
		}
	}
}