package com.woniuxy.oasystem.util;
/**
 * 
 * @Description 正则表达式工具类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月23日 下午2:56:34 [陈一玮]
 *            2.
 */
public class RegexUtil {
	
	public final static String isMath="^\\d*$";
	public final static String isCellNumber="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
	public final static String isEmail="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	public final static String isPwd="^[0-9A-Za-z]{8,16}$";
	
}
