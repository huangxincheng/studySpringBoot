package com.iba.dubbo.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.iba.dubbo.DubboDemoService;

@Service
(
        version = "1.0.0"
//        application = "${dubbo.application.id}",
//        protocol = "${dubbo.protocol.id}",
//        registry = "${dubbo.registry.id}"
)
public class DubboDemoServiceImpl implements DubboDemoService{

	@Override
	public String sayHello() {
		return "say hello";
	}

}
