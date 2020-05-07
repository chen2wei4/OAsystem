/**
 *
 */
package com.woniuxy.oasystem.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author THY唐昊宇事务模块
 *
 */
@ControllerAdvice
public class ControllerException {
   //空指针异常
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exception(NullPointerException ex) {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("errorcode",404);
		mv.addObject("error","找不到页面");
		mv.setViewName("lyear_pages_error");
		return mv;
	}
	//异常
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception ex) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("errorcode",500);
		mv.addObject("error","系统出错");
		mv.setViewName("lyear_pages_error");
		return mv;
	}
}
