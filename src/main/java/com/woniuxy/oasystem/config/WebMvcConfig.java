package com.woniuxy.oasystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 配置webconfig
 * @author Administrator
 *
 */
@Configuration
public class WebMvcConfig {
	
	@Bean
	public WebMvcConfigurer mvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				//注册自定义映射路径
				registry.addViewController("/index.html").setViewName("index");
				registry.addViewController("/").setViewName("index");
			}
		};
	}
}
