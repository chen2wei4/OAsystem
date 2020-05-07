/**
 * @author 陈一玮
 * @createDate 2020年5月7日
 */
package com.woniuxy.oasystem.exceptionhandler;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description TODO
 * @author 陈一玮
 * @changeLog 1.创建 (2020年5月7日 上午11:14:36 [陈一玮]
 *            2.
 */
@ControllerAdvice
public class BaseController {
	@ExceptionHandler
	public ModelAndView authorizationExceptionResolve(Exception ex) {
		ModelAndView mv=new ModelAndView();
		if(ex instanceof AuthorizationException) {
			System.out.println("授权异常");
		}
		return mv;
	}
}
