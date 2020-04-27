package com.woniuxy.oasystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一的AJAX响应格式
 * @author Lwp
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseResult<T> {
	//响应状态码
	private Integer stateCode;
	//响应消息
	private String message;
	//响应数据
	private T data;
	
}
