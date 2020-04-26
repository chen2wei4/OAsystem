package com.woniuxy.oasystem.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig {
	@Bean
	public WebMvcConfigurer oaConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
					registry.addViewController("/").setViewName("lyear_pages_login");
					registry.addViewController("/index").setViewName("index");
		}
	};
}
}