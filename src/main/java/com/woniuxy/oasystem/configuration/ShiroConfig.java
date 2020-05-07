/**
 * @author 陈一玮
 * @createDate 2020年5月5日
 */
package com.woniuxy.oasystem.configuration;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.woniuxy.oasystem.realm.UserRealm;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * @Description shiro配置类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年5月5日 下午5:01:56 [陈一玮]
 *            2.
 */
@Configuration
public class ShiroConfig {
	@Bean
	public UserRealm userRealm(CacheManager cacheManager) {
		UserRealm userRealm = new UserRealm();
//		CacheManager cacheManager,CredentialsMatcher credentialsMatcher
		userRealm.setCacheManager(cacheManager);
//		userRealm.setCredentialsMatcher(credentialsMatcher);
		return userRealm;
	}
	//配置安全管理器
	@Bean
	public DefaultWebSecurityManager defaultWebSecurityManager(UserRealm userRealm) {
		DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
		//关联Realm
		defaultWebSecurityManager.setRealm(userRealm);
		return defaultWebSecurityManager;
	}
	//配置shiro核心过滤器
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
		Map<String,String> filterMap=new LinkedHashMap<String,String>();
		filterMap.put("/emp/login", "anon");
		filterMap.put("/css/**", "anon");
		filterMap.put("/js/**", "anon");
		filterMap.put("/fonts/**", "anon");
		filterMap.put("/images/**", "anon");
		filterMap.put("/render", "anon");
		filterMap.put("/emp/logoff", "logout");
		filterMap.put("/**", "authc");
		shiroFilterFactoryBean.setLoginUrl("/");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}
	//配置授权缓存，使用内置的缓存
	@Bean
	public MemoryConstrainedCacheManager cacheManager() {
		return new MemoryConstrainedCacheManager();
	}
//	//配置凭证匹配器
//	public HashedCredentialsMatcher credentialsMatcher() {
//		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//		credentialsMatcher.setHashAlgorithmName("MD5");
//		credentialsMatcher.setHashIterations(1);
//		return credentialsMatcher;
//	}
	//配置thymeleaf支持权限标签的核心类
	//Dialect
	@Bean
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}
}
