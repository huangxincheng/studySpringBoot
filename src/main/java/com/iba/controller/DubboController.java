package com.iba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.iba.dubbo.DubboDemoService;

@RequestMapping("/dubbo")
@RestController
public class DubboController {

	//@Reference(version = "1.0.0")
	//private  DubboDemoService demoService;
	
	@RequestMapping
	public String sayHello() {
		//return demoService.sayHello();
		return "hello";
	}
}
