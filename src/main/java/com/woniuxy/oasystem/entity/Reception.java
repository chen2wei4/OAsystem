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
public class Reception {
	//id	
	private Integer receptionId;	
    //接待人	
	private Emp emp;
	///接待内容  	
	private String receptionContent;
	//接待时间  	
	private String receptionTime;

}
