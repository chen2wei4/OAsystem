/**
 * @author 陈一玮
 * @createDate 2020年4月24日
 */
package com.woniuxy.oasystem.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 客户信息实体类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月24日 下午4:54:57 [陈一玮]
 *            2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private Integer customerId; //客户编号id
	private String customerName; //客户姓名
	private String customerSex; //客户性别
	private String customerCompany; //客户公司
	private CustomerType customerType; //客户公司类型
	private String customerPosition; //客户职位
	private String customerTel; //客户手机
	private String customerEmail; //客户邮箱
	private String customerDirector; //客户负责人
	private Date customerTime; //客户信息创建时间
	private Integer flag; //软删除
}
