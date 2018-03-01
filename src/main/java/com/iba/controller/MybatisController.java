package com.iba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iba.entity.User;
import com.iba.service.UserService;

/**
 * Mybatis
 * @Title MybatisController
 * @Description :
 * @Author: ~琴兽~
 * @Date:2018年2月25日
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/all")
	public List<User> findAll() {
		return userService.findUserAllForMybatis();
	}
	
	@RequestMapping("/allForXml")
	public List<User> findAllForXml() {
		return userService.findUserAllForMybatisXml();
	}
}
