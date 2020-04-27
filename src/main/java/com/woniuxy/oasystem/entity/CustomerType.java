/**
 * @author 陈一玮
 * @createDate 2020年4月26日
 */
package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 客户类型实体类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月26日 下午4:21:02 [陈一玮]
 *            2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerType {
	private Integer customerTypeId; //客户类型id
	private String customerTypeName; //客户类型名称
	private Integer flag; //软删除
}
