package com.iba.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 解决跨域
 * @Title CorsApiController
 * @Description :
 * @Author: ~琴兽~
 * @Date:2018年2月24日
 */
@RestController
@RequestMapping(value = "/corsApi", method = RequestMethod.POST)
public class CorsApiController {

	@RequestMapping
	public String index() {
		return "corsApi";
	}
	
	@CrossOrigin(origins = "http://localhost:8082")
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
