package com.woniuxy.oasystem.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @Description  办公用品实体类
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月22日 [张钰平])
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeSupplies {
	private Integer osId;
	private String osName;
	private String osNumber;
	private String sort;
	private Double prince;
	private Date osTime;
	private Integer number;
	private String useState;
	private String maintenance;
	private String flag;
	
}
