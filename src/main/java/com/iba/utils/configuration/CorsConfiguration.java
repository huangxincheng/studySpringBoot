package com.iba.utils.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 全局设置cors跨域
 * 	解决js跨域请求问题
 * @Title CorsConfiguration
 * @Description :
 * @Author: ~琴兽~
 * @Date:2018年2月22日
 */
@SpringBootConfiguration
public class CorsConfiguration {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// 限制了路径和域名的访问
				registry.addMapping("/corsApi/**").allowedOrigins("http://localhost:8081");
			}
		};
	}
}
