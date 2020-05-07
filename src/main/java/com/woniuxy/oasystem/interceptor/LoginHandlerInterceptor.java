<<<<<<< HEAD
/**
 * @author 陈一玮
 * @createDate 2020年5月6日
 */
package com.woniuxy.oasystem.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description 登录拦截器
 * @author 陈一玮
 * @changeLog 1.创建 (2020年5月6日 下午4:44:02 [陈一玮]
 *            2.
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{

	//当session失效，返回登录页面
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			HttpSession sesssion = request.getSession();
			Object emp = sesssion.getAttribute("emp");
			if(emp==null) {
				request.setAttribute("loginMsg", "登录已超时");
				request.getRequestDispatcher("/").forward(request, response);
				return false;
			}else {
				return true;
			}
		}

}
=======
/**
 * @author 陈一玮
 * @createDate 2020年5月6日
 */
package com.woniuxy.oasystem.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description 登录拦截器
 * @author 陈一玮
 * @changeLog 1.创建 (2020年5月6日 下午4:44:02 [陈一玮]
 *            2.
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{
	//当session失效，返回登录页面
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession sesssion = request.getSession();
		Object emp = sesssion.getAttribute("emp");
		if(emp==null) {
			request.setAttribute("loginMsg", "登录已超时");
			request.getRequestDispatcher("/").forward(request, response);
			return false;
		}else {
			return true;
		}
	}

}
>>>>>>> branch 'master' of https://github.com/chen2wei4/OAsystem.git
