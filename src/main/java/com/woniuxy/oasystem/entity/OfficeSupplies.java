package com.woniuxy.oasystem.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private Integer osId;//主键
	private String osName;//办公用品名
	private Integer osNumber;//编号
	private String sort;//种类
	private Double prince;//价格
	private Date osTime;//入库时间
	private Integer number;//数量
	private String useState;//使用状态
	private String maintenance;//维护情况
	private String flag;//软删除
	
}
