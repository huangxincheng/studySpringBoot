package com.iba;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@ServletComponentScan
@ImportResource(locations = {"classpath:druid/application-druid.xml"})
public class Application {

	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate() {
		//设置编码为utf8
		StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return builder.additionalMessageConverters(m).build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
