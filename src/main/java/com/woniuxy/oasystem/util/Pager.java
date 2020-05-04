/**
 *
 */
package com.woniuxy.oasystem.util;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author THY唐昊宇事务模块
 *
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pager<E> {
	 //首页
	private  Integer pageBegin;
     //末页  
	 private  Integer pageEnd;	  
	// 总页数
	 private  Integer  totalPage;
	 //当前页码
	 private  Integer pageIndex;
	 //总条数
	 private  long total;
	 //分页结合
	 private List<E> pageList;
}
