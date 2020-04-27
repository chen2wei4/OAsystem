package com.woniuxy.oasystem.util;
/**
 * 
 * @Description  ajax返回结果工具类
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月23日 [张钰平])
 *
 */
public class CommonResult<T> {
	// 状态码
	private Integer stateCode;
	// 响应消息
	private String message;
	// 响应数据
	private T data;

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CommonResult [stateCode=" + stateCode + ", message=" + message + ", data=" + data + "]";
	}

	public CommonResult(Integer stateCode, String message, T data) {
		super();
		this.stateCode = stateCode;
		this.message = message;
		this.data = data;
	}

	public CommonResult() {
		super();
		// TODO Auto-generated constructor stub
	}
}
