/**
 * 
 */
package com.woniuxy.oasystem.entity;

import java.util.Date;

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
public class Apply {
	//id
	private  Integer applyId;	
	//申请人id	
	private  Emp emp;
	//申请类型
	private Applytype applytype;
	//申请内容
	private String applyContent;
	//申请时间
	private String applyTime;
	//申请状态
	private  Integer  applyCheck;	

}
