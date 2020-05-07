/**  
 * @author 张钰平
 * @createDate 2020年5月7日
 */

package com.woniuxy.oasystem.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**  
 * @Description  TODO
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年5月7日 [张钰平])
 *              
 */
@Configuration
public class PathWebMvcConfig implements WebMvcConfigurer {
	/**
	 * 添加一些虚拟路径的映射
	 * 静态资源路径和上传文件的路径
	 *
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	      /**
	     * @Description: 对文件的路径进行配置, 创建一个虚拟路径/Path/** ，即只要在< img src="/Path/picName.jpg" />便可以直接引用图片
	     *这是图片的物理路径  "file:/+本地图片的地址"
	     */
	    registry.addResourceHandler("/Path/**").addResourceLocations("file:/C:/Users/小陽/Desktop/picture/");
	}
}
