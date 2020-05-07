package com.woniuxy.oasystem.entity;

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
public class Applytype {
	//id	
	private Integer applytypeId;
	//申请类型名称  	
	private String applytypeName;
}
