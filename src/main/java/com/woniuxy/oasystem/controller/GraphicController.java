package com.woniuxy.oasystem.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.kaptcha.Kaptcha;

/**
 * 
 * @Description 图形验证码控制器
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月23日 下午2:52:55 [陈一玮]
 *            2.
 */
@Controller
public class GraphicController {
	@Autowired
    private Kaptcha kaptcha;
	/**
	 * 
	 * 生成图形化验证码的方法
	 * @param session 会话类
	 * @changeLog 1.创建 (2020年4月23日 下午2:53:25 [陈一玮]
	 *            2.
	 */
	@GetMapping("/render")
	@ResponseBody
    public void render(HttpSession session) {
        String render = kaptcha.render();
    }
}
