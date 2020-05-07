package com.woniuxy.oasystem.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author THY
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
	//主键
     private Integer informationId;
	//留言人id
	private Emp  emp;
	//被留言人id
	private Emp bemp;
	//留言内容
	private String informationContent;
	//留言时间
	private String informationTime;
}
