/**
 * @author 陈一玮
 * @createDate 2020年4月29日
 */
package com.woniuxy.oasystem.entity;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 合同信息实体类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月29日 下午2:17:48 [陈一玮]
 *            2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
	private Integer contractId;
	private String customerName;
	private String contractNumber;
	private String contractStatus;
	private Double contractMoney;
	private String contractName;
	private Date contractSetDate;
	private Date contractGetDate;
	private String contractDirector;
	private Integer flag;
	private ArrayList<Order> orders;
}
