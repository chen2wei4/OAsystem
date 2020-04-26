package com.woniuxy.oasystem.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.kaptcha.Kaptcha;

@Controller
public class GraphicController {
	@Autowired
    private Kaptcha kaptcha;
	@GetMapping("/render")
	@ResponseBody
    public void render(HttpSession session) {
        String render = kaptcha.render();
        System.out.println(render);
    }
}
