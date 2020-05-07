/**
 * @author 陈一玮
 * @createDate 2020年5月1日
 */
package com.woniuxy.oasystem.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 订单实体类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年5月1日 上午2:52:17 [陈一玮]
 *            2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order { 
	private Integer orderId; 
	private OrderType orderType;
	private Contract contract;
	private String orderDirector;
	private String orderStatus;
	private String orderName;
	private String goodName;
	private String orderNumber;
	@DateTimeFormat(iso=ISO.DATE)
	private Date orderDate;
	private Integer goodNumber;
	private Integer flag;
}
