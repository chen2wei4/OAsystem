/**
 * @author 陈一玮
 * @createDate 2020年5月1日
 */
package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 订单类型实体类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年5月1日 上午2:53:43 [陈一玮]
 *            2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderType {
	private Integer orderTypeId; //订单类型id
	private String orderTypeName; //订单类型名称
	private Integer flag; //软删除
}
