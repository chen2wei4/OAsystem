/**
 * @author 陈一玮
 * @createDate 2020年4月26日
 */
package com.woniuxy.oasystem.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 分页的实体类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月26日 上午10:10:24 [陈一玮]
 *            2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PageBean<T> {
	private List<T> beanList; //分页的所有数据集合
	private Integer beginPage; //分页的起始页
	private Integer pageSize; //分页的页大小
	private Integer endPage; //分页的结束页
	private Integer currentPage; //分页的当前页
	private Integer totalPage; //分页的总页数
	private Integer totalData; //总数据条数
	private String uri; //在哪赋值
	/**
	 * 设置页码索引(起始页和结束页)
	 * @changeLog 1.创建 (2020年4月26日 上午10:45:33 [陈一玮]
	 *            2.
	 */
	public void setBeginPageAndEndPage() {
		if(totalPage<=pageSize) {
			beginPage=1;
			endPage=totalPage;
		}else if(currentPage<=6){
			beginPage=1;
			endPage=pageSize;
		}else if(currentPage==totalPage) {
			beginPage=totalPage-pageSize;
			endPage=totalPage;
		}else {
			beginPage=currentPage-5;
			endPage=currentPage+4;
		}
	}
}
